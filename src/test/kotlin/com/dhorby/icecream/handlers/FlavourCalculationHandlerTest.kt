package com.dhorby.icecream.handlers

import com.dhorby.icecream.model.Flavour
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class FlavourCalculationHandlerTest {

    @Test
    fun `verify the discount calculations for Rocky Road flavour`() {
        val flavourCalculationHandler = FlavourCalculationHandler(Flavour.ROCKY_ROAD)
        val paymentBreakdown = flavourCalculationHandler.calculateTotal(1)
        assertThat(paymentBreakdown.totalCost, equalTo(BigDecimal(8).setScale(2)))
    }

    @Test
    fun `verify the discount calculations for Cookies and Cream flavour`() {
        val flavourCalculationHandler = FlavourCalculationHandler(Flavour.COOKIE_CREAM)
        val paymentBreakdown = flavourCalculationHandler.calculateTotal(3)
        assertThat(paymentBreakdown.totalCost, equalTo(BigDecimal(25).setScale(2)))
    }

    @Test
    fun `verify the discount calculations for netflix & Chill flavour`() {
        val flavourCalculationHandler = FlavourCalculationHandler(Flavour.NETFLIX_CHILL)
        val paymentBreakdown = flavourCalculationHandler.calculateTotal(2)
        assertThat(paymentBreakdown.totalCost, equalTo(BigDecimal(24).setScale(2)))
    }
}
