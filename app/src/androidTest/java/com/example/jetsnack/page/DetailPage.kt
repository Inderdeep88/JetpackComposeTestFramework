package com.example.jetsnack.page

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.jetsnack.ui.MainActivity
import com.example.jetsnack.common.Constants.*
import com.example.jetsnack.common.ListOnPage
import com.example.jetsnack.common.ListOnPageType
import com.example.jetsnack.common.Snack_1
import com.example.jetsnack.common.Utils

class DetailPage(composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) : BasePage(
    composeTestRule
) {
    var snackName : String = ""
    var qty: Int = 1
    var homeLopType: ListOnPageType = ListOnPageType.TYPE_1

    override fun openPage() {
        composeTestRule.onNodeWithText("Chips").performClick()
    }

    fun openPage(snackName : String) {
        this.snackName = snackName
        composeTestRule.onAllNodes(hasText(snackName))[0].assertIsDisplayed()
        composeTestRule.onAllNodes(hasText(snackName))[0].performClick()
    }

    fun openPage(snackName : String, homeLopType : ListOnPageType) {
        openPage(snackName)
        this.homeLopType = homeLopType
    }

    override fun validatePage() {
        var s : Snack_1 = Utils.getSnack(snackName);
        composeTestRule.onNode(hasNoClickAction() and hasText(snackName)).assertIsDisplayed()
        composeTestRule.onNodeWithText(Utils.formatPrice(s.price.toString())).assertIsDisplayed()
        if(this.homeLopType.equals(ListOnPageType.TYPE_2)){
            composeTestRule.onNodeWithText(s.tagline).assertIsDisplayed()
        }
        composeTestRule.onNodeWithText(getAppString(DETAILS_TEXT)).assertIsDisplayed()
        composeTestRule.onNodeWithText(DETAIL_DESC_TEXT, substring = true).assertIsDisplayed()
        composeTestRule.onAllNodes(hasScrollAction())[0].performGesture { swipeUp() }
        composeTestRule.onRoot(useUnmergedTree = false).printToLog("TAG")
        composeTestRule.onAllNodes(hasScrollAction())[0].performScrollToNode(hasText(getAppString(INGREDIENTS_TEXT)))
        composeTestRule.onNodeWithText(getAppString(INGREDIENTS_TEXT)).assertIsDisplayed()
        composeTestRule.onNodeWithText(getAppString(INGREDIENTS_LIST_TEXT)).assertIsDisplayed()
    }

    fun validatePageBottomBar(){
        composeTestRule.onNodeWithText(getAppString(QUANTITY_TITLE)).assertIsDisplayed()
        composeTestRule.onNode(hasContentDescription(getAppString(INCREASE_LABEL))).assertIsDisplayed()
        composeTestRule.onNode(hasContentDescription(getAppString(DECREASE_LABEL))).assertIsDisplayed()
        composeTestRule.onNode(hasText(qty.toString()) and hasAnySibling(hasContentDescription(getAppString(DECREASE_LABEL)))).assertIsDisplayed()
        composeTestRule.onNodeWithText(getAppString(ADD_LABEL)).assertIsDisplayed()
    }

    fun validateSeeMore(){
        composeTestRule.onAllNodes(hasScrollAction())[0].performGesture { swipeUp() }
        composeTestRule.onAllNodes(hasScrollAction())[0].performScrollToNode(hasText(getAppString(SEE_MORE_LABEL)))
        composeTestRule.onNodeWithText(getAppString(SEE_MORE_LABEL)).assertIsDisplayed()
        composeTestRule.onNodeWithText(getAppString(SEE_MORE_LABEL)).performClick()
        composeTestRule.onAllNodes(hasScrollAction())[0].performGesture { swipeUp() }
        composeTestRule.onAllNodes(hasScrollAction())[0].performScrollToNode(hasText(getAppString(SEE_LESS_LABEL)))
        composeTestRule.onNodeWithText(getAppString(SEE_LESS_LABEL)).assertIsDisplayed()
    }

    fun addProduct(){
        composeTestRule.onNode(hasContentDescription(getAppString(INCREASE_LABEL))).performClick()
        qty++
    }

    fun removeProduct(){
        composeTestRule.onNode(hasContentDescription(getAppString(DECREASE_LABEL))).performClick()
        if(qty > 0)
            qty--
    }

    fun validateQty(){
        composeTestRule.onNode(hasText(qty.toString()) and hasAnySibling(hasContentDescription(getAppString(
            DECREASE_LABEL)))).assertIsDisplayed()
    }

    fun increaseQty(num : Int){
        for (i in 1..num){
            addProduct()
        }
    }

    fun decreaseQty(num : Int){
        for (i in 1..num){
            removeProduct()
        }
    }

    fun validateRails(){
        var lop : ArrayList<ListOnPage> = super.testData.detailsPageData
        var i : Int =0
        composeTestRule.onRoot(useUnmergedTree = false).printToLog("TAG")
        composeTestRule.onRoot(useUnmergedTree = false).performGesture { swipeUp() }
        for(listTestData in lop){
            composeTestRule.onNodeWithText(listTestData.name).assertIsDisplayed()
            var UIList = composeTestRule.onAllNodes(hasScrollToIndexAction() and hasAnySibling(hasText(listTestData.name)))[i++]
            for (snackTestData in listTestData.snacks){
                var sTestData : Snack_1 = Utils.getSnack(snackTestData);
                UIList.performScrollToNode(hasText(sTestData.name))
                UIList.onChildren().assertAny(hasText(sTestData.name))
                if(listTestData.type.equals(ListOnPageType.TYPE_1)){
                    UIList.onChildren().assertAny(hasText(sTestData.tagline))
                }
            }
        }
    }

}