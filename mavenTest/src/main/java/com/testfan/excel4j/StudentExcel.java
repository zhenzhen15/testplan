package com.testfan.excel4j;

import com.github.crab2died.annotation.ExcelField;

public class StudentExcel {
	
	 /**
     * id   
     */
	@ExcelField(title = "header1")
    private String testid;
    /**
     * 学号
     */
	@ExcelField(title = "header2")
    private String no;
    /**
     * 姓名
     */
	@ExcelField(title = "header3")
    private String name;
    /**
     * 学院
     */
	@ExcelField(title = "header4")
    private String college;
    /**
     * 成绩
     */
	@ExcelField(title = "header5")
    private float score;
	public String getTestid() {
		return testid;
	}
	public void setTestid(String testid) {
		this.testid = testid;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentExcel [testid=" + testid + ", no=" + no + ", name=" + name + ", college=" + college + ", score="
				+ score + "]";
	}
}
