package com.dhorby.icecream.business

import java.math.BigDecimal

typealias DiscountFunction = (Int) -> BigDecimal


fun discountItems(itemCount:Int, itemsNeededForDiscount:Int, discount:BigDecimal): BigDecimal {
    val freeItemCount = (itemCount / (itemsNeededForDiscount + 1)).toBigDecimal() * discount
    return itemCount.toBigDecimal() - freeItemCount
}

val buy2Get1FreeFunction:DiscountFunction  = { itemCount ->
    discountItems(
        itemCount = itemCount,
        itemsNeededForDiscount = 2,
        discount = BigDecimal(1)
    )
}


val buy2Get1HalfPriceFunction:DiscountFunction = { itemCount ->
    discountItems(
        itemCount = itemCount,
        itemsNeededForDiscount = 2,
        discount = BigDecimal(0.5)
    )
}

