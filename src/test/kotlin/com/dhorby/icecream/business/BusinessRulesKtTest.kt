package com.dhorby.icecream.business

import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.assertion.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal


class BusinessRulesKtTest {

    @Test
    fun buy2Get1Free() {
        val itemCount:ItemCount = 3
        val expectedPayableItemCount = BigDecimal(2)
        assertThat(itemCount.buy2Get1Free(), equalTo(expectedPayableItemCount))
    }
}
