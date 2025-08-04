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

import internal.GlobalVariable

public class SelectComplexDropdown {

	/**
	 * Clica em um botão para abrir um dropdown customizado e seleciona uma opção (li) pelo texto.
	 * @param bttnDropdown O Test Object do botão que abre o dropdown.
	 * @param containerOptions O Test Object do container (ul/div) que aparece com as opções.
	 * @param optionText O texto exato da opção (li) a ser selecionada.
	 */
	@Keyword
	def selecionarOpcaoDropdownComplexo(TestObject bttnDropdown, TestObject containerOptions, String optionText) {

		// 1. Clica no botão para fazer a lista de opções aparecer
		WebUI.click(bttnDropdown)

		// 2. Espera a lista de opções ficar visível
		WebUI.waitForElementVisible(containerOptions, 5)

		// 3. Monta o XPath dinâmico para a opção específica
		String optionXpath = "//li[contains(., '" + optionText + "')]"

		// 4. Cria um Test Object "on-the-fly" para a opção desejada
		TestObject chosenOption = new TestObject("Opção: " + optionText)
		chosenOption.addProperty("xpath", SelectorType.XPATH, optionXpath)

		// 5. Clica na opção desejada
		WebUI.click(chosenOption)
	}
}

