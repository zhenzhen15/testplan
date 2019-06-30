package com.testfan.dbutils;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.testfan.db.DbUser;

// 参考例子
//https://blog.csdn.net/a911711054/article/details/77719685
public class DbUtilsTest {

	public static void main(String[] args) {
//		try {
//			update();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
		
		try {
			add();
//			update();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	private static void update() throws SQLException {
		//ComboPooledDataSource ds = new ComboPooledDataSource();
		// dbutis使用数据源
//		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
//		// 可变变量  无限 也可以没有 也可以数组
//		Object[] objects= new Object[] {"123_test","333_test", "14ba4bd0-a0da-4a2c-b136-de036b54e98a"};
//		//runner.update("update t_user_test set loginname=?,loginpass=? where uid=?", "123_dbutils","123_dbutils","14ba4bd0-a0da-4a2c-b136-de036b54e98a");
//		runner.update(c);
//		runner.update("delete from t_user_test");
		
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
//		runner.update("update t_user_test2 set loginname=?,loginpass=? where uid=?", "123_dbutils","123_dbutils","849ee2b8-504a-4e28-98e9-d101d0ddbab3");
		runner.update("update t_user_test2 set loginname=?,loginpass=? where uid=?", new Object[] {"1_dbutils","1_dbutils","849ee2b8-504a-4e28-98e9-d101d0ddbab3"});
	}
	
	private static void add() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		runner.update("delete from t_user_test");
		for (int i = 0; i < 1000; i++) {
			Object[] objects= new Object[] {UUID.randomUUID().toString(),"test"+i, "pass"+i};
			runner.update("insert INTO t_user_test(uid,loginname,loginpass) values(?,?,?)", objects);
		}
	}
	
	
	private static void test(String...o) {
		for (String string : o) {
			System.out.println(string);
		}
	}

}
