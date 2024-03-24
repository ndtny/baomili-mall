package com.baomili.mall.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomili.mall.modules.admin.constant.UserAuthConstant;
import com.baomili.mall.modules.admin.dto.UmsUserAuthDto;
import com.baomili.mall.modules.admin.dto.UmsUserDto;
import com.baomili.mall.modules.admin.mapper.UmsUserAuthMapper;
import com.baomili.mall.modules.admin.model.UmsUser;
import com.baomili.mall.modules.admin.mapper.UmsUserMapper;
import com.baomili.mall.modules.admin.model.UmsUserAuth;
import com.baomili.mall.modules.admin.service.UmsUserAuthService;
import com.baomili.mall.modules.admin.service.UmsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomili.mall.modules.admin.vo.UmsUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
public class UmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser> implements UmsUserService {

    @Resource
    private UmsUserMapper umsUserMapper;

    @Resource
    private UmsUserAuthService umsUserAuthService;

//    @Resource
//    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UmsUserVo register(UmsUserDto userDto) {
        log.info("register 注册用户 入参：{}", userDto);
        String username = userDto.getUserName();
        Date date = new Date();

        QueryWrapper<UmsUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userDto.getUserName());
        UmsUser user = umsUserMapper.selectOne(queryWrapper);

        if (Optional.ofNullable(user).isPresent()) {
            log.error("register 注册用户 用户名已存在");
            throw new RuntimeException("用户名已存在");
        }

        UmsUser umsUser = new UmsUser();
        // TODO 后面替换为MapStruct转换对象
        BeanUtils.copyProperties(userDto, umsUser);
        umsUser.setCreateBy(username);
        umsUser.setCreateTime(date);
        umsUser.setModifiedBy(username);
        umsUser.setModifiedTime(date);
        umsUserMapper.insert(umsUser);
        log.info("register 注册用户 保存用户信息成功");

        UmsUserAuth umsUserAuth = new UmsUserAuth();
        umsUserAuth.setUserId(umsUser.getId());
        umsUserAuth.setIdentityType(UserAuthConstant.IdentityType.PASSWORD.getValue());
        umsUserAuth.setIdentityId(userDto.getIdentityId());
        umsUserAuth.setCredential(userDto.getCredential());
        umsUserAuth.setCreateBy(username);
        umsUserAuth.setCreateTime(date);
        umsUserAuth.setModifiedBy(username);
        umsUserAuth.setModifiedTime(date);
        umsUserAuthService.save(umsUserAuth);
        log.info("register 注册用户 保存用户验证信息成功");

        UmsUserVo umsUserVo = new UmsUserVo();
        BeanUtils.copyProperties(umsUser, umsUserVo);
        log.info("register 注册用户 返回注册用户：{}", umsUserVo);
        return umsUserVo;
    }

    @Override
    public UmsUserVo login(UmsUserAuthDto userAuthDto) {
        log.info("login 登录 入参：{}", userAuthDto);

        QueryWrapper<UmsUserAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("identity_id", userAuthDto.getIdentityId());
        UmsUserAuth userAuth = umsUserAuthService.getOne(queryWrapper);
        log.info("login 登录 匹配用户：{}", userAuth);

        if (!Optional.ofNullable(userAuth).isPresent()) {
            log.error("login 登录 用户不存在");
            throw new RuntimeException("用户不存在");
        }

        if (!userAuth.getCredential().equals(userAuthDto.getCredential())) {
            log.error("login 登录 用户名密码不正确");
            throw new RuntimeException("用户名密码不正确");
        }

        QueryWrapper<UmsUser> wrapper = new QueryWrapper<>();
        wrapper.eq("id", userAuth.getUserId());
        UmsUser umsUser = umsUserMapper.selectOne(wrapper);
        UmsUserVo umsUserVo = new UmsUserVo();
        BeanUtils.copyProperties(umsUser, umsUserVo);
        log.error("login 登录成功：{}", umsUserVo);
        return umsUserVo;
    }

    @Override
    public void logout() {
        log.info("logout 退出成功");
    }
}
