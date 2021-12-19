package com.dhorby.icecream.model

import org.junit.jupiter.api.Test

internal class OrderReceiptTest {

    @Test
    fun printReceipt() {
        val orders: List<Order> = listOf(
            Order.of(1, Flavour.ROCKY_ROAD),
            Order.of(3, Flavour.COOKIE_CREAM),
            Order.of(2, Flavour.NETFLIX_CHILL)
        )
        OrderReceipt(orders).printReceipt()
    }
}
