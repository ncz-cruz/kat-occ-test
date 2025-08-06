import com.kms.katalon.core.model.FailureHandling as FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')
KeywordUtil.logInfo("Navegando: " + GlobalVariable.urlFront)
WebUI.navigateToUrl(GlobalVariable.urlFront)

WebUI.maximizeWindow()

if (WebUI.waitForElementPresent(findTestObject('03 - Websites/Cookies/bttn-AcceptCookies'), 3, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('03 - Websites/Cookies/bttn-AcceptCookies'))
	KeywordUtil.logInfo("Banner de cookies foi encontrado e aceito.")
} else {
	KeywordUtil.logInfo("Banner de cookies não encontrado ou já foi aceito.")
}
GlobalVariable.test_case = test_case
KeywordUtil.logInfo("Iniciando a execução do cenário: " + GlobalVariable.test_case)
