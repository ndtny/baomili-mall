package com.baomili.mall;

import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.PmsProductCategoryDto;
import com.baomili.mall.modules.product.dto.ProductCategoryQueryParam;
import com.baomili.mall.modules.product.model.PmsProductCategory;
import com.baomili.mall.modules.product.service.PmsProductCategoryService;
import com.baomili.mall.modules.product.vo.PmsProductCategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PmsProductCategoryTest {

    @Resource
    private PmsProductCategoryService pmsProductCategoryService;

    @Test
    public void addProductCategory() {
        String username = "admin";
        List<Long> list = new ArrayList<>();
        list.add(1L);
        PmsProductCategoryDto productCategoryDto = new PmsProductCategoryDto();
        productCategoryDto.setName("手机数码");
        productCategoryDto.setParentId(0L);
        productCategoryDto.setLevel(0);
        productCategoryDto.setSort(1);
        productCategoryDto.setProductAttributeIds(list);
        productCategoryDto.setCreateBy(username);
        productCategoryDto.setModifiedBy(username);
        pmsProductCategoryService.addProductCategory(productCategoryDto);
    }

    @Test
    public void updateProductCategory() {
        String username = "admin";
        List<Long> list = new ArrayList<>();
        list.add(1L);
        PmsProductCategoryDto productCategoryDto = new PmsProductCategoryDto();
        productCategoryDto.setId(1L);
        productCategoryDto.setProductAttributeIds(list);
        productCategoryDto.setModifiedBy(username);
        pmsProductCategoryService.updateProductCategory(productCategoryDto);
    }

    @Test
    public void getPageList() {
        ProductCategoryQueryParam param = new ProductCategoryQueryParam();
        param.setName("手机数码");
        PageVo<PmsProductCategory> page = pmsProductCategoryService.getPmsProductCategoryPage(param);
        log.info("商品分类列表：{}", page);
    }

    @Test
    public void getProductCategoryById() {
        PmsProductCategoryVo pmsProductCategoryVo = pmsProductCategoryService.getProductCategoryById(1L);
        log.info("商品分类信息：{}", pmsProductCategoryVo);
    }
}
