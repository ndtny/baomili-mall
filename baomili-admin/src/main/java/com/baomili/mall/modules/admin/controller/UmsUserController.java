package com.baomili.mall.modules.admin.controller;


import com.baomili.mall.modules.admin.dto.UmsUserAuthDto;
import com.baomili.mall.modules.admin.dto.UmsUserDto;
import com.baomili.mall.modules.admin.service.UmsUserService;
import com.baomili.mall.modules.admin.vo.UmsUserVo;
import com.baomili.mall.modules.admin.vo.UserInfo;
import com.baomili.mall.modules.common.api.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@RestController
@RequestMapping("/admin/umsUser")
public class UmsUserController {

    @Resource
    private UmsUserService umsUserService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public CommonResult<UmsUserVo> register(@RequestBody UmsUserDto userDto) {
        UmsUserVo umsUserVo = null;
        try {
            umsUserVo = umsUserService.register(userDto);
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(umsUserVo);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public CommonResult<UmsUserVo> login(@RequestBody UmsUserAuthDto userAuthDto) {
        UmsUserVo umsUserVo = null;
        try {
            umsUserVo = umsUserService.login(userAuthDto);
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(umsUserVo);
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

