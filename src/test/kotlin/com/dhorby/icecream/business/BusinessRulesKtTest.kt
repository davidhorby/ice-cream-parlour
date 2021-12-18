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

    @Test
    fun buy2Get1Free() {
        expectedResultsForBuy2Get1Free.forEach { (itemCount, expectedPayableItemCount) ->
            assertThat(itemCount.buy2Get1Free(), equalTo(expectedPayableItemCount))
        }
    }
}
