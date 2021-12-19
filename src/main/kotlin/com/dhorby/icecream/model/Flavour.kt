package com.dhorby.icecream.model

import com.dhorby.icecream.business.BusinessRules.buy2Get1FreeFunction
import com.dhorby.icecream.business.BusinessRules.buy2Get1HalfPriceFunction
import com.dhorby.icecream.business.DiscountFunction


typealias ZDR = Int

enum class Flavour(val price: ZDR) {
    ROCKY_ROAD(8) {
        override val discountFunction: DiscountFunction = buy2Get1FreeFunction
    },
    COOKIE_CREAM(10) {
        override val discountFunction: DiscountFunction = buy2Get1HalfPriceFunction
    },
    NETFLIX_CHILL(12) {
        override val discountFunction: DiscountFunction? = null
    };

    abstract val discountFunction: DiscountFunction?
}



