
springmvc_01：第一个springmvc项目
需求：用于在页面发起一个请求，请求交给springmvc的控制器对象
        并显示请求的处理结果（在结果页面显示一个欢迎语句）

实现步骤：

1. 新建 web maven工程
2. 加入依赖
    spring-webmvc依赖，间接把spring的依赖都加入到项目中
    jsp，servlet依赖

3. 重点：在web.xml中注册springmvc框架的核心对象 DispatcherServlet
    1。DispatcherServlet叫做中央处理器，是一个servlet，它的父类是继承了Httpservlet
    2. DispatcherServlet 也叫作前端控制器
    3. DispatcherServlet 负责把用户提交的请求，调用其他的控制器对象，
        并把请求的处理结果显示给用户

4. 创建一个发起请求的页面  index.jsp

5. 创建控制器类
    1. 在类的上面加入@controller注解，创建对象，并放入到springmvc容器中
    2. 在类中的方法上面加入到@requestMapping注解

6. 创建一个作为结果的jsp，显示请求的处理结果

7、创建springmvc的配置文件（与spring的配置文件一样）
    1. 声明组件扫描器，指定@Controller注解所在的包名
    2. 声明视图解析器，帮助处理视图的














