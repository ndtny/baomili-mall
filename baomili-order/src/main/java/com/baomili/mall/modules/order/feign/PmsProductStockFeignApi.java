package com.baomili.mall.modules.order.feign;

import com.baomili.mall.modules.common.api.CommonResult;
import com.baomili.mall.modules.common.vo.rocketmq.ReduceStockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "baomili-product", path = "/product/pmsStock")
public interface PmsProductStockFeignApi {

    @RequestMapping("/getProductStock")
    CommonResult getProductStock(@RequestBody List<Long> productIds);

    @RequestMapping("/recoverStock")
    CommonResult recoverStock(@RequestBody List<ReduceStockVo> reduceStockVos);

}
