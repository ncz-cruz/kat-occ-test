import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.SelectorType

// Ação 1: Digita o SKU no campo de busca
WebUI.setText(findTestObject('03 - Websites/Home/input-SearchProduct'), sku_id)

// Ação 2: Espera o wrapper de sugestões aparecer
WebUI.waitForElementVisible(findTestObject('03 - Websites/Home/wrapper-SearchSuggestions'), 10)

// Ação 3: Clica na sugestão de produto específica
String searchedProductxpath = "//div[contains(@class,'suggestions-wrapper')]//button[@data-pid='${sku_id}']"
TestObject product = new TestObject("Produto: " + sku_id)
product.addProperty("xpath", SelectorType.XPATH, searchedProductxpath)
WebUI.click(product)

