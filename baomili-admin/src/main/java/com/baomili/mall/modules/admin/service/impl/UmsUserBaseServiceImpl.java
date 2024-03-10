package com.baomili.mall.modules.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomili.mall.modules.admin.model.UmsUserBase;
import com.baomili.mall.modules.admin.mapper.UmsUserBaseMapper;
import com.baomili.mall.modules.admin.service.UmsUserBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.admin.vo.UmsUserBaseVo;
import org.junit.platform.engine.UniqueId;
import org.springframework.stereotype.Service;
import sun.misc.Unsafe;

import javax.annotation.Resource;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.*;

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
