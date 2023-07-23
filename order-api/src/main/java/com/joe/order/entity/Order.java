package com.joe.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.joe.seata.common.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * <p>
 * 
 * </p>
 *
 * @author huang
 * @since 2023-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@TableName("t_order")
@Schema(description = "Order对象")
public class Order extends BaseEntity {

private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
  /**
   * 主键
   */
        @TableId(value = "id", type = IdType.AUTO)
        private Long id;

    @Schema(description = "用户ID")
  /**
   * 用户ID
   */
    @TableField("user_id")
    private Long userId;

    @Schema(description = "商品ID")
  /**
   * 商品ID
   */
    @TableField("good_id")
    private Long goodId;

    @Schema(description = "购买数量")
  /**
   * 购买数量
   */
    @TableField("good_num")
    private Long goodNum;

    @Schema(description = "状态")
  /**
   * 状态
   */
    @TableField("status")
    private Integer status;

    @Schema(description = "订单总金额")
  /**
   * 订单总金额
   */
    @TableField("order_amount")
    private Double orderAmount;


}
