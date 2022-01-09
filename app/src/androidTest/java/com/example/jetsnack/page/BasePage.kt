package com.example.jetsnack.page

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.jetsnack.ui.MainActivity
import com.example.jetsnack.common.Constants.FIRST_HEADING
import com.example.jetsnack.common.Constants.HOME_FEED
import com.example.jetsnack.common.TestData
import com.example.jetsnack.common.Utils
import com.example.jetsnack.ui.JetsnackApp

abstract class BasePage(composeTestRule : AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) {
     var composeTestRule :  AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity> = composeTestRule

     //var testData : TestData = Utils.readTestDataFromServer()
     var testData : TestData = Utils.readTestDataHardcoded()

     fun setUpPage(){
          composeTestRule.setContent {
               JetsnackApp()
          }
     }

     fun validateAppLaunch(){
          composeTestRule.onNodeWithText(getAppString(HOME_FEED).uppercase()).assertIsDisplayed()
          composeTestRule.onNodeWithText(FIRST_HEADING).assertIsDisplayed()
     }

     fun getAppString(strId : Int) : String{
          return composeTestRule.activity.getString(strId)
     }

     fun getAppString(strId : Int, i : Int) : String{
          return composeTestRule.activity.getString(strId, i)
     }


     open fun openPage(){

     }
     open fun validatePage(){

     }
}