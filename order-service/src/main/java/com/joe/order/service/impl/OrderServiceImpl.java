package com.joe.order.service.impl;

import com.joe.good.entity.Good;
import com.joe.good.service.IGoodService;
import com.joe.order.entity.Order;
import com.joe.order.mapper.OrderMapper;
import com.joe.order.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joe.user.service.IAccountService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2023-07-23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {


    @DubboReference(check = false)
    private IGoodService goodService;

    @DubboReference(check = false)
    private IAccountService accountService;

    /**
     * 1、创建订单，2、减库存，3、减余额、4、更新订单状态
     * @param accountId
     * @param goodId
     * @param numCount
     * @return
     */
    @GlobalTransactional
    @Override
    public int placeOrder(Long accountId, Long goodId, Long numCount) {
        //1、创建订单
        //订单总额 = 单价 * 数量
        Good good = goodService.findById(goodId);
        Double price = good.getPrice();
        Double sumMoney = price * numCount;

        long orderId = System.nanoTime();
        Order order = Order.builder().id(orderId)
                .userId(accountId)
                .goodId(goodId)
                .goodNum(numCount)
                .orderAmount(sumMoney)
                .build();

        int orderFlag = this.baseMapper.insert(order);

        //2、减库存
        int goodFlag = goodService.reduceStock(goodId, numCount);

        //3、减余额
        int accountFlag = accountService.reduceMoney(accountId,sumMoney);

        //4、修改订单状态
        Order updOrder = Order.builder().id(orderId).status(1).build();
        int updOrderFlag = this.baseMapper.updateById(updOrder);


        return 1;
    }
}
