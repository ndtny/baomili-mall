package com.baomili.mall.modules.admin.service.impl;

import com.baomili.mall.modules.admin.constant.UserAuthConstant;
import com.baomili.mall.modules.admin.model.UmsUserAuth;
import com.baomili.mall.modules.admin.mapper.UmsUserAuthMapper;
import com.baomili.mall.modules.admin.service.UmsUserAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.admin.vo.UmsUserAuthVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户授权信息表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-01-07
 */
@Service
public class UmsUserAuthServiceImpl extends ServiceImpl<UmsUserAuthMapper, UmsUserAuth> implements UmsUserAuthService {

    @Resource
    UmsUserAuthMapper umsUserAuthMapper;

    @Override
    public void login(UmsUserAuthVo userAuthVo) {
        if(UserAuthConstant.IdentityType.PASSWORD.getValue().equals(userAuthVo.getIdentityType())) {
            String identityId = userAuthVo.getIdentityId();
            String credential = userAuthVo.getCredential();
            UmsUserAuthVo umsUserAuthVo = umsUserAuthMapper.getUserAuthByIdentityIdAndCredential(identityId, credential);
            if(umsUserAuthVo == null) {
                throw new RuntimeException("您输入的密码有误，请确认后重试");
            }
        }
    }
}
