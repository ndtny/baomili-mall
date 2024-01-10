package com.baomili.mall.modules.admin.mapper;

import com.baomili.mall.modules.admin.model.UmsUserAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomili.mall.modules.admin.vo.UmsUserAuthVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户授权信息表 Mapper 接口
 * </p>
 *
 * @author David
 * @since 2024-01-07
 */
@Mapper
public interface UmsUserAuthMapper extends BaseMapper<UmsUserAuth> {

    UmsUserAuthVo getUserAuthByIdentityIdAndCredential(@Param("identityId")String identityId, @Param("credential")String credential);
}
