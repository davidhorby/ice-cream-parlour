package com.dhorby.icecream.business

import java.math.BigDecimal

typealias ItemCount = Int


fun ItemCount.buy2Get1Free(): BigDecimal {
    val freeItemCount = (this / 3).toBigDecimal()
    val totalPayableItems = this.toBigDecimal() - freeItemCount
    return totalPayableItems
}


