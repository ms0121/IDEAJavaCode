package com.liu.reflection;

import javax.swing.plaf.ActionMapUIResource;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-09-08 - 14:07
 * 通过反射获取泛型类型
 */
public class Test06 {

    public static void test01(Map<String, User> map, List<User> list){
        System.out.println("test01()");
    }

    public static Map<String, User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // 通过反射获取方法
        Method method = Test06.class.getMethod("test01", Map.class, List.class);
        // 获取方法的参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println(" ===> " + genericParameterType);
            // 获取参数中的包含的泛型类型
            // 如果当前值是参数化类型，则将其强转为真实的参数化类型
            if (genericParameterType instanceof ParameterizedType){
                // 获取真实的参数信息
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("---> " + actualTypeArgument);
                }
            }
        }


        Method method1 = Test06.class.getMethod("test02", null);
        // 获取方法的返回值类型
        Type genericReturnType = method1.getGenericReturnType();
        System.out.println("genericReturnType = " + genericReturnType);
        // 获取返回值类型中的泛型参数类型
        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(" < = > " + actualTypeArgument);
            }
        }
    }
}
