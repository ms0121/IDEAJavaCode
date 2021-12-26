spring-mybatis：整合

步骤：

    1.新建maven项目
    2.加入maven的依赖
        1）spring的依赖
        2）mybatis依赖
        3）mysql驱动
        4）spring事务的依赖
        5）mybatis和spring继承的依赖：mybatis官方提供的，
            用于在Spring项目中创建mybatis的SQLSessionfactory,dao对象
    3.创建实体类
    4.创建到接口和mapper文件
    5.创建mybatis主配置文件
    6.创建service接口和实现类，属性是dao
    7.创建spring的配置文件，声明mybatis的对象交给spring进行创建
        1）数据源
        2）SqlSessionFactory
        3) Dao对象
        4）声明自定义的service

    8. 创建测试类，获取service对象，通过service调用dao完成数据库的访问












