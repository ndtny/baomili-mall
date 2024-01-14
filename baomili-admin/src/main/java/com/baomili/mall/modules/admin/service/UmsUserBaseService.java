package com.baomili.mall.modules.admin.service;

import com.baomili.mall.modules.admin.model.UmsUserBase;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomili.mall.modules.admin.vo.UmsUserBaseVo;

/**
 * <p>
 * 用户基础信息表 服务类
 * </p>
 *
 * @author David
 * @since 2024-01-07
 */
public interface UmsUserBaseService extends IService<UmsUserBase> {

    UmsUserBaseVo getUserInfoByUserId(Integer userId);
}
