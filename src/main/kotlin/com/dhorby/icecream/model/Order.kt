package com.dhorby.icecream.model

import com.dhorby.icecream.business.BusinessRules.calculateTotal
import com.dhorby.icecream.exception.InvalidQuantityException

data class Order private constructor (val numberOfItems:Int, val flavour: Flavour) {
    companion object {
        fun of(numberOfItems:Int, flavour: Flavour): Order =
            if(numberOfItems < 0) throw InvalidQuantityException("Invalid quantity for order $numberOfItems")
            else Order(numberOfItems, flavour)
    }

    override fun toString(): String {
        return  "$flavour    $numberOfItems    ${this.flavour.price} ${calculateTotal().totalCost}"
    }
}
