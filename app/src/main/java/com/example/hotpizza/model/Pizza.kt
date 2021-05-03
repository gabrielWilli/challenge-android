package com.example.hotpizza.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.*

data class Pizza(
        @SerializedName("id")
        val idPizza: String = generateId(),

        @SerializedName("name")
        val name: String,

        @SerializedName("imageUrl")
        val imageUrl: String,

        @SerializedName("rating")
        val rating: Int,

        @SerializedName("priceP")
        val priceP: Double,

        @SerializedName("priceM")
        val priceM: Double,

        @SerializedName("priceG")
        val priceG: Double,
) {
    companion object {
        private const val prefix = "PIZ"

        private fun generateId(): String {
            return "$prefix${UUID.randomUUID()}"
        }
    }
}