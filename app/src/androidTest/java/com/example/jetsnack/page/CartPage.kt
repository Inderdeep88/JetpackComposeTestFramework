package com.example.jetsnack.page

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.jetsnack.common.Constants.*
import com.example.jetsnack.ui.MainActivity
import com.example.jetsnack.common.ListOnPage
import com.example.jetsnack.common.ListOnPageType
import com.example.jetsnack.common.Snack_1
import com.example.jetsnack.common.Utils
import com.example.jetsnack.ui.utils.formatPrice

class CartPage(composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) : BasePage(
    composeTestRule
) {
    var cartPageTestData = super.testData.cartPageData

    override fun openPage() {
        composeTestRule.onNodeWithText(getAppString(HOME_CART).uppercase()).performClick().assertIsDisplayed()
    }

    override fun validatePage() {
        composeTestRule.onRoot(useUnmergedTree = false).printToLog("TAG")
        composeTestRule.onNode(hasTestTag(DEST_BAR) and hasAnyDescendant(hasText(cartPageTestData.address))).assertIsDisplayed()
        composeTestRule.onNodeWithText(getOrderTitle()).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(CHECKOUT_BUTTON) and hasAnyChild(hasText(getAppString(CART_CHECKOUT)))).assertIsDisplayed()
    }

    fun validateCartRails() {
        var lop: ArrayList<ListOnPage> = cartPageTestData.bottomList
        var i: Int = 0
       // composeTestRule.onRoot(useUnmergedTree = false).printToLog("TAG")
        composeTestRule.onAllNodes(hasScrollToIndexAction())[0].performGesture { swipeUp() }
        for (listTestData in lop) {
            composeTestRule.onNodeWithText(listTestData.name).assertIsDisplayed()
            var UIList = composeTestRule.onAllNodes(
                hasScrollToIndexAction() and hasAnySibling(
                    hasText(listTestData.name)
                )
            )[i++]
            for (snackTestData in listTestData.snacks) {
                var sTestData: Snack_1 = Utils.getSnack(snackTestData);
                UIList.performScrollToNode(hasText(sTestData.name))
                UIList.onChildren().assertAny(hasText(sTestData.name))
                if (listTestData.type.equals(ListOnPageType.TYPE_1)) {
                    UIList.onChildren().assertAny(hasText(sTestData.tagline))
                }
            }
        }
    }

    fun validateCartItems(){
        var subTotalCostStr = formatPrice(calculateSubTotalCost())
        var shippingCostStr= formatPrice(SHIPPING_COST_VALUE)
        var totalCostStr = formatPrice(calculateTotalCost())
        var orderTitle = getOrderTitle()

        composeTestRule.onNode(hasText(cartPageTestData.address)).assertIsDisplayed()
        composeTestRule.onRoot(useUnmergedTree = false).printToLog("TAG")
        composeTestRule.onNode(hasTestTag(ORDER_TITLE) and hasText(orderTitle)).assertIsDisplayed()

        for (snackTestData in cartPageTestData.cartItems.keys){
            var sTestData: Snack_1 = Utils.getSnack(snackTestData);

            composeTestRule.onNode(hasAnyChild(hasTestTag(ORDER_TITLE))).performScrollToNode(
                hasAnyChild(hasAnyChild(hasText(snackTestData,substring = true)))
            )

            var matcher = hasText(sTestData.tagline, substring = true) and
                    hasText(sTestData.name, substring = true) and
                    hasText(formatPrice(sTestData.price), substring = true) and
                    hasText("Qty", substring = true) and
                    hasText(cartPageTestData.cartItems.get(snackTestData).toString(), substring = true)

            composeTestRule.onNode(matcher).assertIsDisplayed()
            composeTestRule.onNode(hasParent(matcher) and hasTestTag(CROSS_BUTTON)).assertIsDisplayed()
            composeTestRule.onNode(hasParent(matcher) and hasTestTag(MINUS_SIGN)).assertIsDisplayed()
            composeTestRule.onNode(hasParent(matcher) and hasTestTag(PLUS_SIGN)).assertIsDisplayed()
        }

        composeTestRule.onNode(hasAnyChild(hasTestTag(ORDER_TITLE))).performScrollToNode(hasTestTag(TOTAL_TXT))

        composeTestRule.onNode(hasTestTag(SUMMARY_TXT) and hasText(getAppString(CART_SUMMARY_HEADER))).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(SUB_TOTAL_TXT) and hasText(getAppString(CART_SUBTOTAL_LABEL))).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(SUB_TOTAL_COST) and hasText(subTotalCostStr)).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(SHIP_AND_HAND_TXT) and hasText(getAppString(CART_SHIPPING_LABEL))).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(SHIPPING_COST) and hasText(shippingCostStr)).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(TOTAL_TXT) and hasText(getAppString(CART_TOTAL_LABEL))).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(TOTAL_COST) and hasText(totalCostStr)).assertIsDisplayed()
    }

    fun increaseItem(snackName : String, numOfdec : Int){
        var sTestData: Snack_1 = Utils.getSnack(snackName);
        var qtyCount = cartPageTestData.cartItems.get(snackName)

        composeTestRule.onNode(hasAnyChild(hasTestTag(ORDER_TITLE))).performScrollToNode(
            hasAnyChild(hasAnyChild(hasText(snackName, substring = true)))
        )

        var matcher = hasText(sTestData.tagline, substring = true) and
                hasText(sTestData.name, substring = true) and
                hasText(formatPrice(sTestData.price), substring = true) and
                hasText("Qty", substring = true)

        composeTestRule.onNode(matcher).assertIsDisplayed()
        for (i in 1..numOfdec) {
            composeTestRule.onNode(hasParent(matcher) and hasTestTag(PLUS_SIGN))
                .assertIsDisplayed()
            composeTestRule.onNode(hasParent(matcher) and hasTestTag(PLUS_SIGN))
                .performClick()
            if (qtyCount != null) {
                qtyCount = qtyCount + 1
            }
        }

        // Update Cart test data for validation later
        cartPageTestData.cartItems.put(snackName, qtyCount)
    }

    fun decreaseItem(snackName : String, numOfdec : Int){
        var sTestData: Snack_1 = Utils.getSnack(snackName);
        var qtyCount = cartPageTestData.cartItems.get(snackName)

        if (qtyCount!! >=numOfdec) {
            composeTestRule.onNode(hasAnyChild(hasTestTag(ORDER_TITLE))).performScrollToNode(
                hasAnyChild(hasAnyChild(hasText(snackName, substring = true)))
            )

            var matcher = hasText(sTestData.tagline, substring = true) and
                    hasText(sTestData.name, substring = true) and
                    hasText(formatPrice(sTestData.price), substring = true) and
                    hasText("Qty", substring = true)

            composeTestRule.onNode(matcher).assertIsDisplayed()
            for (i in 1..numOfdec) {
                composeTestRule.onNode(hasParent(matcher) and hasTestTag(MINUS_SIGN))
                    .assertIsDisplayed()
                composeTestRule.onNode(hasParent(matcher) and hasTestTag(MINUS_SIGN))
                    .performClick()
                if (qtyCount != null) {
                    qtyCount = qtyCount - 1
                }
            }

            // Update Cart test data for validation later
            if (qtyCount == 0){
                cartPageTestData.cartItems.remove(snackName)
            } else {
                cartPageTestData.cartItems.put(snackName, qtyCount)
            }

        }else{
            throw AssertionError("Qty for "+ snackName + " on Cart page is less than number of Decrements in passed Test")
        }

    }

    fun removeItemByCross(snackName : String){
        var sTestData: Snack_1 = Utils.getSnack(snackName);

        composeTestRule.onNode(hasAnyChild(hasTestTag(ORDER_TITLE))).performScrollToNode(
            hasAnyChild(hasAnyChild(hasText(snackName, substring = true)))
        )

        var matcher = hasText(sTestData.tagline, substring = true) and
                hasText(sTestData.name, substring = true) and
                hasText(formatPrice(sTestData.price), substring = true) and
                hasText("Qty", substring = true)

        composeTestRule.onNode(matcher).assertIsDisplayed()

        composeTestRule.onNode(hasParent(matcher) and hasTestTag(CROSS_BUTTON))
            .assertIsDisplayed()
        composeTestRule.onNode(hasParent(matcher) and hasTestTag(CROSS_BUTTON))
            .performClick()

        // Update Cart test data for validation later
        cartPageTestData.cartItems.remove(snackName)
    }

    fun removeItemBySwipe(snackName : String){
        var sTestData: Snack_1 = Utils.getSnack(snackName);

        composeTestRule.onNode(hasAnyChild(hasTestTag(ORDER_TITLE))).performScrollToNode(
            hasAnyChild(hasAnyChild(hasText(snackName, substring = true)))
        )

        var matcher = hasText(sTestData.tagline, substring = true) and
                hasText(sTestData.name, substring = true) and
                hasText(formatPrice(sTestData.price), substring = true) and
                hasText("Qty", substring = true)

        composeTestRule.onNode(matcher).assertIsDisplayed()

        composeTestRule.onNode(hasAnyChild(matcher) and hasTestTag("swipDismiss")).performGesture { swipeLeft() }

        // Update Cart test data for validation later
        cartPageTestData.cartItems.remove(snackName)
    }

    fun calculateSubTotalCost() : Long{
        var subTotalCost = 0L
        for (snackTestData in cartPageTestData.cartItems.keys){
            var sTestData: Snack_1 = Utils.getSnack(snackTestData);
            subTotalCost += (sTestData.price * (cartPageTestData.cartItems.get(snackTestData)!!))
        }
        return subTotalCost
    }

    fun calculateTotalCost() : Long{
        return calculateSubTotalCost() + SHIPPING_COST_VALUE
    }

    fun getOrderTitle() : String {
        if (cartPageTestData.cartItems.size == 1){
            return "Order (1 item)"
        } else{
            return "Order ("+ cartPageTestData.cartItems.size + " items)"
        }
    }


}