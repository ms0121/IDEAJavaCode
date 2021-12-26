returnRes-04: 处理器方法的返回值表示请求的处理结果
1.ModelAndView: 有数据和视图，对视图执行forward
2.string：表示视图，可以是逻辑名称，也可以是完整的视图路径
3.void：不能表示数据，也不能表示视图
     在处理ajax的时候，可以使用void返回值，通过HttpServletResponse输出数据。
     响应ajax请求。ajax请求服务器端返回的就是数据，和视图无关

4.Object：例如String，Integer，Map，List等等都是对象
    对象有属性，属性就是数据，所以返回Object表示数据，和视图无关，
    因此可以使用对象表示的数据，响应ajax请求：

    现在做ajax请求，主要使用json的数据格式，springmvc框架实现的步骤：
        1. 加入处理json的工具库的依赖，springmvc默认使用的是Jackson
        2. 在springmvc配置文件之间加入 <mvc:annotation-driven>注解驱动，
            实质等价于：json = om.writeValueAsString(student)，作用就是将
            对象转为json的数据形式
        3.在处理器方法的上面加入 @Responsebody注解，实质等价于(将数据进行输出)：
            response.setContentType("application/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.println(json); // 将数据进行输出

    springmvc处理器方法返回Object，可以转为json输出到浏览器，相应ajax的内部原理
        1. <mvc:annotation-driven> 注解驱动。
            注解驱动实现的功能是：完成了java对象到json，xml，text，二进制等数据格式的转发
            HttpMessageConveter接口：消息转换器
            该接口的功能：定义了java转为json，xml等数据格式的方法，这个接口有很多的实现类
            这些实现类完成了java对象到json，到xml，到二进制数据的转换。


1. springmvc请求处理的具体流程：
   1. 发起dome.do请求
   2. Tomcat服务器处理请求（在web.xml中根据<url-pattern>就可以知道 *.do的请求是发给DispatcherServlet）
   3) DispatcherServlet（中央调度器根据springmvc.xml中的配置知道some.do -- doSome）
   4) DispatcherServlet 把 some.do转发到MyController.doSome()方法
   5）框架执行doSome()把得到的ModelAndView进行处理，在转发到指定的show.jsp

2. 简化过程就是：
    some.do ---> DispatcherServlet ---> MyController

3. springmvc执行过程的源代码分析：
   1）Tomcat启动后，创建容器的过程
        通过load-on-start标签指定的1， 创建DispatcherServlet对象
        DispatcherServlet它的父类是继承HttpServlet的，它是一个servlet，在被创建时，会执行init()方法，
        在init()方法中：
            //创建容器，读取配置文件
            WebApplicationContext context = new ClassPathXmlApplicationContext("springmvc.xml");
            // 把容器对象放入到ServletContext中
            getServContext().setAttribute(key, context);

        上面创建容器的作用是：创建@controller注解所在的类，创建MyController对象，
        这个对象放入到springmvc容器中，容器是map，类似于map.put("myController", MyController对象)

   2）


实现步骤：
1.新建maven项目
2.加入依赖
    spring-webmvx依赖，间接把spring的依赖都加入到项目中
    jsp，servlet依赖

3. 重点：在web.xml中注册springmvc框架的核心对象DispatcherServlet
    1）DispatcherServlet叫做中央调度器，是一个servlet，它的父类是继承HttpServlet
    2）DispatcherServlet也叫作前端控制器
    3) DispatcherServlet负责接收用户提交的请求，调用其他的控制器对象，并把请求的处理结果显示给用户

4.创建一个发起请求的页面 index.jsp

5. 创建控制器类
    1）在类的上面加入@controller注解，创建对象，并放入到springmvc容器中
    2）在类中的方法上面加入@RequestMapping注解

6. 创建一个作为结果的jsp页面，显示请求的处理结果

7.创建springmvc的配置文件（spring的配置文件一样）
    1）声明组件扫描器，指定@controller注解所在的包名
    2）声明视图解析器，帮助处理视图的







