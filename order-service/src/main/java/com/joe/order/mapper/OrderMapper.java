package com.joe.order.mapper;

import com.joe.order.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2023-07-23
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
