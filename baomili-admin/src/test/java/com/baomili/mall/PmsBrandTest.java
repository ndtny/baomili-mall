package com.baomili.mall;

import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.dto.BrandQueryParam;
import com.baomili.mall.modules.product.dto.PmsBrandDto;
import com.baomili.mall.modules.product.dto.ProductQueryParam;
import com.baomili.mall.modules.product.model.PmsBrand;
import com.baomili.mall.modules.product.service.PmsBrandService;
import com.baomili.mall.modules.product.vo.PmsBrandVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PmsBrandTest {

    @Resource
    private PmsBrandService pmsBrandService;

    @Test
    public void addPmsBrand() {
        String username = "admin";
        PmsBrandDto pmsBrandDto = new PmsBrandDto();
        pmsBrandDto.setName("小米");
        pmsBrandDto.setFirstLetter("X");
        pmsBrandDto.setSort(3);
        pmsBrandDto.setCreateBy(username);
        pmsBrandDto.setModifiedBy(username);
        pmsBrandService.addPmsBrand(pmsBrandDto);
    }

    @Test
    public void updatePmsBrand() {
        PmsBrandDto pmsBrandDto = new PmsBrandDto();
        pmsBrandDto.setId(6L);
        pmsBrandDto.setSort(4);
        pmsBrandService.updatePmsBrand(pmsBrandDto);
    }

    @Test
    public void getPageList() {
        BrandQueryParam param = new BrandQueryParam();
        param.setName("华");
        PageVo<PmsBrand> page = pmsBrandService.getPmsBrandPage(param);
        log.info("品牌列表：{}", page);
    }

    @Test
    public void getBrandById() {
        PmsBrandVo pmsBrandVo = pmsBrandService.getBrandVoById(1L);
        log.info("品牌信息：{}", pmsBrandVo);
    }
}
