import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.Point
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.apache.commons.lang.StringUtils

//Initializing browser
WebUI.callTestCase(findTestCase("null"),[:], FailureHandling.STOP_ON_FAILURE)

//Scenario steps
WebUI.callTestCase(findTestCase("null"), ["sku_id":sku_id], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase("null"),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase("null"),["number_of_star":number_of_star,"recommandationYN":recommandationYN,"reviewTitle":reviewTitle,"reviewText":reviewText,"nickName":nickName,"location":location,"tags":tags,"skinType":skinType,"ageRange":ageRange,"incentive":incentive,"email":email], FailureHandling.STOP_ON_FAILURE)

//Saving output data and closing browser
WebUI.callTestCase(findTestCase("null"),[:], FailureHandling.STOP_ON_FAILURE)
