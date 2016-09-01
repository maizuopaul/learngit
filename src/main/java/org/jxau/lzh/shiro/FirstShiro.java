package org.jxau.lzh.shiro;

import java.util.Iterator;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class FirstShiro {
	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhang2", "123");
		try{
			subject.login(token);
			Object object = subject.getPrincipal();
			boolean authen = subject.isAuthenticated();
			subject.logout();
			boolean authen2 = subject.isAuthenticated();
			System.out.println("hahaha");
		}catch(AuthenticationException ex){
			ex.printStackTrace();
		}
		
	}
}
