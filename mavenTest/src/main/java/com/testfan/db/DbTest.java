package com.testfan.db;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.crab2died.ExcelUtils;

public class DbTest {
	
	public static void main(String[] args) throws Exception {
		List<DbUser> list = getAllDbUserTest();
		System.out.println(list.size());
		dbtoFilebystream(list);
		//dbtoFilebywriter(list);
		dbtoExcel(list, DbUser.class);
		System.out.println(" 结束了 ");
	}
	
	private static void dbtoExcel(List<DbUser> list,Class clz) throws Exception {
		ExcelUtils.getInstance().exportObjects2Excel(list, clz, "result_db.xlsx");
	}
	
	private static void dbtoFilebystream(List<DbUser> list) throws Exception {
		String path="db2.csv";
		FileOutputStream fos=new FileOutputStream(path, true);
		for (DbUser dbUser : list) {
			fos.write(dbUser.toString().getBytes());
			System.out.println(dbUser);
		}
		fos.close();
	}
	
	private static void dbtoFilebywriter(List<DbUser> list) throws Exception {
		String path="db2.csv";
		FileWriter fw=new FileWriter(path, true);
		for (DbUser dbUser : list) {
			fw.write(dbUser.toString());
		}
		fw.close();
	}
	
	//jdk 原始代码
	public static List<DbUser> getAllDbUserTest(){
		Connection conn = null;
		Statement statement = null;
		List<DbUser> list =null;
		try {
			//找一个工具去连接数据库
			Class.forName("com.mysql.cj.jdbc.Driver");
			//连接数据库
			conn = DriverManager.getConnection
			("jdbc:mysql://118.24.13.38:3308/goods?characterEncoding=utf8&useSSL=false", "zhangsan", "123123");
			
			//准备sql
			String  sql= "select * from t_user_test";
			
			//创建执行sql对象
			statement = conn.createStatement();
			//执行sql, 获取返回结果集合
			ResultSet  set=statement.executeQuery(sql);
			list = new ArrayList<DbUser>();
			while (set.next()) {
				DbUser user = new DbUser();
				user.setUid(set.getString("uid"));
				user.setLoginname(set.getString("loginname"));
				user.setLoginpass(set.getString("loginpass"));
				list.add(user);
				//System.out.println(set.getString("uid")+" "+set.getString("loginname")+" "+set.getString("loginpass"));
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//数据库关闭
			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
