package com.baomili.mall.modules.admin.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomili.mall.modules.admin.model.UmsUserAuth;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户授权信息表 服务类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@DS("ums")
public interface UmsUserAuthService extends IService<UmsUserAuth> {

}
