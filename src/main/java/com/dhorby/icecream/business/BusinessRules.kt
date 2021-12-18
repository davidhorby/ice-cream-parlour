package com.dhorby.icecream.business

import java.math.BigDecimal

typealias ItemCount = Int


fun discountItems(itemCount:Int, itemsNeededForDiscount:Int, discount:BigDecimal): BigDecimal {
    val freeItemCount = (itemCount / (itemsNeededForDiscount + 1)).toBigDecimal() * discount
    return itemCount.toBigDecimal() - freeItemCount
}

val buy2Get1FreeFunction:(itemCount: Int) -> BigDecimal  = { itemCount ->
    discountItems(
        itemCount = itemCount,
        itemsNeededForDiscount = 2,
        discount = BigDecimal(1)
    )
}


val buy2Get1HalfPriceFunction:(itemCount: Int) -> BigDecimal = { itemCount ->
    discountItems(
        itemCount = itemCount,
        itemsNeededForDiscount = 2,
        discount = BigDecimal(0.5)
    )
}

