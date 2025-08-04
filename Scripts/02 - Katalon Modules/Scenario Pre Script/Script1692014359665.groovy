// Script do seu módulo: 'PreScript_Setup'

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

// 1. ABRIR O NAVEGADOR
WebUI.openBrowser('')

// 2. NAVEGAR PARA A URL CORRETA (VINDA DO PROFILE)
KeywordUtil.logInfo("Navegando para a URL do Profile: " + GlobalVariable.urlFront)
WebUI.navigateToUrl(GlobalVariable.urlFront)

// 3. AJUSTAR A JANELA
WebUI.maximizeWindow()

// 4. LIDAR COM O BANNER DE COOKIES (ADAPTE O CAMINHO DO OBJETO)
// Este passo é crucial!
if (WebUI.waitForElementPresent(findTestObject('03 - Websites/Cookies/bttn-AcceptCookies'), 10)) {
	WebUI.click(findTestObject('03 - Websites/Cookies/bttn-AcceptCookies'))
	KeywordUtil.logInfo("Banner de cookies foi aceito.")
} else {
	KeywordUtil.logInfo("Banner de cookies não encontrado ou já foi aceito.")
}

// 5. PREPARAR VARIÁVEIS (OPCIONAL, mas boa prática)
// Passa o nome do caso de teste principal para a variável global, útil para logs futuros.
GlobalVariable.test_case = test_case
KeywordUtil.logInfo("Iniciando a execução do cenário: " + GlobalVariable.test_case)