package org.smart4j.framework.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

import static javafx.scene.input.KeyCode.T;
import static sun.net.www.protocol.http.AuthCacheValue.Type.Proxy;

/**
 * Created by CHEN on 2016/9/21.
 */
public class ProxyManager {
    public static Object get(final Class<?> targetClass) {
        return Enhancer.create(targetClass, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("前置增强");
                methodProxy.invokeSuper(o,objects);
                System.out.println("后置增强");
                return null;
            }
        });
    }


}
