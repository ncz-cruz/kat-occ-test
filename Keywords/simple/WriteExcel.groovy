package simple

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	FileInputStream file;
	XSSFSheet currentSheet;
	XSSFWorkbook workbook;

	//Keywords

	@Keyword
	void writeDataCell(String dataPath, int rowNum, int colNum,String value){
		String newDataPathName = changeExcelFileName(dataPath)
		openSheet(newDataPathName)
		if(currentSheet!=null){
			currentSheet.getRow(rowNum).createCell(colNum).setCellValue(value);
			saveWorkbookIntoFile(newDataPathName)
		}
		else{
			println("datasheet is null")
		}
	}

	@Keyword
	void setupDataFile(String dataPath){
		String newDataPathName = changeExcelFileName(dataPath)
		openSheet(dataPath)
		if(currentSheet!=null){
			saveWorkbookIntoFile(newDataPathName)
		}
		else{
			println("datasheet is null")
		}
	}



	//METHODS
	void openSheet(String dataPath){
		FileInputStream file = new FileInputStream(new File(dataPath))
		workbook = new XSSFWorkbook(file);
		currentSheet = workbook.getSheetAt(0);
		file.close();
	}

	void saveWorkbookIntoFile(String dataPath){
		FileOutputStream outFile =new FileOutputStream(new File(dataPath));
		this.workbook.write(outFile);
		outFile.close();
	}

	String changeExcelFileName(String fileName){
		int dotIndex = fileName.lastIndexOf(".");
		String fileNamepart = fileName.substring(0,dotIndex)
		return fileNamepart+"_output.xlsx"
	}
}