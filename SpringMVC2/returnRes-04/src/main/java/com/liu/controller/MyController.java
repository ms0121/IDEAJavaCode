package com.liu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.vo.Student;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @RequestMapping("/test"):放置在类的上面，表示所有请求的公共部分
 *      value: 所有请求的公共部分，叫做模块名称
 *      位置：放在类的上面
 */
@Controller
public class MyController {

    /**
     * 处理器方法返回string---表示逻辑视图名称，需要配置文视图解析式
     */
    @RequestMapping(value = "/some.do")
    public String doSome(HttpServletRequest request,
                         String name, Integer age) {
        System.out.println("接收到了请求参数: \n name:" + name + "\n age:" + age);
        // 也可以自己手动的添加数据到request域中
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        // show：视图解析器名称，项目中配置了视图解析器，
        // 配置了视图解析器就不能使用完整的路径信息
        // 框架对视图执行forward转发的操作
        return "show";
    }


    // 处理器方法是 void， 响应的是json数据形式的数据信息
    // 将student对象的数据转为json格式的数据，从而相应ajax请求，不使用springmvc框架的实现方式
    @RequestMapping("/returnVoidJson.do")
    public void doJson(HttpServletResponse response, String name, int age) throws Exception{
        System.out.println("======returnVoidJson.do=======\n name: " + name + "\n age: " + age);
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        // 2. 将结果的对象转为json格式的数据，使用的是jackson
        String json = "";
        if (student != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("json = " + json);
        }

        // 3.输出数据，相应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json); // 将数据进行输出
        pw.flush();
        pw.close();
    }



    /**
     * // 使用springmvc框架的形式，将Object对象转为json数据形式，从而响应ajax请求
     * @ResponseBody:
     *     作用：把处理器方法返回的对象转为json后，通过HttpServletResponse输出给浏览器
     *     位置：方法的定义上面，和其他注解没有顺序的关系
     *
     *  返回对象框架的处理流程:
     *      1.框架会把返回student类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的canwrite()
     *      检查那个 <HttpMessageConverter>接口的实现类能处理Student类型的数据，
     *
     *      2、 框架会调用实现类的write()，MappingJackson2HttpMessageCounter的write方法可以将student
     *      对象转为json，使用过调用Jackson的objectMapper实现了对象转为json
     *
     *      3. 框架会调用@ResponseBody把2中的额结果输出到浏览器中，ajax请求处理完成
     */
    @RequestMapping("/requestStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name, Integer age) {
        // 模拟直接调用service执行业务操作，获取请求结果数据，Student独享表示结果数据
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;  // 返回的对象会直接被转为json输出到浏览器上面
    }


    /**
     * 返回的直接是一个list集合，会被转为数组的json格式
     * @return
     */
    @RequestMapping("/requestStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(String name, Integer age) {
        List<Student> list = new ArrayList<>();
        // 模拟直接调用service执行业务操作，获取请求结果数据，Student独享表示结果数据
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        Student student1 = new Student();
        student1.setName("李四");
        student1.setAge(30);

        list.add(student);
        list.add(student1);
        return list;  // 返回的List集合会直接被转为json数组输出到浏览器上面
    }


    /**
     * 处理器方法返回的是String，此时的String表示的是数据，而不是视图
     * 区分返回值String是数据还是视图，就看有没有@ResponseBody注解
     * 如果有@ResponseBody注解那返回值就是数据，否则就是视图
     * 如果返回的是string的文本内容时，会出现中文乱码，因为默认使用的是ISO-8859-1的编码方式
     * 解决乱码的方法：给@RequestMapping注解添加produces属性，使用这个属性指定的新的contentType
     */
    @RequestMapping(value = "/returnStringData.do",
            produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name, Integer age) {
        return "springmvc，你太好了?";
    }

}












