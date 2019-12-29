package com.cwh.ctrip.product.service;

import com.cwh.ctrip.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by cwh
 * 2019-12-09 22:06
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
