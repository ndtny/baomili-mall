package com.baomili.mall.modules.admin.service;

import com.baomili.mall.modules.admin.model.UmsUserAuth;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.admin.vo.UmsUserAuthVo;
import com.baomili.mall.modules.admin.vo.UmsUserBaseVo;

/**
 * <p>
 * 用户授权信息表 服务类
 * </p>
 *
 * @author David
 * @since 2024-01-07
 */
public interface UmsUserAuthService extends IService<UmsUserAuth> {
    UmsUserBaseVo login(UmsUserAuthVo userAuthVo);
}
