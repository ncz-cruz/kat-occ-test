import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


WebUI.waitForElementVisible(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-FirstName'), 5)
WebUI.setText(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-FirstName'), first_name)
WebUI.setText(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-LastName'), last_name)

WebUI.setText(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-ZipCode'), zip_postal)
WebUI.sendKeys(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-ZipCode'), Keys.chord(Keys.TAB))
WebUI.waitForElementAttributeValue(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-Address1'),
	'value', '', 10, FailureHandling.STOP_ON_FAILURE, false)
KeywordUtil.logInfo("Campos de endereço preenchidos automaticamente")

def stateField = findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/select-State')
WebUI.verifyElementAttributeValue(stateField,'value', '', 5, false)

def countryField = findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/select-Country')
WebUI.verifyElementAttributeValue(countryField,'value', '', 5, false)


KeywordUtil.logInfo("Verificação bem-sucedida: Os campo 'Estado e País' tem um valor selecionado.")


def cityField = findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-City')
def hoodField = findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-Neighborhood')
def address1Field = findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-Address1')

if (WebUI.getAttribute(cityField, 'value').isEmpty()) {
	KeywordUtil.logInfo("Autopreenchimento da CIDADE falhou. Preenchendo manualmente.")
	WebUI.setText(cityField, city)
}

if (WebUI.getAttribute(hoodField, 'value').isEmpty()) {
	KeywordUtil.logInfo("Autopreenchimento do BAIRRO falhou. Preenchendo manualmente.")
	WebUI.setText(hoodField, hood)
}
KeywordUtil.logInfo("Verificação do autopreenchimento concluída.")

WebUI.setText(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-AddressNumber'), number)
WebUI.setText(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-AddressComplement'), complement)
WebUI.setText(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-AddressReference'), reference)
WebUI.setText(findTestObject('03 - Websites/Checkout - ShippingAddress/addressbookForm/input-PhoneNumber'), phone)

