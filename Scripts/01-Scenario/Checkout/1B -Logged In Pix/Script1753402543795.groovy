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

//Initializing browser
//WebUI.callTestCase(findTestCase('02 - Katalon Modules/Scenario Pre Script'), ['test_case':test_case])
//Scenario steps
WebUI.callTestCase(findTestCase('03 - Websites Modules/Page - Home/Search And Add Sku From Principal Search'), ['sku_id':sku_id])
//WebUI.callTestCase(findTestCase('02 - Katalon Modules/Check Visual'), ['screenName':"1A - Simple Cart Page"])
WebUI.callTestCase(findTestCase('03 - Websites Modules/Page - Cart/Checkout Cart'),[:])
WebUI.callTestCase(findTestCase('03 - Websites Modules/Page - Login from Cart'),[:])
WebUI.callTestCase(findTestCase('03 - Websites Modules/Page - Checkout Shipping Address/Input Valid Shipping Address'),['first_name':first_name,'last_name':last_name,'zip_postal':zip_postal, 'address1':address1,'city':city,'hood':hood,'number':number,'complement':complement,'reference':reference,'phone':phone])
//WebUI.callTestCase(findTestCase('02 - Katalon Modules/Check Visual'), ['screenName':"1A - Simple Shipping Page"])
WebUI.callTestCase(findTestCase('03 - Websites Modules/Page - Checkout Shipping Method/Select Shipping Method And Continue To Payment'),['shipping_method':shipping_method])
//WebUI.callTestCase(findTestCase('02 - Katalon Modules/Check Visual'), ['screenName':"1A - Simple Payment Page"])
WebUI.callTestCase(findTestCase('03 - Websites Modules/Page - Checkout Payment/Select Pix And Submit Payment'),[:])
WebUI.callTestCase(findTestCase('03 - Websites Modules/Page - Checkout Payment/Place Order'),[:])
//WebUI.callTestCase(findTestCase('02 - Katalon Modules/Check Visual'), ['screenName':"1A - Simple Order Confirmation Page "])
WebUI.callTestCase(findTestCase('03 - Websites Modules/Page - Checkout Order Confirmation/Print Order'),[:])
//Saving output data and closing browser
WebUI.callTestCase(findTestCase('02 - Katalon Modules/Scenario Post Script for Checkout'),['order_number':order_number,'order_total':order_total,'client_email':client_email])
