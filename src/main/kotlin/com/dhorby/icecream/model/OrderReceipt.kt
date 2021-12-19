package com.dhorby.icecream.model

import com.dhorby.icecream.business.calculateTotal

class OrderReceipt(val orderList:List<Order>) {

    fun printReceipt() {
        println("Item Quantity Unit Price Total")
        orderList.forEach {  order ->
            println("${order.flavour} ${order.numberOfItems} ${order.flavour.price} ${order.calculateTotal().totalCost}")
        }
    }
}
