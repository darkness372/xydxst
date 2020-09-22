package com.edu118.product.dao;

import com.edu118.common.entity.product.ProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author muyu
 * @email sunlightcs@gmail.com
 * @date 2020-09-19 15:33:51
 */
@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {
	
}
