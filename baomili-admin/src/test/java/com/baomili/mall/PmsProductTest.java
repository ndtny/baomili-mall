package com.baomili.mall;

import com.baomili.mall.modules.admin.constant.MemberConstant;
import com.baomili.mall.modules.common.dto.PageVo;
import com.baomili.mall.modules.product.constant.ProductConstant;
import com.baomili.mall.modules.product.dto.BrandQueryParam;
import com.baomili.mall.modules.product.dto.PmsBrandDto;
import com.baomili.mall.modules.product.dto.PmsProductDto;
import com.baomili.mall.modules.product.dto.ProductQueryParam;
import com.baomili.mall.modules.product.model.PmsBrand;
import com.baomili.mall.modules.product.model.PmsProduct;
import com.baomili.mall.modules.product.service.PmsBrandService;
import com.baomili.mall.modules.product.service.PmsProductService;
import com.baomili.mall.modules.product.vo.PmsBrandVo;
import com.baomili.mall.modules.product.vo.PmsProductVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PmsProductTest {

    @Resource
    private PmsProductService pmsProductService;

    @Test
    public void addPmsProduct() throws Exception {
        String username = "admin";
        String promotionStartTime = "2024-04-01 12:00:00";
        String promotionEndTime = "2024-04-15 12:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PmsProductDto pmsProductDto = new PmsProductDto();
        pmsProductDto.setProductNumber("HUAWEI_MATE60");
        pmsProductDto.setProductName("华为Mate 60");
        pmsProductDto.setProductSubTitle("华为Mate 60全新上市");
        pmsProductDto.setBrandId(1L);
        pmsProductDto.setBrandName("华为");
        pmsProductDto.setProductCategoryId(1L);
        pmsProductDto.setProductCategoryName("手机数码");
        pmsProductDto.setFreightTemplateId(1L);
        pmsProductDto.setProductAttributeCategoryId(1L);
        pmsProductDto.setUnit("部");
        pmsProductDto.setWeight(new BigDecimal(360));
        pmsProductDto.setSort(1);
        pmsProductDto.setSale(8699);
        pmsProductDto.setPrice(new BigDecimal(5999));
        pmsProductDto.setMemberPrice(new BigDecimal(5799));
        pmsProductDto.setMemberLevelId(MemberConstant.MemberTypeEnum.SILVER.getValue());
        pmsProductDto.setMemberLevelName(MemberConstant.MemberTypeEnum.getNameByValue(pmsProductDto.getMemberLevelId()));
        pmsProductDto.setPromotionPrice(new BigDecimal(5999));
        pmsProductDto.setPromotionStartTime(simpleDateFormat.parse(promotionStartTime));
        pmsProductDto.setPromotionEndTime(simpleDateFormat.parse(promotionEndTime));
        pmsProductDto.setFullPrice(new BigDecimal(10000));
        pmsProductDto.setReducePrice(new BigDecimal(500));
        pmsProductDto.setCount(2);
        pmsProductDto.setDiscount(new BigDecimal("0.95"));
        pmsProductDto.setStock(9999);
        pmsProductDto.setStockWarning(100);
        pmsProductDto.setProductServices(ProductConstant.ServiceTypeEnum.FREE_RETURNS+","+ProductConstant.ServiceTypeEnum.QUICK_REFUND+","+ProductConstant.ServiceTypeEnum.FREE_SHIPPING);
        pmsProductDto.setDetailTitle("华为Mate 60全新上市");
        pmsProductDto.setPromotionType(ProductConstant.PromotionTypeEnum.MEMBER_PRICE.getValue());
        pmsProductDto.setAuditStatus(0);
        pmsProductDto.setPublishStatus(0);
        pmsProductDto.setPreviewStatus(false);
        pmsProductDto.setNewStatus(1);
        pmsProductDto.setRecommandStatus(1);
        pmsProductDto.setCreateBy(username);
        pmsProductDto.setModifiedBy(username);
        pmsProductService.addProduct(pmsProductDto);
    }

    @Test
    public void updatePmsProduct() throws Exception{
        String username = "admin";
        String promotionStartTime = "2024-04-01 12:00:00";
        String promotionEndTime = "2024-04-15 12:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PmsProductDto pmsProductDto = new PmsProductDto();
        pmsProductDto.setProductNumber("HUAWEI_MATE60");
        pmsProductDto.setProductName("华为Mate 60");
        pmsProductDto.setProductSubTitle("华为Mate 60全新上市");
        pmsProductDto.setBrandId(1L);
        pmsProductDto.setBrandName("华为");
        pmsProductDto.setProductCategoryId(1L);
        pmsProductDto.setProductCategoryName("手机数码");
        pmsProductDto.setFreightTemplateId(1L);
        pmsProductDto.setProductAttributeCategoryId(1L);
        pmsProductDto.setUnit("部");
        pmsProductDto.setWeight(new BigDecimal(360));
        pmsProductDto.setSort(1);
        pmsProductDto.setSale(8699);
        pmsProductDto.setPrice(new BigDecimal(5999));
        pmsProductDto.setMemberPrice(new BigDecimal(5799));
        pmsProductDto.setMemberLevelId(MemberConstant.MemberTypeEnum.SILVER.getValue());
        pmsProductDto.setMemberLevelName(MemberConstant.MemberTypeEnum.getNameByValue(pmsProductDto.getMemberLevelId()));
        pmsProductDto.setPromotionPrice(new BigDecimal(5999));
        pmsProductDto.setPromotionStartTime(simpleDateFormat.parse(promotionStartTime));
        pmsProductDto.setPromotionEndTime(simpleDateFormat.parse(promotionEndTime));
        pmsProductDto.setFullPrice(new BigDecimal(10000));
        pmsProductDto.setReducePrice(new BigDecimal(500));
        pmsProductDto.setCount(2);
        pmsProductDto.setDiscount(new BigDecimal("0.95"));
        pmsProductDto.setStock(9999);
        pmsProductDto.setStockWarning(100);
        pmsProductDto.setProductServices(ProductConstant.ServiceTypeEnum.FREE_RETURNS+","+ProductConstant.ServiceTypeEnum.QUICK_REFUND+","+ProductConstant.ServiceTypeEnum.FREE_SHIPPING);
        pmsProductDto.setDetailTitle("华为Mate 60全新上市");
        pmsProductDto.setPromotionType(ProductConstant.PromotionTypeEnum.MEMBER_PRICE.getValue());
        pmsProductDto.setAuditStatus(0);
        pmsProductDto.setPublishStatus(0);
        pmsProductDto.setPreviewStatus(false);
        pmsProductDto.setNewStatus(1);
        pmsProductDto.setRecommandStatus(1);
        pmsProductDto.setCreateBy(username);
        pmsProductDto.setModifiedBy(username);
        pmsProductService.updateProduct(pmsProductDto);
    }

    @Test
    public void getPageList() {
        ProductQueryParam param = new ProductQueryParam();
        PageVo<PmsProduct> page = pmsProductService.getProductPage(param);
        log.info("商品列表：{}", page);
    }

    @Test
    public void getProductById() {
        PmsProductVo pmsProductVo = pmsProductService.getProductById(1L);
        log.info("商品信息：{}", pmsProductVo);
    }
}
