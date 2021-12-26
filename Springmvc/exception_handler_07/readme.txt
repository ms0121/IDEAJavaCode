exception_handler_07:异常处理

异常处理的步骤：
1、加入Maven项目
2、加入依赖
3、新建一个自定义异常类，MyUserException，在定义它的子类 NameException， AgeException
4、在抛出controller抛出NameException，AgeException
5.创建一个普通的类，作用全局异常处理类
    1. 在类的上面加入@ControllerAdvice
    2. 在类中定义方法，方法的上面加入@ExceptionHandler

6.创建异常类的视图处理页面
7.创建springmvc的配置文件
    1.组件扫描器，扫描@Controller注解
    2.组件扫描器，扫描@ControllerAdvice所在的包名
    3.声明注解驱动
