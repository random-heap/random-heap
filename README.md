### 对丰循业务的思考

- 系统目前维护了卡车的基础信息，但是跟卡车相关联的常常是司机，比如司机的工作时间安排是否作为一项基础数据去维护
- 车辆调度考虑司机排班这一维度的数据
- 装容、装车的装载率是否可以提高？
- 丰循数据对于一线装载员工的接收程度
- 配送对接物流信息，入厂物流可视化
- 配载计划加入复盘指标，比如装载率、在途时间、装卸货时间，相关人员可以评价、优化某个配载计划
- 距离矩阵目前只维护距离一个指标，是否考虑运输成本，时间成本、金钱成本
- 风控、实时预警、有效追溯



### 对丰循项目架构的思考

丰循项目的核心是算法，业务不算复杂，而丰循的使用者涉及到主机厂、供应商、承运商三种角色，同时考虑到如果是私部署，QPS预估会在20qps/s以下，所以我的想法是在目前SaaS项目架构上面做减法：

- 去掉注册中心ZooKeeper和分布式开发框架Dubbo，采用单体架构+集群部署，不保证高并发，只保证高可用

  个人看法，采用单体架构或者分布式架构(微服务)，衡量的一个指标是表是否超过60张。

- 去掉Redis

  Redis的主要使用场景是在高并发情况下缓存热点数据以便提高QPS，而丰循预估QPS不会很高，在原有使用缓存的地方可以改造为数据库，对于一个缓存的接口响应时间约为10ms，而一个数据库普通单表查询的响应时间约为50-100ms，而且搭建Redis需要哨兵或者集群保证可用性，至少3个节点以上，客户内部不一定有Redis实例。

- 无须引入去中心化的调度平台

  丰循只涉及到少量的定时任务，可以采用SpringBoot Schedule代替。

- 数据库需要兼容Oracle

  MySQL主要是互联网公司使用的多，据我了解一些大型传统公司，内部用Oracle居多。

  

  

  

