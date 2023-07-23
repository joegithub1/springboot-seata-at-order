# springboot-seata-order
seata 订单服务模块

### seata xa数据强一致性模式
  1、application.yml 中 seata.data-source-proxy-mode 改为 XA  <br/>
  2、数据库不需要undo_log表

### seata at数据最终一致性模式 （seata默认模式）
  1、application.yml 中 seata.data-source-proxy-mode 改为 AT  <br/>
  2、参与seata事务所有涉及到的数据库都需要增加 undo_log表
