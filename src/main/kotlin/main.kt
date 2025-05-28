package ru.netology

import kotlin.math.*

const val ERROR_CARD = -1
const val ERROR_LIMIT = -2

fun main() {
    val cardType: String = "Visa"
    val amountOfTransfer: Int = 10_000
    val sumOfPreviousTransfers = 0

    val commissionPayment = commission(cardType, sumOfPreviousTransfers, amountOfTransfer)
    println(commissionPayment)
}

fun commission(cardType: String, sumOfPreviousTransfers: Int, amountOfTransfer: Int): Int {
    if (amountOfTransfer > 150_000 || amountOfTransfer + sumOfPreviousTransfers > 600_000) return ERROR_LIMIT

    return when (cardType) {
        "Мир" -> 0
        "Mastercard" -> if (amountOfTransfer < 75000) 0 else ((amountOfTransfer - 75000) * 0.006).toInt() + 20
        "Visa" -> max((amountOfTransfer * 0.0075).toInt(), 35)
        else -> ERROR_CARD
    }
}