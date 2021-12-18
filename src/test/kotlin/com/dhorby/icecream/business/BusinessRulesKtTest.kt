package com.dhorby.icecream.business

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import java.math.BigDecimal


class BusinessRulesKtTest {

    private val expectedResultsForBuy2Get1Free = mapOf<Int, BigDecimal>(
        1 to BigDecimal(1),
        2 to BigDecimal(2),
        3 to BigDecimal(2),
        4 to BigDecimal(3),
        5 to BigDecimal(4),
        6 to BigDecimal(4),
        7 to BigDecimal(5),
        8 to BigDecimal(6),
        9 to BigDecimal(6)
    )

    private val expectedResultsForBuy2Get1HalfPrice = mapOf<Int, BigDecimal>(
        1 to BigDecimal(1),
        2 to BigDecimal(2),
        3 to BigDecimal(2.5),
        4 to BigDecimal(3.5),
        5 to BigDecimal(4.5),
        6 to BigDecimal(5),
        7 to BigDecimal(6),
        8 to BigDecimal(7),
        9 to BigDecimal(7.5)
    )

    @Test
    fun `verify buy 2 get 1 free calculations`() {
        expectedResultsForBuy2Get1Free.forEach { (itemCount, expectedPayableItemCount) ->
            assertThat(buy2Get1Free(itemCount).setScale(2), equalTo(expectedPayableItemCount.setScale(2)))
        }
    }

    @Test
    fun `verify buy 2 get 1 half price calculations`() {
        expectedResultsForBuy2Get1HalfPrice.forEach { (itemCount, expectedPayableItemCount) ->
            assertThat("For test input $itemCount", buy2Get1HalfPrice(itemCount).setScale(2), equalTo(expectedPayableItemCount.setScale(2)))
        }
    }


}
