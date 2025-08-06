// --- SCRIPT DE DIAGNÓSTICO ---

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

// PASSO 1: PAUSA LONGA PARA VOCÊ VER A TELA
// Durante este tempo, olhe para a janela do navegador e procure por qualquer
// banner de promoção, pop-up de newsletter ou outro elemento que apareça.
KeywordUtil.logInfo("INICIANDO PAUSA DE 15 SEGUNDOS PARA INSPEÇÃO VISUAL...")
WebUI.delay(15)

// PASSO 2: FOTO DA CENA DO CRIME
// Esta screenshot será salva no seu relatório e será a prova definitiva
// do que o robô está vendo no momento da falha.
KeywordUtil.logInfo("Tirando screenshot antes da tentativa de interação...")
WebUI.takeScreenshot()

// PASSO 3: TENTATIVA DE INTERAÇÃO (ESPERADO FALHAR)
// O teste provavelmente vai falhar aqui, mas não importa.
// O objetivo é analisar a screenshot que foi gerada.
try {
    WebUI.setText(findTestObject('03 - Websites/Home/input-SearchProduct'), sku_id)
} catch (Exception e) {
    KeywordUtil.markFailed("A interação falhou como esperado. Por favor, analise a screenshot no relatório para identificar o elemento bloqueador.")
}
