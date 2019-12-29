package com.cwh.ctrip.product.service;

import com.cwh.ctrip.product.common.DecreaseStockInput;
import com.cwh.ctrip.product.common.ProductInfoOutput;
import com.cwh.ctrip.product.dataobject.ProductInfo;

import java.util.List;

/**
 * Created by cwh
 * 2019-12-09 21:57
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
