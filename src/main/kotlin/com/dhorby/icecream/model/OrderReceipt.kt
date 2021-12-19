package com.dhorby.icecream.model

import com.dhorby.icecream.business.BusinessRules.calculateTotal
import com.dhorby.icecream.business.BusinessRules.summariseTotal


class OrderReceipt(private val orderList:List<Order>) {

    fun printReceipt() {
        println("Item\tQuantity\tUnit\tPrice\tTotal")
        orderList.forEach {  order ->
            println("${order.flavour}\t\t${order.numberOfItems}\t${order.flavour.price}\t${order.calculateTotal().totalCost}")
        }
        val (totalCost, totalDiscount) = orderList.summariseTotal()
        val totalOrder = totalCost + totalDiscount
        println("Total Order $totalOrder")
        println("Total Promos -$totalDiscount")
        println("Total To Pay $totalCost")
    }
}
