package com.baomili.mall;

import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.constant.ProductAttributeConstant;
import com.baomili.mall.modules.product.dto.AttributeQueryParam;
import com.baomili.mall.modules.product.dto.PmsProductAttributeDto;
import com.baomili.mall.modules.product.model.PmsProductAttribute;
import com.baomili.mall.modules.product.service.PmsProductAttributeService;
import com.baomili.mall.modules.product.vo.PmsProductAttributeVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PmsAttributeTest {

    @Resource
    private PmsProductAttributeService pmsProductAttributeService;

    @Test
    public void addProductAttribute() {
        String username = "admin";
        PmsProductAttributeDto attributeDto = new PmsProductAttributeDto();
        attributeDto.setAttributeName("颜色");
        attributeDto.setProductAttributeCategoryId(1L);
        attributeDto.setSelectType(ProductAttributeConstant.SelectTypeEnum.MULTIPLE.getValue());
        attributeDto.setInputType(ProductAttributeConstant.InputTypeEnum.LIST_FETCH.getValue());
        attributeDto.setInputList("黑色,白色");
        attributeDto.setSort(1);
        attributeDto.setFilterType(ProductAttributeConstant.FilterTypeEnum.COLOR.getValue());
        attributeDto.setSearchType(ProductAttributeConstant.SearchTypeEnum.UN_NEED.getValue());
        attributeDto.setType(ProductAttributeConstant.AttributeTypeEnum.PARAM.getValue());
        attributeDto.setCreateBy(username);
        attributeDto.setModifiedBy(username);
        pmsProductAttributeService.addAttribute(attributeDto);
    }

    @Test
    public void updateProductAttribute() {
        String username = "admin";
        PmsProductAttributeDto attributeDto = new PmsProductAttributeDto();
        attributeDto.setId(1L);
        attributeDto.setProductAttributeCategoryId(1L);
        attributeDto.setSelectType(ProductAttributeConstant.SelectTypeEnum.MULTIPLE.getValue());
        attributeDto.setInputType(ProductAttributeConstant.InputTypeEnum.LIST_FETCH.getValue());
        attributeDto.setInputList("黑色,白色,银色,粉丝,紫色,绿色");
        attributeDto.setSort(2);
        attributeDto.setFilterType(ProductAttributeConstant.FilterTypeEnum.COLOR.getValue());
        attributeDto.setSearchType(ProductAttributeConstant.SearchTypeEnum.UN_NEED.getValue());
        attributeDto.setType(ProductAttributeConstant.AttributeTypeEnum.PARAM.getValue());
        attributeDto.setModifiedBy(username);
        pmsProductAttributeService.updateAttribute(attributeDto);
    }

    @Test
    public void getPageList() {
        AttributeQueryParam param = new AttributeQueryParam();
        param.setAttributeName("颜色");
        PageVo<PmsProductAttribute> page = pmsProductAttributeService.getPmsAttributePage(param);
        log.info("商品属性列表：{}", page);
    }

    @Test
    public void getProductAttributeById() {
        PmsProductAttributeVo AttributeVo = pmsProductAttributeService.getAttributeById(1L);
        log.info("商品属性信息：{}", AttributeVo);
    }
}
