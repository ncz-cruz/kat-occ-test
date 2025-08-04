import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.entity.testsuite.TestSuiteEntity

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

//Write main output strings into excel file
excelPath = GlobalVariable.excel_path
KeywordUtil.logInfo('excel path is: "' + excelPath + " AND test case : " + GlobalVariable.test_case + " AND order id : " + GlobalVariable.GV_order_number)	
CustomKeywords.'simple.WriteExcel.writeDataByName'(excelPath,GlobalVariable.test_case,"order_uuid",GlobalVariable.GV_order_number)
CustomKeywords.'simple.WriteExcel.writeDataByName'(excelPath,GlobalVariable.test_case,"total_amount",GlobalVariable.GV_order_total)
	
if(GlobalVariable.isAnAccountCreation == "true") {
	CustomKeywords.'simple.WriteExcel.writeDataByName'(excelPath,GlobalVariable.test_case,"login")
	GlobalVariable.isAnAccountCreation = "nottrue"
}

import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable

// 1. Registra os dados importantes no Log
KeywordUtil.logInfo("--- DADOS DO PEDIDO GERADO ---")
KeywordUtil.logInfo("Número do Pedido: " + GlobalVariable.order_number)
KeywordUtil.logInfo("Valor Total: " + GlobalVariable.order_total)
KeywordUtil.logInfo("Email Utilizado: " + GlobalVariable.client_email)
KeywordUtil.logInfo("---------------------------------")

// 2. Limpa as variáveis globais para o próximo teste
GlobalVariable.order_number = ""
GlobalVariable.order_total = ""
GlobalVariable.client_email = ""
