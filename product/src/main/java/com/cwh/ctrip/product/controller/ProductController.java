package com.cwh.ctrip.product.controller;


import com.cwh.ctrip.product.VO.ProductInfoVO;
import com.cwh.ctrip.product.VO.ProductVO;
import com.cwh.ctrip.product.VO.ResultVO;
import com.cwh.ctrip.product.dataobject.ProductCategory;
import com.cwh.ctrip.product.dataobject.ProductInfo;
import com.cwh.ctrip.product.service.CategoryService;
import com.cwh.ctrip.product.service.ProductService;
import com.cwh.ctrip.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductInfoVO> list() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        List<ProductVO> productVOList = new ArrayList<>();
        if(productInfoList != null && productInfoList.size() > 0) {
            List<Integer> categoryTypeList = productInfoList.stream()
                    .map(ProductInfo::getCategoryType).collect(Collectors.toList());
            List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
            //4. 构造数据
            for (ProductCategory productCategory: productCategoryList) {
                ProductVO productVO = new ProductVO();
                productVO.setCategoryName(productCategory.getCategoryName());
                productVO.setCategoryType(productCategory.getCategoryType());

                List<ProductInfoVO> productInfoVOList = new ArrayList<>();
                for (ProductInfo productInfo: productInfoList) {
                    if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        BeanUtils.copyProperties(productInfo, productInfoVO);
                        productInfoVOList.add(productInfoVO);
                    }
                }
                productVO.setProductInfoVOList(productInfoVOList);
                productVOList.add(productVO);
            }

        }
        return ResultVOUtil.success(productVOList);
    }

}
