package com.dhorby.icecream.handlers

import com.dhorby.icecream.business.buy2Get1FreeFunction
import com.dhorby.icecream.model.Flavour
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class FlavourCalculationHandlerTest {

    @Test
    fun `verify the discount calculations for Rocky Road flavour`() {
        val flavourCalculationHandler = FlavourCalculationHandler(Flavour.ROCKY_ROAD)
        val total = flavourCalculationHandler.calculateTotal(1)
        assertThat(total, equalTo(BigDecimal(8).setScale(2)))
    }

    @Test
    fun `verify the discount calculations for Cookies and Cream flavour`() {
        val flavourCalculationHandler = FlavourCalculationHandler(Flavour.COOKIE_CREAM)
        val total = flavourCalculationHandler.calculateTotal(3)
        assertThat(total, equalTo(BigDecimal(25).setScale(2)))
    }

    @Test
    fun `verify the discount calculations for netflix & Chill flavour`() {
        val flavourCalculationHandler = FlavourCalculationHandler(Flavour.NETFLIX_CHILL)
        val total = flavourCalculationHandler.calculateTotal(2)
        assertThat(total, equalTo(BigDecimal(24).setScale(2)))
    }
}
