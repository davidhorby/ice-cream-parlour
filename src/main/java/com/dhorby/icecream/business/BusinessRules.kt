package com.dhorby.icecream.business

import com.dhorby.icecream.model.DiscountBreakdown
import com.dhorby.icecream.model.Order
import com.dhorby.icecream.model.PaymentBreakdown
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

fun Order.calculateTotal(): PaymentBreakdown {
    val paymentBreakdown: DiscountBreakdown = flavour.discountFunction?.invoke(numberOfItems) ?: DiscountBreakdown(
        numberOfItems.toBigDecimal(),
        BigDecimal(0)
    )
    val totalPaid = paymentBreakdown.paidForItems * flavour.price.toBigDecimal()
    val totalDiscount = paymentBreakdown.freeItems * flavour.price.toBigDecimal()
    return PaymentBreakdown(totalPaid.setScale(2), totalDiscount.setScale(2))
}


fun List<Order>.summariseTotal(): PaymentBreakdown {
    val payments: List<PaymentBreakdown> = this.map { order ->
        order.calculateTotal()
    }
    val totalCost = payments.sumOf { it.totalCost }
    val totalDiscount = payments.sumOf { it.totalDiscount }
    return PaymentBreakdown(totalCost, totalDiscount)
}
