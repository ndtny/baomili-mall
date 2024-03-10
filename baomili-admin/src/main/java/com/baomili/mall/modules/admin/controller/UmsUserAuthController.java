package com.baomili.mall.modules.admin.controller;

import com.baomili.mall.modules.admin.service.UmsUserAuthService;
import com.baomili.mall.modules.admin.vo.UmsUserAuthVo;
import com.baomili.mall.modules.admin.vo.UmsUserBaseVo;
import com.baomili.mall.modules.admin.vo.UserInfo;
import com.baomili.mall.modules.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("info")
    public CommonResult<UserInfo> getUserInfo(String username) {
        UserInfo userInfo = new UserInfo();
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("other");
        userInfo.setName(username);
        userInfo.setRoles(roles);
        return CommonResult.success(userInfo);
    }

}

