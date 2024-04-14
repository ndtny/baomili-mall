package com.baomili.mall.modules.product.service.impl;

import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockEvent;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockVo;
import com.baomili.mall.modules.product.model.PmsStock;
import com.baomili.mall.modules.product.mapper.PmsStockMapper;
import com.baomili.mall.modules.product.service.PmsStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品库存 服务实现类
 * </p>
 *
 * @author David
 * @since 2024-03-23
 */
@Service
@Slf4j
public class PmsStockServiceImpl extends ServiceImpl<PmsStockMapper, PmsStock> implements PmsStockService {

    @Resource
    private PmsStockMapper pmsStockMapper;

    @Override
    public void reduceStock(ReduceStockEvent reduceStockEvent) {
//        int result = pmsStockMapper.isExistTx(reduceStockEvent.getTransactionId());
//        if (result > 0) {
//            log.info("reduceStock 消息已消费 return");
//            return;
//        }
//
        List<ReduceStockVo> reduceStockVos = reduceStockEvent.getReduceStockVos();
//        // 扣减库存
        pmsStockMapper.updatePmsStock(reduceStockVos);
        log.info("reduceStock 扣减库存成功");
    }
}
