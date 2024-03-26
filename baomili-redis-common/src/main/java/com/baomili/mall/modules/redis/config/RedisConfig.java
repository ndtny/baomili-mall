package com.baomili.mall.modules.redis.config;

import com.baomili.mall.modules.redis.utils.RedisSingleUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    private static final String HOST = "101.132.155.185";
    private static final Integer PORT = 6379;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789";

    private static final Integer min_idle = 1;
    private static final Integer max_idle = 10;
    private static final Integer max_active = 10;
    private static final Integer max_wait = 60000;


    @Bean("redisSinglePool")
    public GenericObjectPoolConfig redisSinglePool() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMinIdle(min_idle);
        config.setMaxIdle(max_idle);
        config.setMaxTotal(max_active);
        config.setMaxWaitMillis(max_wait);
        return config;
    }

    @Bean("redisSingleConfig")
    public RedisStandaloneConfiguration redisSingleConfig() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(HOST, PORT);
        configuration.setPassword(PASSWORD);
        return configuration;
    }

    @Bean("redisFactorySingle")
    public LettuceConnectionFactory redisFactorySingle(@Qualifier("redisSinglePool") GenericObjectPoolConfig config,
                                                       @Qualifier("redisSingleConfig") RedisStandaloneConfiguration redisConfig) {//注意传入的对象名和类型RedisStandaloneConfiguration
        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(config).build();
        return new LettuceConnectionFactory(redisConfig, clientConfiguration);
    }


    /**
     * 单实例redis数据源
     *
     * @param connectionFactory
     * @return
     */
    @Bean("redisSingleTemplate")
    public RedisTemplate<String, Object> redisSingleTemplate(
            @Qualifier("redisFactorySingle")LettuceConnectionFactory connectionFactory) {
        return redisTemplateSerializer(connectionFactory);
    }

    @Bean
    public RedisSingleUtil redisSingleUtil(){
        return new RedisSingleUtil();
    }

    private RedisTemplate<String, Object> redisTemplateSerializer(RedisConnectionFactory connectionFactory){
        RedisTemplate<String,Object> template = new RedisTemplate();
        template.setConnectionFactory(connectionFactory);
        // 序列化工具
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer
                = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);

        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.afterPropertiesSet();
        return template;
    }
}
