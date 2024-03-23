package com.baomili.mall;

import com.baomili.mall.modules.admin.dto.UmsUserDto;
import com.baomili.mall.modules.admin.service.UmsUserService;
import com.baomili.mall.modules.admin.vo.UmsUserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AdminTest {

    @Resource
    private UmsUserService umsUserService;

    @Test
    public void test() {
        UmsUserDto umsUserDto = new UmsUserDto();
        umsUserDto.setUserName("David");
        umsUserDto.setIdentityId("David");
        umsUserDto.setCredential("123456");
        UmsUserVo userVo = umsUserService.register(umsUserDto);
        log.info("userVo：{}", userVo);
    }
}
