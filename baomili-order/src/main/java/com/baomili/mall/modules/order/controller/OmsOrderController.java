package com.baomili.mall.modules.order.controller;


import com.baomili.mall.modules.common.api.CommonResult;
import com.baomili.mall.modules.order.constant.OrderConstant;
import com.baomili.mall.modules.order.dto.OmsOrderDto;
import com.baomili.mall.modules.order.dto.OmsOrderItemDto;
import com.baomili.mall.modules.order.dto.OrderQueryParamDto;
import com.baomili.mall.modules.order.service.OmsOrderService;
import com.baomili.mall.modules.order.vo.OmsOrderVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author David
 * @since 2024-04-05
 */
@RestController
@RequestMapping("/order/omsOrder")
public class OmsOrderController {

    @Resource
    private OmsOrderService omsOrderService;

    @ApiOperation("商城下单")
    @PostMapping("/addOrder")
    public CommonResult<String> addOrder(@RequestBody OmsOrderDto omsOrderDto) {
        try {
            omsOrderService.addOrder(omsOrderDto);
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success("下单成功");
    }

    @ApiOperation("查询订单列表")
    @PostMapping("/getOrderList")
    public CommonResult<List<OmsOrderVo>> getOrderList(@RequestBody OrderQueryParamDto queryParamDto) {
        List<OmsOrderVo> omsOrderVos = omsOrderService.getOrderList(queryParamDto);
        return CommonResult.success(omsOrderVos);
    }

}

