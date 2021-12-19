package com.dhorby.icecream.business

import com.dhorby.icecream.business.BusinessRules.buy2Get1FreeFunction
import com.dhorby.icecream.business.BusinessRules.buy2Get1HalfPriceFunction
import com.dhorby.icecream.business.BusinessRules.calculateTotal
import com.dhorby.icecream.business.BusinessRules.summariseTotal
import com.dhorby.icecream.exception.InvalidQuantityException
import com.dhorby.icecream.model.Flavour
import com.dhorby.icecream.model.Order
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal


class BusinessRulesKtTest {

    internal class DiscountCalculations {
        private val expectedResultsForBuy2Get1Free = mapOf(
            0 to BigDecimal(0),
            1 to BigDecimal(1),
            2 to BigDecimal(2),
            3 to BigDecimal(2),
            4 to BigDecimal(3),
            5 to BigDecimal(4),
            6 to BigDecimal(4),
            7 to BigDecimal(5),
            8 to BigDecimal(6),
            9 to BigDecimal(6)
        )

        private val expectedResultsForBuy2Get1HalfPrice = mapOf(
            0 to BigDecimal(0),
            1 to BigDecimal(1),
            2 to BigDecimal(2),
            3 to BigDecimal(2.5),
            4 to BigDecimal(3.5),
            5 to BigDecimal(4.5),
            6 to BigDecimal(5),
            7 to BigDecimal(6),
            8 to BigDecimal(7),
            9 to BigDecimal(7.5)
        )

        @Test
        fun `verify buy 2 get 1 free calculations`() {
            expectedResultsForBuy2Get1Free.forEach { (itemCount, expectedPayableItemCount) ->
                val discountedItemCount = buy2Get1FreeFunction.invoke(itemCount)
                assertThat(discountedItemCount.paidForItems.setScale(2), equalTo(expectedPayableItemCount.setScale(2)))
            }
        }

        @Test
        fun `verify buy 2 get 1 half price calculations`() {
            expectedResultsForBuy2Get1HalfPrice.forEach { (itemCount, expectedPayableItemCount) ->
                val discountedItemCount = buy2Get1HalfPriceFunction.invoke(itemCount)
                assertThat(
                    "For test input $itemCount",
                    discountedItemCount.paidForItems.setScale(2),
                    equalTo(expectedPayableItemCount.setScale(2))
                )
            }
        }
    }


    internal class OrderCalculations {
        @Test
        fun `verify the discount calculations for Rocky Road flavour`() {
            Order.of(1, Flavour.ROCKY_ROAD).let { order->
                val (totalCost, totalDiscount) = order.calculateTotal()
                assertThat(totalCost, equalTo(BigDecimal(8).setScale(2)))
                assertThat(totalDiscount, equalTo(BigDecimal(0).setScale(2)))
            }
        }

        @Test
        fun `verify the discount calculations for Cookies and Cream flavour`() {
            Order.of(3, Flavour.COOKIE_CREAM).let { order->
                val (totalCost, totalDiscount) = order.calculateTotal()
                assertThat(totalCost, equalTo(BigDecimal(25).setScale(2)))
                assertThat(totalDiscount, equalTo(BigDecimal(5).setScale(2)))
            }
        }

        @Test
        fun `verify the discount calculations for netflix & Chill flavour`() {
            Order.of(2, Flavour.NETFLIX_CHILL).let { order ->
                val (totalCost, totalDiscount) = order.calculateTotal()
                assertThat(totalCost, equalTo(BigDecimal(24).setScale(2)))
                assertThat(totalDiscount, equalTo(BigDecimal(0).setScale(2)))
            }

        }

        @Test
        fun `check that negative values in orders handled correctly`() {
            val exception: InvalidQuantityException = Assertions.assertThrows(InvalidQuantityException::class.java) {
                Order.of(-7, Flavour.COOKIE_CREAM)
            }
            Assertions.assertEquals("Invalid quantity for order -7", exception.message)
        }

        @Test
        fun `verify the discount calculations for an order wth several products`() {
            val orders: List<Order> = listOf(
                Order.of(1, Flavour.ROCKY_ROAD),
                Order.of(3, Flavour.COOKIE_CREAM),
                Order.of(2, Flavour.NETFLIX_CHILL)
            )
            val (totalCost, totalDiscount) = orders.summariseTotal()
            assertThat(totalCost, equalTo(BigDecimal(57).setScale(2)))
            assertThat(totalDiscount, equalTo(BigDecimal(5).setScale(2)))
        }

    }


}
