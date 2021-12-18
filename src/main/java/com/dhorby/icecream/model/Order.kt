package com.dhorby.icecream.model

data class Order private constructor (val numberOfItems:Int, val flavour:Flavour) {
    companion object {
        fun of(numberOfItems:Int, flavour:Flavour):Order? =
            if(numberOfItems < 0) null
            else Order(numberOfItems, flavour)
    }
}
