package com.testfan.dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.testfan.db.DbUser;

//https://blog.csdn.net/a911711054/article/details/77719685
//参考例子
public class DbutilsQueryTest {
	public static void main(String[] args) {
		query();
	}
	
	private static void query() {
		// dbutis使用数据源
 		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from t_user_test2";
		try {
//			 有对象反射1
			List<DbUser> list = (List<DbUser>) runner.query(sql, new BeanListHandler(DbUser.class));
			System.out.println(list);
			for (DbUser dbUser : list) {
				System.out.print(dbUser.getLoginname()+" ");
				System.out.print(dbUser.getLoginpass());
				System.out.println("000");
			}
//			 有对象反射2
			DbUser dbUser =  (DbUser) runner.query("select * from t_user_test where uid=?", new BeanHandler(DbUser.class),"21e25344-e8df-4346-8196-bfab7ab26958");
			System.out.println(dbUser);
		
			
			
			
			//没有对象
			Map<String, Object> mapobject =runner.query("select * from t_user_test where uid=?",new MapHandler(),"21e25344-e8df-4346-8196-bfab7ab26958");
			System.out.println(mapobject);
			List<Map<String, Object>> listmap = runner.query("select * from t_user_test", new MapListHandler());
			System.out.println(listmap);
			System.out.println();
//			System.out.println(list);
			for (Map<String, Object> map : listmap) {
			  Set<String> keys = map.keySet();
			  for (String key : keys) {
				  System.out.println(key +" "+map.get(key)+" \t");
			  }
			  System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
