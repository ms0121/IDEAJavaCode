# springboot集成整合Dubbo,redis,mybatis,Spring，springmvc，jsp

1.接口工程：存放实体类bean和业务的接口
2.服务提供者:它是一个springboot框架web项目，集成mybatis，redis
    - 添加依赖。mybatis，mysql驱动，dubbo，zookeeper，redis，接口工程
    - 配置springboot核心配置文件
        - 配置连接数据库
        - 配置连接redis
        - 配置dubbo
3.服务消费者：它是一个springboot框架web项目，继承jsp，dubbo
    - 添加依赖：dubbo，zookeeper，解析jsp页面的依赖，接口工程
    - 配置springboot核心配置文件
        - 配置视图解析器
        - 配置dubbo
