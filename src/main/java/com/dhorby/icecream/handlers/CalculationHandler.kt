package com.dhorby.icecream.handlers

import com.dhorby.icecream.model.DiscountBreakdown
import com.dhorby.icecream.model.Flavour
import com.dhorby.icecream.model.PaymentBreakdown
import java.math.BigDecimal


interface CalculationHandler<T> {

    fun calculateTotal(
        numberOfItems: Int
    ): PaymentBreakdown

}

class FlavourCalculationHandler(private val flavour: Flavour) : CalculationHandler<Flavour> {
    override fun calculateTotal(
        numberOfItems: Int
    ): PaymentBreakdown {
        val paymentBreakdown: DiscountBreakdown = flavour.discountFunction?.invoke(numberOfItems) ?: DiscountBreakdown(
            numberOfItems.toBigDecimal(),
            BigDecimal(0)
        )
        val totalPaid = paymentBreakdown.paidForItems * flavour.price.toBigDecimal()
        val totalDiscount = paymentBreakdown.freeItems * flavour.price.toBigDecimal()
        return PaymentBreakdown(totalPaid.setScale(2), totalDiscount.setScale(2))
    }
}
