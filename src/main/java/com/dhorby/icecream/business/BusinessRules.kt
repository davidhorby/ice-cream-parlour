package com.dhorby.icecream.business

import java.math.BigDecimal

typealias ItemCount = Int

fun ItemCount.buy2Get1Free(): BigDecimal {
    val freeItemCount = (this / 3).toBigDecimal()
    return toBigDecimal() - freeItemCount
}

fun ItemCount.buy2Get1HalfPrice(): BigDecimal {
    val discount = BigDecimal(0.5)
    val freeItemCount = (this / 3).toBigDecimal() * discount
    return (toBigDecimal() - freeItemCount).setScale(2)
}

