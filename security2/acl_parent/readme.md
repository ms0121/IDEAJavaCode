### 模块介绍
- acl_parent: 
    - 在父工程的pom中定义 依赖的版本
  
  - common
    - service_base： 编写工具类，比如md5加密等等
    - spring_security：SpringSecurity的相关配置
    
  - infrastructure
    - api_gateway：配置gateway网关
    
  - service
    - service_acl: 实现权限管理功能代码
