package com.baomili.mall.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashSet;

@Data
@ConfigurationProperties("baomili.gateway")
public class AuthProperties {

    private LinkedHashSet<String> shouldSkipUrls;

}
