package com.dhorby.icecream.handlers

import com.dhorby.icecream.model.Flavour
import java.math.BigDecimal


interface CalculationHandler<T> {

    fun calculateTotal(
        numberOfItems: Int
    ): BigDecimal

}

class FlavourCalculationHandler(val flavour: Flavour) : CalculationHandler<Flavour> {
    override fun calculateTotal(
        numberOfItems: Int
    ): BigDecimal {
        val itemsToChargeFor: BigDecimal = flavour.discountFunction?.invoke(numberOfItems)?:numberOfItems.toBigDecimal()
        return (flavour.price.toBigDecimal() * itemsToChargeFor).setScale(2)
    }
}
