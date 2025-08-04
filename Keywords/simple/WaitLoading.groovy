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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

import internal.GlobalVariable

public class WaitLoading {

	@Keyword
	def static void waitloading(int waitUntilAppears, int waitUntilDisappears){

		//Prior to loader refactor
		/*if (WebUI.verifyElementPresent(findTestObject('SFCC-Storefront-BASE/Page-Home/image-Loading'), waitUntilAppears, FailureHandling.OPTIONAL)) {
		 WebUI.waitForElementNotVisible(findTestObject('SFCC-Storefront-BASE/Page-Home/image-Loading'), waitUntilDisappears, FailureHandling.OPTIONAL)
		 }
		 attribute = WebUI.getAttribute(findTestObject('SFCC-Storefront-BASE/Page-Home/image-Loading'), 'class')*/

		//New method after loader refactor findTestObject('SFCC-Storefront-BASE/Page-Home/body-Main')
		String attribute
		boolean stop = 0

		//Waiting a few seconds for body to be in loading mode (body always there)
		for (int i=0; i<waitUntilAppears; i++) {
			WebUI.waitForElementPresent(findTestObject('SFCC-Storefront-BASE/Page-Home/body-Main'),5,FailureHandling.STOP_ON_FAILURE)
			attribute = WebUI.getAttribute(findTestObject('SFCC-Storefront-BASE/Page-Home/body-Main'), 'class')
			KeywordUtil.logInfo("Iteration wait appear " + i + " and class equals : " + attribute)
			//If body not loading yet then keep waiting
			if (WebUI.verifyNotMatch(attribute, '.*loading', true,FailureHandling.OPTIONAL)) {
				KeywordUtil.logInfo("Body not loading yet, keep waiting")
				WebUI.delay(1)
			}
			//Else, meaning body (always there normally no need to check presence) is loading
			else {
				KeywordUtil.logInfo("Page body is loading - Waiting for loading to stop")
				//Checking each second if body is still loading
				for ( int j=0; j<waitUntilDisappears; j++) {
					WebUI.waitForElementPresent(findTestObject('SFCC-Storefront-BASE/Page-Home/body-Main'),5,FailureHandling.STOP_ON_FAILURE)
					attribute = WebUI.getAttribute(findTestObject('SFCC-Storefront-BASE/Page-Home/body-Main'), 'class')
					//If body not loading anymore
					if (WebUI.verifyNotMatch(attribute, '.*loading', true,FailureHandling.OPTIONAL)) {
						KeywordUtil.logInfo("Body not loading anymore, stoping wait for disappear")
						stop = 1
						break
					}
					//Else, meaning if element is both still there and loading, then we wait another second in the child loop
					else {
						KeywordUtil.logInfo("Iteration wait disappear " + j)
						WebUI.delay(1)
					}
				}
			}

			//If coming out of the waiting for disappear child loop, exiting parent loop also
			if (stop == 1) {
				KeywordUtil.logInfo("Body not loading anymore, existing wait for appear main loop")
				break
			}
		}
	}
}
