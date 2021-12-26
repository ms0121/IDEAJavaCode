第一个入门案例：

使用mybatis的5个步骤：
    1.加入maven的依赖，mybatis依赖
    2.创建dao接口：定义了操作数据的方法
    3.创建mapper文件，也叫作sql映射文件：写sql语句的，和接口中方法对应的sql语句
    4.创建mybatis的一个主配置文件：1）连接数据库，2）指定mapper文件的位置
    5.使用mybatis的对象SqlSession：通过它的方法执行sql语句



实现步骤：
   1.新建maven项目
   2.加入maven的mybatis坐标，mysql驱动的坐标
   3.创建student实体类
   4.创建持久层的dao接口，定义操作数据库的方法
   5.创建一个mybatis使用的配置文件
        该文件叫做sql映射文件：写SQL语句的，一般一个表对应一个sql映射文件,这个文件是xml文件
        要求：
            1.放在接口所在的目录中
            2.文件名称和接口的名称一致
   6.创建mybatis的主配置文件
        一个项目就一个主配置文件
        主配置文件提供了数据库的连接信息和SQL映射文件的位置信息
   7.创建使用mybatis类，
        通过mybatis访问数据库