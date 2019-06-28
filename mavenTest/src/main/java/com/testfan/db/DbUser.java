package com.testfan.db;

import com.github.crab2died.annotation.ExcelField;

//数据库模拟对象 
public class DbUser {
	@ExcelField(title = "用户Id")
	private String uid;
	@ExcelField(title = "登录名称")
	private String loginname;
	@ExcelField(title = "登录密码")
	private String loginpass;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpass() {
		return loginpass;
	}
	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}
	@Override
	public String toString() {
		return "DbUser [uid=" + uid + ", loginname=" + loginname + ", loginpass=" + loginpass + "]\n";
	}

}
