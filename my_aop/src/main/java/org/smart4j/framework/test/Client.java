package org.smart4j.framework.test;

/**
 * Created by CHEN on 2016/9/21.
 */
public class Client {
    public static void main(String[] args) {
        CglibRealSubject target = CglibDynamicProxy.getInstance().getProxy(
                CglibRealSubject.class
        );
        target.visit();
    }
}
