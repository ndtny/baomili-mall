package com.baomili.mall.modules.admin.service.impl;

import com.baomili.mall.modules.admin.model.UmsUserBase;
import com.baomili.mall.modules.admin.mapper.UmsUserBaseMapper;
import com.baomili.mall.modules.admin.service.UmsUserBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.admin.vo.UmsUserBaseVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户基础信息表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-01-07
 */
@Service
public class UmsUserBaseServiceImpl extends ServiceImpl<UmsUserBaseMapper, UmsUserBase> implements UmsUserBaseService {

    @Resource
    private UmsUserBaseMapper umsUserBaseMapper;

    @Override
    public UmsUserBaseVo getUserInfoByUserId(Integer userId) {
        return umsUserBaseMapper.getUserInfoByUserId(userId);
    }
}
