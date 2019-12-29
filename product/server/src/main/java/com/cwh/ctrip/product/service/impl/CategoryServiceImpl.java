package com.cwh.ctrip.product.service.impl;

import com.cwh.ctrip.product.dataobject.ProductCategory;
import com.cwh.ctrip.product.repository.ProductCategoryRepository;
import com.cwh.ctrip.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cwh
 * 2019-12-09 22:06
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
