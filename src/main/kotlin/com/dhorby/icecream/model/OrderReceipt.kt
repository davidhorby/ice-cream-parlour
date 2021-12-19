package com.dhorby.icecream.model

import com.dhorby.icecream.business.BusinessRules.summariseTotal


class OrderReceipt(private val orderList:List<Order>) {

    fun printReceipt() {
        println("Item\tQuantity\tUnit\tPrice\tTotal")
        orderList.forEach {  order ->
            println(order.toString())
        }
        val (totalCost, totalDiscount) = orderList.summariseTotal()
        val totalOrder = totalCost + totalDiscount
        println("Total Order $totalOrder")
        println("Total Promos -$totalDiscount")
        println("Total To Pay $totalCost")
    }
}
