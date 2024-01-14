package com.baomili.mall.modules.admin.controller;

import com.baomili.mall.modules.admin.service.UmsUserAuthService;
import com.baomili.mall.modules.admin.vo.UmsUserAuthVo;
import com.baomili.mall.modules.admin.vo.UmsUserBaseVo;
import com.baomili.mall.modules.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户授权信息表 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-01-07
 */
@RestController
@RequestMapping("/admin/umsUserAuth")
public class UmsUserAuthController {

    @Resource
    private UmsUserAuthService userAuthService;

    @PostMapping("/login")
    public CommonResult<UmsUserBaseVo> login(@RequestBody UmsUserAuthVo userAuthVo) {
        UmsUserBaseVo umsUserBaseVo = userAuthService.login(userAuthVo);
        return CommonResult.success(umsUserBaseVo);
    }

}

