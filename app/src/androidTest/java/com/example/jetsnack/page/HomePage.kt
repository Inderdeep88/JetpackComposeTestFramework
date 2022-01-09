package com.example.jetsnack.page

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.jetsnack.common.Constants.*
import com.example.jetsnack.ui.MainActivity

class HomePage(composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) : BasePage(
    composeTestRule
) {

    override fun openPage() {
        composeTestRule.onNodeWithText(getAppString(HOME_FEED).uppercase()).performClick().assertIsDisplayed()
    }

    override fun validatePage() {
        composeTestRule.onNodeWithText(FIRST_HEADING.uppercase()).assertIsDisplayed()
    }

    fun scrollToRail(railname : String){
        composeTestRule.onRoot(useUnmergedTree = false).printToLog("TAG")
        composeTestRule.onAllNodes(hasScrollAction())[0].performScrollToNode(hasText(railname))
    }

}