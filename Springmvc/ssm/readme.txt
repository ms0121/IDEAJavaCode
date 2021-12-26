ssm: SSM整合开发
SSM：SpringMVC + Spring + Mybatis

SpringMVC： 视图层，界面层，负责接收请求，显示处理结果的
Spring：业务层，管理service，dao，工具类对象的
Mybatis: 持久层，访问数据库

用户发起请求 --- SpringMVC接收 --- Spring中的service对象 --- Mybatis处理数据

ssm整合：整合中有容器
1. 第一个容器SpringMVC容器，管理Controller控制器对象的
2. 第二个容器Spring容器，管理service，dao，工具类对象的
我们要做的就是把对象交给合适的容器进行创建，管理，把Controller还有web开发的相关
对象交给SpringMVC容器，这些web用的对象写在SpringMVC配置文件中

service，dao对象定义在spring的配置文件中，让spring管理这些对象

springmvc容器和spring容器是有关系的，关系已经确定好了
springmvc容器是spring容器的子容器，类似于Java中的继承，子类可以访问父类的内容
在子容器中的controller可以访问父容器中的service对象，就可以实现controller使用service对象


实现步骤：
    0. 使用springdb库的student表
    1. 新建maven项目
    2. 加入依赖包
        springmvc，spring，Mybatis三个框架的依赖，Jackson依赖，MySQL驱动
        druid连接池，jsp，servlet依赖
    3. 写web.xml
        1. 注册DispatcherServlet，目的：①创建springmvc容器对象，才能创建Controller类对象
                                       ②创建的是servlet，才能接受用户的请求
        2. 注册spring的监听器，ContextLoaderListener，目的：创建spring的容器对象，才能创建service，dao对象
        3. 注册字符集过滤器，解决post请求乱码的问题

    4. 创建包
        Controller包，service，dao实体类包名创建好

    5. 写springmvc，spring，mybatis的配置文件
        1.springmvc的配置文件
        2.spring的配置文件
        3，mybatis的主配置文件
        4，数据库的属性配置文件

    6. 写代码，dao接口和mapper文件，service和实现类，controller，实体类
    7. 写jsp页面

编写注册的流程: index.jsp(点击注册) --> (跳转到)addStudent.jsp(里面执行addStudent.do请求) --->
                (跳转到controller的)student/addStudent(service的方法,调用dao的方法) ---> (跳转到)result.jsp
















