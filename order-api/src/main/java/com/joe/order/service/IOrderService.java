package com.joe.order.service;

import com.joe.order.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2023-07-23
 */
public interface IOrderService extends IService<Order> {

    int placeOrder(Long accountId,Long goodId,Long numCount);
}
