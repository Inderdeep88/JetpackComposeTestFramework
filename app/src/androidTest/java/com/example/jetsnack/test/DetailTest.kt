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
import com.example.jetsnack.common.ListOnPageType
import com.example.jetsnack.page.DetailPage
import com.example.jetsnack.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    val detailPage = DetailPage(composeTestRule)

    @Before
    fun setUp() {
        detailPage.setUpPage()
    }

    @Test
    fun detailpage_navigateToDetailPage() {
        detailPage.openPage("Chips")
        detailPage.validatePage()
    }

    @Test
    fun detailpage_navigateToDetailPage_1() {
        detailPage.openPage("Cupcake", ListOnPageType.TYPE_2)
        detailPage.validatePage()
    }

    @Test
    fun detailpage_pageBottomBar() {
        detailPage.openPage("Chips")
        detailPage.validatePageBottomBar()
    }

    @Test
    fun detailpage_seeMore() {
        detailPage.openPage("Chips")
        detailPage.validateSeeMore()
    }

    @Test
    fun detailpage_increaseQtyOfItem() {
        detailPage.openPage("Chips")
        detailPage.increaseQty(3)
        detailPage.validatePageBottomBar()
    }

    @Test
    fun detailpage_decreaseQtyOfItem() {
        detailPage.openPage("Chips")
        detailPage.increaseQty(7)
        detailPage.decreaseQty(3)
        detailPage.validatePageBottomBar()
    }

    @Test
    fun detailpage_decreaseQtyOfItemToZero() {
        detailPage.openPage("Chips")
        detailPage.increaseQty(7)
        detailPage.decreaseQty(8)
        detailPage.validatePageBottomBar()
    }

    @Test
    fun detailpage_decreaseQtyOfItemToLessThanZero() {
        detailPage.openPage("Chips")
        detailPage.increaseQty(3)
        detailPage.decreaseQty(5)
        detailPage.validatePageBottomBar()
    }

    @Test
    fun detailpage_bottomProductRails() {
        detailPage.openPage("Chips")
        detailPage.validateRails()
    }

}
