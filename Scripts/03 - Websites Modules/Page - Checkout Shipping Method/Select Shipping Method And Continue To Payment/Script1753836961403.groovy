import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject

TestObject deliveryType

// 2. Decide qual Test Object usar com base no valor da variável.
if (shipping_method == 'Normal') {
    deliveryType= findTestObject('03 - Websites/Checkout - ShippingMethods/radio-Normal')
	
} else if (shipping_method == 'RetiraNaLoja') {
	
    deliveryType = findTestObject('03 - Websites/Checkout - ShippingMethods/radio-RetiraNaLoja')
} else if (shipping_method == 'Transportadora') {
	
	deliveryType = findTestObject('03 - Websites/Checkout - ShippingMethods/radio-Transportadora')
	
} else {
    // Falha o teste se um valor inesperado for passado.
    KeywordUtil.markFailedAndStop("Método de entrega desconhecido: " + shipping_method)
}

KeywordUtil.logInfo("Processando o método de entrega: " + shipping_method)

// 3. Espera o radio button estar presente na página.
WebUI.waitForElementPresent(deliveryType, 10)

// 4. Verifica se o radio button JÁ está selecionado.
if (WebUI.isElementChecked(deliveryType, 5) == false) {
    // 4a. Se não estiver selecionado, clica nele.
    KeywordUtil.logInfo("Método de entrega não estava selecionado. Clicando agora...")
    WebUI.click(deliveryType)
} else {
    // 4b. Se já estava selecionado, apenas registra no log.
    KeywordUtil.logInfo("Método de entrega já estava selecionado.")
}

// 5. Clica no botão para continuar para a próxima etapa (Pagamento).
def submitButton = findTestObject('03 - Websites/Checkout - ShippingMethods/bttn-SubmitShipping')
WebUI.waitForElementClickable(submitButton, 5)
WebUI.click(submitButton)

WebUI.waitForElementClickable(findTestObject('03 - Websites/Checkout - ShippingMethods/bttn-SubmitShipping'), 5)
WebUI.click(findTestObject('03 - Websites/Checkout - ShippingMethods/bttn-SubmitShipping'))
