package com.baomili.mall;

import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.AttributeCategoryQueryParam;
import com.baomili.mall.modules.product.dto.BrandQueryParam;
import com.baomili.mall.modules.product.dto.PmsBrandDto;
import com.baomili.mall.modules.product.dto.PmsProductAttributeCategoryDto;
import com.baomili.mall.modules.product.model.PmsBrand;
import com.baomili.mall.modules.product.model.PmsProductAttributeCategory;
import com.baomili.mall.modules.product.service.PmsBrandService;
import com.baomili.mall.modules.product.service.PmsProductAttributeCategoryService;
import com.baomili.mall.modules.product.vo.PmsBrandVo;
import com.baomili.mall.modules.product.vo.PmsProductAttributeCategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PmsAttributeCategoryTest {

    @Resource
    private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @Test
    public void addProductAttributeCategory() {
        String username = "admin";
        PmsProductAttributeCategoryDto attributeCategoryDto = new PmsProductAttributeCategoryDto();
        attributeCategoryDto.setName("手机数码-手机通讯");
        attributeCategoryDto.setAttributeCount(2);
        attributeCategoryDto.setParamCount(4);
        attributeCategoryDto.setCreateBy(username);
        attributeCategoryDto.setModifiedBy(username);
        pmsProductAttributeCategoryService.addAttributeCategory(attributeCategoryDto);
    }

    @Test
    public void updateProductAttributeCategory() {
        String username = "admin";
        PmsProductAttributeCategoryDto attributeCategoryDto = new PmsProductAttributeCategoryDto();
        attributeCategoryDto.setId(1L);
        attributeCategoryDto.setAttributeCount(2);
        attributeCategoryDto.setParamCount(4);
        attributeCategoryDto.setModifiedBy(username);
        pmsProductAttributeCategoryService.updateAttributeCategory(attributeCategoryDto);
    }

    @Test
    public void getPageList() {
        AttributeCategoryQueryParam param = new AttributeCategoryQueryParam();
        param.setName("手机数码");
        PageVo<PmsProductAttributeCategory> page = pmsProductAttributeCategoryService.getPageList(param);
        log.info("商品属性分类列表：{}", page);
    }

    @Test
    public void getProductAttributeCategoryById() {
        PmsProductAttributeCategoryVo attributeCategoryVo = pmsProductAttributeCategoryService.getAttributeCategoryById(1L);
        log.info("商品属性分类信息：{}", attributeCategoryVo);
    }
}
