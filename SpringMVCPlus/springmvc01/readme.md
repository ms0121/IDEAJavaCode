## 拦截器
- Interceptor拦截器，主要作用就是拦截用户的请求并进行相应的处理。类似于servlet中的
 过滤器（Filter），比如通过它来进行权限认证，或者是判断用户是否登录等操作，对于spring的
 定义方式有两种：
    - 实现接口：org.springframework.web.servlet.HandlerInterceptor
    - 继承适配器：org.springframework.web.servlet.handler.HandlerInterceptorAdapter
    (其间接实现了HandlerInterceptor接口)
    
    
    
## 全局异常统一处理
- 在业务的实现过程中，每个过程都需要单独处理异常信息，那么系统的代码耦合度就很高，
工作量大而且不好统一，维护的工作量巨大。
- SpringMVC对于异常处理这块提供了支持，通过SpringMVC提供的全局异常处理机制，实现了异常处理
在各个模块之间的解耦操作，既保证了相关处理过程的功能比较单一，也实现了异常信息的统一处理和维护
- 全局异常实现方式SpringMVC处理异常的3中方式：
    - 使用SpringMVC提供的简单异常处理器SimpleMappingExceptionResolver
      - (需要在SpringMVC配置文件中进行配置，处理的是视图的异常，对于返回的是json数据的异常就会有缺陷，所以不推荐使用)
    - 实现Spring的异常处理接口 HandlerExceptionResolver自定义自己的异常处理器（推荐使用）
    - 使用@ExceptionHandler注解实现异常处理

## 未捕获的异常处理机制
- 使用404或者500（配置在web.xml中）
