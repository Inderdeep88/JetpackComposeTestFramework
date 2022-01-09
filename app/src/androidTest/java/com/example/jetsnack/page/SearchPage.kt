package com.example.jetsnack.page

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.jetsnack.ui.MainActivity

class SearchPage(composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) : BasePage(
    composeTestRule
) {

    override fun openPage() {
        composeTestRule.onNodeWithText("MY CART").performClick().assertIsDisplayed()
    }

    override fun validatePage() {
        composeTestRule.onNodeWithText("Order (3 items)").assertIsDisplayed()
    }

}