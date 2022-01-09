/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetsnack.test

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.jetsnack.page.CartPage
import com.example.jetsnack.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class CartTest() {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    val cartPage = CartPage(composeTestRule)

    @Before
    fun setUp() {
        cartPage.setUpPage()
    }

    @Test
    fun cartpage_navigateToCartPage() {
        cartPage.openPage()
        cartPage.validatePage()
    }

    @Test
    fun cartpage_validateBottomRail() {
        cartPage.openPage()
        cartPage.validateCartRails()
    }

    @Test
    fun cartpage_validateCartItems() {
        cartPage.openPage()
        cartPage.validateCartItems()
    }

    @Test
    fun cartpage_validateQtyIncrease() {
        cartPage.openPage()
        cartPage.increaseItem("Gingerbread",2)
        cartPage.validateCartItems()
        cartPage.increaseItem("Ice Cream Sandwich",1)
        cartPage.validateCartItems()
        cartPage.increaseItem("KitKat",1)
        cartPage.validateCartItems()
    }

    @Test
    fun cartpage_validateQtyIncreaseFailure() {
        cartPage.openPage()
        cartPage.increaseItem("Gingerbread",6)
        cartPage.validateCartItems()
    }

    @Test
    fun cartpage_validateQtyDecrease() {
        cartPage.openPage()
        cartPage.decreaseItem("Gingerbread",1)
        cartPage.validateCartItems()
        cartPage.decreaseItem("Ice Cream Sandwich",2)
        cartPage.validateCartItems()
    }

    @Test
    fun cartpage_validateRemoveSingleItemByDecQty() {
        cartPage.openPage()
         cartPage.decreaseItem("KitKat",1)
         cartPage.validateCartItems()
    }

    @Test
    fun cartpage_validateRemoveMultiItemByDecQty() {
        cartPage.openPage()
        cartPage.decreaseItem("Gingerbread",2)
        cartPage.validateCartItems()
        cartPage.decreaseItem("KitKat",1)
        cartPage.validateCartItems()
    }

    @Test
    fun cartpage_validateRemoveSingleItemByCrossButton() {
        cartPage.openPage()
        cartPage.removeItemByCross("KitKat")
        cartPage.validateCartItems()
    }

    @Test
    fun cartpage_validateRemoveMultiItemByCrossButton() {
        cartPage.openPage()
        cartPage.removeItemByCross("Gingerbread")
        cartPage.validateCartItems()
        cartPage.removeItemByCross("KitKat")
        cartPage.validateCartItems()
    }

    @Test
    fun cartpage_validateRemoveItemBySwipeFailure() {
        cartPage.openPage()
        cartPage.removeItemBySwipe("Gingerbread")
        cartPage.validateCartItems()
    }
}
