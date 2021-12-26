exception-08：异常处理

异常处理的步骤：
1。新建maven项目
2.加入依赖
3.新建一个自定义异常类 MyException，在定义它的子类
在controller中抛出NameException，AgeException异常信息
5.创建一个普通类，作用在全局异常处理类
    1）.在类的上面加入@ControllerAdvice
    2）在类中定义方法，方法的上面加入@ExceptionHandler注解
6.创建异常处理的视图页面
7.创建springmvc的配置文件
    1）组件扫描器扫描@Controller注解
    2）组件扫描器，扫描@ControllerAdvice所在的包名
    3）声明注解驱动