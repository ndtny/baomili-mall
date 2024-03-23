package com.baomili.mall.modules.admin.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomili.mall.modules.admin.model.UmsUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@DS("ums")
public interface UmsUserMapper extends BaseMapper<UmsUser> {

}
