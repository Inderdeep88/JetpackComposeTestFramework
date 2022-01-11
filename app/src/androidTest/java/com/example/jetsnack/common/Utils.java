package com.example.jetsnack.common;

import static androidx.compose.ui.test.FiltersKt.hasScrollToIndexAction;
import static androidx.compose.ui.test.FiltersKt.hasText;

import androidx.compose.runtime.CompositionLocalContext;
import androidx.compose.ui.test.SemanticsNodeInteraction;
import androidx.compose.ui.test.junit4.AndroidComposeTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.jetsnack.R;
import com.example.jetsnack.common.Snack_1;
import com.example.jetsnack.ui.MainActivity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Utils {
    static TestData testData = null;

    /*
    This method returns data required for validation.
    As backend is not available, used mocked API.
    */
    public static TestData readTestDataFromServer(){
        try {
            testData = new ObjectMapper().readValue(new URL("https://run.mocky.io/v3/fcffb47b-3903-4ae7-b745-3cd0552016c4"), TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
    }

    /*
    This method returns data required for validation.
    As backend is not available, used this hardcoded data.
    */
    public static TestData readTestDataHardcoded(){
        try {
            testData = new ObjectMapper().readValue("{\"homePageData\":[{\"name\":\"Android's picks\",\"type\":\"TYPE_1\",\"snacks\":[\"Cupcake\",\"Donut\",\"Eclair\",\"Froyo\",\"Gingerbread\",\"Honeycomb\",\"Ice Cream Sandwich\",\"Jellybean\",\"KitKat\",\"Lollipop\",\"Marshmallow\",\"Nougat\",\"Oreo\"]},{\"name\":\"Popular on Jetsnack\",\"type\":\"TYPE_2\",\"snacks\":[\"Chips\",\"Pretzels\",\"Smoothies\",\"Popcorn\",\"Almonds\"]},{\"name\":\"WFH favourites\",\"type\":\"TYPE_1\",\"snacks\":[\"Cupcake\",\"Donut\",\"Eclair\",\"Froyo\",\"Gingerbread\",\"Honeycomb\",\"Ice Cream Sandwich\",\"Jellybean\",\"KitKat\",\"Lollipop\",\"Marshmallow\",\"Nougat\",\"Oreo\"]},{\"name\":\"Newly Added\",\"type\":\"TYPE_2\",\"snacks\":[\"Chips\",\"Pretzels\",\"Smoothies\",\"Popcorn\",\"Almonds\"]},{\"name\":\"Only on Jetsnack\",\"type\":\"TYPE_1\",\"snacks\":[\"Cupcake\",\"Donut\",\"Eclair\",\"Froyo\",\"Gingerbread\",\"Honeycomb\",\"Ice Cream Sandwich\",\"Jellybean\",\"KitKat\",\"Lollipop\",\"Marshmallow\",\"Nougat\",\"Oreo\"]}],\"detailsPageData\":[{\"name\":\"Customers also bought\",\"type\":\"TYPE_2\",\"snacks\":[\"Cupcake\",\"Donut\",\"Eclair\",\"Froyo\",\"Gingerbread\",\"Honeycomb\",\"Ice Cream Sandwich\",\"Jellybean\",\"KitKat\",\"Lollipop\",\"Marshmallow\",\"Nougat\",\"Oreo\"]},{\"name\":\"Popular on Jetsnack\",\"type\":\"TYPE_2\",\"snacks\":[\"Chips\",\"Pretzels\",\"Smoothies\",\"Popcorn\",\"Almonds\"]}],\"cartPageData\":{\"address\":\"Delivery to 1600 Amphitheater Way\",\"cartItems\":{\"Gingerbread\":\"2\",\"Ice Cream Sandwich\":\"3\",\"KitKat\":\"1\"},\"bottomList\":[{\"name\":\"Inspired by your cart\",\"type\":\"TYPE_2\",\"snacks\":[\"Cupcake\",\"Donut\",\"Eclair\",\"Froyo\",\"Gingerbread\",\"Honeycomb\",\"Ice Cream Sandwich\",\"Jellybean\",\"KitKat\",\"Lollipop\",\"Marshmallow\",\"Nougat\",\"Oreo\"]}]},\"snacks\":[{\"id\":\"1\",\"name\":\"Cupcake\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/pGM4sjt_BdQ\",\"price\":\"299\"},{\"id\":\"2\",\"name\":\"Donut\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/Yc5sL-ejk6U\",\"price\":\"299\"},{\"id\":\"3\",\"name\":\"Eclair\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/-LojFX9NfPY\",\"price\":\"299\"},{\"id\":\"4\",\"name\":\"Froyo\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/3U2V5WqK1PQ\",\"price\":\"299\"},{\"id\":\"5\",\"name\":\"Gingerbread\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/Y4YR9OjdIMk\",\"price\":\"499\"},{\"id\":\"6\",\"name\":\"Honeycomb\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/bELvIg_KZGU\",\"price\":\"299\"},{\"id\":\"7\",\"name\":\"Ice Cream Sandwich\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/YgYJsFDd4AU\",\"price\":\"1299\"},{\"id\":\"8\",\"name\":\"Jellybean\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/0u_vbeOkMpk\",\"price\":\"299\"},{\"id\":\"9\",\"name\":\"KitKat\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/yb16pT5F_jE\",\"price\":\"549\"},{\"id\":\"10\",\"name\":\"Lollipop\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/AHF_ZktTL6Q\",\"price\":\"299\"},{\"id\":\"11\",\"name\":\"Marshmallow\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/rqFm0IgMVYY\",\"price\":\"299\"},{\"id\":\"12\",\"name\":\"Nougat\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/qRE_OpbVPR8\",\"price\":\"299\"},{\"id\":\"13\",\"name\":\"Oreo\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/33fWPnyN6tU\",\"price\":\"299\"},{\"id\":\"14\",\"name\":\"Pie\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/aX_ljOOyWJY\",\"price\":\"299\"},{\"id\":\"15\",\"name\":\"Chips\",\"imageUrl\":\"https://source.unsplash.com/UsSdMZ78Q3E\",\"price\":\"299\"},{\"id\":\"16\",\"name\":\"Pretzels\",\"imageUrl\":\"https://source.unsplash.com/7meCnGCJ5Ms\",\"price\":\"299\"},{\"id\":\"17\",\"name\":\"Smoothies\",\"imageUrl\":\"https://source.unsplash.com/m741tj4Cz7M\",\"price\":\"299\"},{\"id\":\"18\",\"name\":\"Popcorn\",\"imageUrl\":\"https://source.unsplash.com/iuwMdNq0-s4\",\"price\":\"299\"},{\"id\":\"19\",\"name\":\"Almonds\",\"imageUrl\":\"https://source.unsplash.com/qgWWQU1SzqM\",\"price\":\"299\"},{\"id\":\"20\",\"name\":\"Cheese\",\"imageUrl\":\"https://source.unsplash.com/9MzCd76xLGk\",\"price\":\"299\"},{\"id\":\"21\",\"name\":\"Apples\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/1d9xXWMtQzQ\",\"price\":\"299\"},{\"id\":\"22\",\"name\":\"Apple sauce\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/wZxpOw84QTU\",\"price\":\"299\"},{\"id\":\"23\",\"name\":\"Apple chips\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/okzeRxm_GPo\",\"price\":\"299\"},{\"id\":\"24\",\"name\":\"Apple juice\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/l7imGdupuhU\",\"price\":\"299\"},{\"id\":\"25\",\"name\":\"Apple pie\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/bkXzABDt08Q\",\"price\":\"299\"},{\"id\":\"26\",\"name\":\"Grapes\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/y2MeW00BdBo\",\"price\":\"299\"},{\"id\":\"27\",\"name\":\"Kiwi\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/1oMGgHn-M8k\",\"price\":\"299\"},{\"id\":\"28\",\"name\":\"Mango\",\"tagline\":\"A tag line\",\"imageUrl\":\"https://source.unsplash.com/TIGDsyy0TK4\",\"price\":\"299\"}]}", TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
    }

    /*
    Returns Snack object for snack name
    */
    public static Snack_1 getSnack(String name){
        for ( Snack_1 s: testData.snacks) {
            if (s.name.equals(name))
                return new Snack_1(s);
        }
        throw new AssertionError("Invalid Snack Name : "+name);
    }

    /*
    Returns formatted price String for validation
    */
    public static String formatPrice(String price){
        return "$"+price.substring(0, price.length()-2) + "." + price.substring(price.length()-2);
    }

    /*
    This method returns true if the input node exists on the UI
    */
    public static Boolean isNodeVisible(SemanticsNodeInteraction node){
        try{
            node.assertExists("Not visible");
            return true;
        }catch (Error e){
            return false;
        }
    }
}
