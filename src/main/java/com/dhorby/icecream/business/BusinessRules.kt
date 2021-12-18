package com.dhorby.icecream.business

import java.math.BigDecimal

typealias ItemCount = Int


fun discountItems(itemCount:Int, itemsNeededForDiscount:Int, discount:BigDecimal): BigDecimal {
    val freeItemCount = (itemCount / (itemsNeededForDiscount + 1)).toBigDecimal() * discount
    return itemCount.toBigDecimal() - freeItemCount
}

fun buy2Get1Free(itemCount: Int): BigDecimal {
    return discountItems(
        itemCount = itemCount,
        itemsNeededForDiscount = 2,
        discount = BigDecimal(1)
    )
}

fun buy2Get1HalfPrice(itemCount: Int): BigDecimal {
    return discountItems(
        itemCount = itemCount,
        itemsNeededForDiscount = 2,
        discount = BigDecimal(0.5)
    )
}

