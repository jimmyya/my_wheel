package org.smart4j.framework.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by CHEN on 2016/9/21.
 */
public class CglibDynamicProxy implements MethodInterceptor {
//    private Object target;
//
//    public Object getProxyInstance(Object target) {
//        this.target = target;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(this.target.getClass());
//        enhancer.setCallback(this);
//        return enhancer.create();
//    }
//
//    @Override
//    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
//
//        System.out.println("前置增强");
//        proxy.invokeSuper(obj,objects);
//        System.out.println("后置增强");
//        return null;
//    }
    private static CglibDynamicProxy instance = new CglibDynamicProxy();

    public CglibDynamicProxy() {
    }

    public static CglibDynamicProxy getInstance () {
        return instance;
    }

    public <T> T getProxy (Class<T> cls) {
        //等同于
        //Enhancer.setSuper(cls)
        //Enhancer.setCallback(this)
        return (T) Enhancer.create(cls,this);
    }

    @Override
    public Object intercept(Object target, Method method,
                            Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result = methodProxy.invokeSuper(target, objects);//父类执行返回值
        System.out.println("after执行");
        return result;
    }
}
