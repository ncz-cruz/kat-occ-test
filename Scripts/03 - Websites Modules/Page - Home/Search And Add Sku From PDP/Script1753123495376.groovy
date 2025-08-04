// Script do Test Case: 'BuscarEAdicionarProduto'

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.SelectorType

def searchField = findTestObject('03 - Websites/Home/input-SearchProduct')

WebUI.setText(searchField, sku_id)
WebUI.sendKeys(searchField, Keys.chord(Keys.ENTER))

WebUI.waitForElementClickable('03 - Websites/Checkout - Order Confirmation/bttn-PrintOrder', 10)
WebUI.enhancedClick(findTestObject('03 - Websites/Checkout - Order Confirmation/bttn-PrintOrder'))

// Ação 4: Na Página do Produto (PDP), adiciona ao carrinho
WebUI.waitForElementPresent(findTestObject('ObjectRepository/PDP/bttn-PDP_AddToCart'), 10)
WebUI.click(findTestObject('ObjectRepository/PDP/bttn-PDP_AddToCart'))