package com.joe.order.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joe.order.entity.Order;
import com.joe.order.service.IOrderService;
import com.joe.seata.common.base.BaseController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GoodController
 * @Description:
 * @Author huangjian
 * @Date 2023/7/23
 **/
@RestController
@RequestMapping(value = {"/api/v1/order"},
        produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "GoodController", description = "")
public class OrderController extends BaseController {

    @Autowired
    private IOrderService orderService;

    @Override
    public IService<Order> getService() {
        return orderService;
    }

    /**
     * 下订单： 创建订单，减金额，修改订单状态
     * @return
     */
    @GetMapping("/placeOrder")
    public String placeOrder(Long accountId,
                             Long goodId,
                             Long numCount){
        int result = orderService.placeOrder(accountId, goodId, numCount);
        return "success";
    }
}
