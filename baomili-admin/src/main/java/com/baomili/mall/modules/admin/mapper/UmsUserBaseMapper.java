package com.baomili.mall.modules.admin.mapper;

import com.baomili.mall.modules.admin.model.UmsUserBase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomili.mall.modules.admin.vo.UmsUserBaseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户基础信息表 Mapper 接口
 * </p>
 *
 * @author David
 * @since 2024-01-07
 */
@Mapper
public interface UmsUserBaseMapper extends BaseMapper<UmsUserBase> {

    UmsUserBaseVo getUserInfoByUserId(@Param("userId")Integer userId);
}
