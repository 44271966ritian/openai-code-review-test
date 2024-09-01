package cn.tyy.demo2;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyBeanFactory implements FactoryBean {

    @Override
    public Object getObject() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class[] classes = {IUserDao.class};
        InvocationHandler handler = (proxy, method, args) -> "你被代理了 " + method.getName();

        return Proxy.newProxyInstance(classLoader, classes, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IUserDao iUserDao = IUserDao.class.newInstance();
        System.out.println("iUserDao = " + iUserDao);
    }

}
