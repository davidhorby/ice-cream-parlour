package com.dhorby.icecream

import com.dhorby.icecream.model.Flavour
import com.dhorby.icecream.model.Order
import com.dhorby.icecream.model.OrderReceipt


object IceCreamParlourApp {

    @JvmStatic
    fun main(args: Array<String>) {
        val orders: List<Order> = listOf(
            Order.of(1, Flavour.ROCKY_ROAD),
            Order.of(3, Flavour.COOKIE_CREAM),
            Order.of(2, Flavour.NETFLIX_CHILL)
        )
        OrderReceipt(orders).printReceipt()
    }
}
