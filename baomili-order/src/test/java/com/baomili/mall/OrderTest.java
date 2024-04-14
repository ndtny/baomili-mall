package com.baomili.mall;

import com.baomili.mall.modules.order.constant.OrderConstant;
import com.baomili.mall.modules.order.dto.OmsOrderDto;
import com.baomili.mall.modules.order.dto.OmsOrderItemDto;
import com.baomili.mall.modules.order.model.OmsOrderItem;
import com.baomili.mall.modules.order.service.OmsOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTest {

    @Resource
    private OmsOrderService omsOrderService;

    @Test
    public void addOrder() {
        OmsOrderDto omsOrderDto = new OmsOrderDto();
        omsOrderDto.setMemberId(1L);
        omsOrderDto.setMemberName("David");
        omsOrderDto.setPayType(OrderConstant.PayTypeEnum.UN_PAY.getValue());
        omsOrderDto.setSourceType(OrderConstant.SourceTypeEnum.PC.getValue());
        omsOrderDto.setStatus(OrderConstant.OrderStatusEnum.PENDING_PAYMENT.getValue());
        omsOrderDto.setOrderType(OrderConstant.OrderTypeEnum.NORMAL.getValue());
        omsOrderDto.setReceiveUser("David");
        omsOrderDto.setPhone("18888888888");
        omsOrderDto.setProvince("上海市");
        omsOrderDto.setCity("上海市");
        omsOrderDto.setRegion("浦东新区");
        omsOrderDto.setDetailAddress("东方明珠");

        List<OmsOrderItemDto> omsOrderItemDtoList = new ArrayList<>();

        OmsOrderItemDto orderItemDto1 = new OmsOrderItemDto();
        orderItemDto1.setProductId(1L);
        orderItemDto1.setProductNumber("HUAWEI_MATE60");
        orderItemDto1.setProductName("华为Mate 60");
        orderItemDto1.setPrice(6999D);
        orderItemDto1.setQuantity(1);
        omsOrderItemDtoList.add(orderItemDto1);

        OmsOrderItemDto orderItemDto2 = new OmsOrderItemDto();
        orderItemDto2.setProductId(2L);
        orderItemDto2.setProductNumber("HUAWEI_MATE50");
        orderItemDto2.setProductName("华为Mate 50");
        orderItemDto2.setPrice(5999D);
        orderItemDto2.setQuantity(1);
        omsOrderItemDtoList.add(orderItemDto2);

        omsOrderDto.setOmsOrderItemDtoList(omsOrderItemDtoList);
        omsOrderService.addOrder(omsOrderDto);
    }
}
