package com.dhorby.icecream.business

import java.math.BigDecimal

typealias ItemCount = Int

fun discountItems(itemCount:Int, itemsNeededForDiscount:Int, discount:BigDecimal): BigDecimal {
    val freeItemCount = (itemCount / (itemsNeededForDiscount + 1)).toBigDecimal() * discount
    return itemCount.toBigDecimal() - freeItemCount
}

fun ItemCount.buy2Get1Free(): BigDecimal {
    return discountItems(
        itemCount = this,
        itemsNeededForDiscount = 2,
        discount = BigDecimal(1)
    )
}

fun ItemCount.buy2Get1HalfPrice(): BigDecimal {
    return discountItems(
        itemCount = this,
        itemsNeededForDiscount = 2,
        discount = BigDecimal(0.5)
    )
}

