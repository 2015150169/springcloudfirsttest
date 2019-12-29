package com.cwh.ctrip.product.repository;

import com.cwh.ctrip.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cwh
 * 2019-12-09 21:29
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
