package com.testfan.excel4j;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;

public class ExcelUtils4JTest {
	
	public static void main(String[] args) throws InvalidFormatException, Excel4JException, IOException {
		 String path=System.getProperty("user.dir")+File.separator+"data"+File.separator+"test.xlsx";
		 List<StudentExcel> list = ExcelUtils.getInstance().readExcel2Objects(path, StudentExcel.class);
		System.out.println(list);
		
		ExcelUtils.getInstance().exportObjects2Excel(list, StudentExcel.class, "result.xlsx");
	}

}
