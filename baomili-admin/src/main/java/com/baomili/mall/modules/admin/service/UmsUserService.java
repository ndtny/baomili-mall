package com.baomili.mall.modules.admin.service;

import com.baomili.mall.modules.admin.dto.UmsUserAuthDto;
import com.baomili.mall.modules.admin.dto.UmsUserDto;
import com.baomili.mall.modules.admin.model.UmsUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.admin.vo.UmsUserVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
public interface UmsUserService extends IService<UmsUser> {

    UmsUserVo register(UmsUserDto userDto);

    UmsUserVo login(UmsUserAuthDto userAuthDto);

}
