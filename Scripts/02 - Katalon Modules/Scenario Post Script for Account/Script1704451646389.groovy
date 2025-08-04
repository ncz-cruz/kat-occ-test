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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


//If executed from a test suite then we need to write email in excel
testSuiteName = RunConfiguration.getExecutionSourceName().toString()
println(testSuiteName)
KeywordUtil.logInfo(testSuiteName)

excelPath = GlobalVariable.excel_path_account
println(excelPath)
KeywordUtil.logInfo(excelPath)
TestCaseName = test_case
println(TestCaseName)
KeywordUtil.logInfo(TestCaseName)
accountEmail = GlobalVariable.guestEmailRandomGenerated
println(accountEmail)
KeywordUtil.logInfo(accountEmail)

if (TestCaseName == '') {
	KeywordUtil.markFailedAndStop("Test case name is empty, excel write will fail so stopping execution here")
}
if (accountEmail == '') {
	KeywordUtil.markFailedAndStop("Account email is empty, excel write will fail so stopping execution here")
}

CustomKeywords.'simple.WriteExcel.writeDataByName'(excelPath,TestCaseName,'email',accountEmail)
GlobalVariable.isAnAccountCreation = 'nottrue'

//Close the browser
//WebUI.closeBrowser()
