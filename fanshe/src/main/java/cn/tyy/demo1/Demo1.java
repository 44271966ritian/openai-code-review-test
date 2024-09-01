package cn.tyy.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //通过反射操作目标对象

        //1.通过全类名+forName获取到Class对象
        Class<?> targetClass = Class.forName("cn.tyy.demo1.TargetObject");

        //2.newInstance()获取实例对象
        TargetObject object = (TargetObject) targetClass.newInstance();
        //3.getDeclaredMethods获取所有方法
        Method[] declaredMethods = targetClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("method.getName() = " + method.getName());
        }


        //4.获得指定方法并且调用
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(object,"hrbstu");

        //5.暴力破解参数
        //  下面破解私有方法输出value
        Field value = targetClass.getDeclaredField("value");
        value.setAccessible(true);
        value.set(object,"JavaGuide");

        //6.暴力破解方法
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(object);

    }
}
