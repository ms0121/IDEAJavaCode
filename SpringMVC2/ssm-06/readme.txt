ssm-06:SSM整合开发
ssm： SpringMVC + Spring + MyBatis

SpringMVC：视图层，界面层，负责接收请求，显示处理的结果数据
Spring：业务层，管理service，dao，工具类的对象
MyBatis: 持久层，访问数据库

用户发起请求 --- SpringMVC接收 ---- Spring中的Service对象处理 --- MyBatis处理数据信息

ssm整合，整合中有容器
   1.第一个容器SpringMVC容器，管理Controller控制器对象
   2.第二个容器Spring容器，管理service，dao，工具类对象
   我们要做的就是把使用的对象交给适合的容器创建对象，管理。把Controller还有web开发的相关对象
   都交给SpringMVC容器，这些Web用的对象写在SpringMVC的配置文件中

   service，dao对象的定义在Spring的配置文件中，让Spring管理这些对象

SpringMVC容器和Spring容器是有关系的，关系是已经确定好的，
因为SpringMVC容器是Spring容器的子容器，类似于java中的继承关系，子可以访问父容器的内容，
崽子容器中的Controller就可以访问父容器，即Spring容器中的service对象，就可以实现controller
使用service对象了。


实现的步骤：
0.使用springdb中的student表
1.新建maven web项目
2.加入依赖
    springmvc，spring，mybatis三个框架的依赖，jackso依赖，mysql驱动，druid连接池
    jsp，servlet依赖等

3.写web.xml
    1）注册DispatcherServlet，目的：1.创建springmvc容器对象，才能创建controller对象
                                2.创建的是servlet，才能接受用户的请求
    2）注册spring的监听器：ContextLoaderListener，目的：创建spring的容器对象，才能创建
                        service，dao等对象。
    3）注册字符集表过滤器，解决post请求中的乱码问题

4.创建包，Controller包，service，dao，实体类包名创建好
5.写 springmvc，spring，mybatis的配置文件
    1）springmvc配置文件
    2）spring的配置文件
    3）mybatis的配置文件
    4）数据库的属性配置文件

6.写代码，dao接口和mapper文件，service和实现类，controller，实体类
7.写jsp页面















