package com.edu118.common.service.product;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu118.common.entity.product.ProductEntity;
import com.edu118.common.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author muyu
 * @email sunlightcs@gmail.com
 * @date 2020-09-19 15:33:51
 */
public interface ProductService extends IService<ProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

