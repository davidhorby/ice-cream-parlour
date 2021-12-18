package com.dhorby.icecream.business

import com.dhorby.icecream.model.DiscountBreakdown
import java.math.BigDecimal


typealias DiscountFunction = (Int) -> DiscountBreakdown


fun discountItems(itemCount:Int, itemsNeededForDiscount:Int, discount:BigDecimal): DiscountBreakdown {
    val freeItemCount = (itemCount / (itemsNeededForDiscount + 1)).toBigDecimal() * discount
    val itemsToPayFor = itemCount.toBigDecimal() - freeItemCount
    return DiscountBreakdown(itemsToPayFor, freeItemCount)
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

