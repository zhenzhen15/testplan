package com.testfan.reflect;

import java.lang.reflect.Field;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;

import com.testfan.db.DbUser;

public class ReflectTest {
	
	public static void main(String[] args) {
		//传统构造方式
		//DbUser dbUser = new DbUser();
		//根据类的路径 匹配个对象
		try {
			//class 获取方式1
			Class clzClass = Class.forName("com.testfan.db.DbUser");
			//class 获取方式2 
			Class clzClass2= DbUser.class;
			//class 获取方式3
			Object object = clzClass.newInstance();
			Class clzClass3 = object.getClass();
			if(object instanceof DbUser) {
			System.out.println(" ok ");
			}
			//反射获取所有属性
			Field[] fields= clzClass3.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName());
			}
			//反射获取某个属性
			Field field = clzClass3.getDeclaredField("id");
			field.setAccessible(true);
			//通过反射对象赋值
			field.set(object, "test");
			System.out.println(object);
			//工具简化反射操作
			DbUser dbUser = new DbUser();
			BeanUtils.setProperty(dbUser, "id", "test111");
			System.out.println(dbUser);
			MethodUtils.invokeMethod(dbUser, "setLoginname", "哈哈");
			System.out.println(dbUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
