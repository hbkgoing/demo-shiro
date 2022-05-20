package com.example.demoshiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DelegatingSubject;

public class QuickStart {

    public static void main(String[] args) {

        //shiro 微内核，需要做的事-：利用Filter来为servlet做一层封装。
        //1.转换httpRequest/response
        //2.组装好最重要的两个组件 securityManager、Subject。
        //3.鉴权
        SecurityManager manager = new DefaultSecurityManager();
        PrincipalCollection identity = new SimplePrincipalCollection("jack", "testRealm");

        Subject subject = new DelegatingSubject(identity, false, null, null, manager);

        subject.execute(()-> System.out.println(subject.getPrincipal()));
        System.out.println(subject);

    }
}
