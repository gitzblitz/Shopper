package com.gitzblitz.shopfinder.model
import com.squareup.moshi.Json


data class Data(
    @Json(name = "cities")
    val cities: List<City>
)

data class City(
    @Json(name = "id")
    val id: Int,
    @Json(name = "malls")
    val malls: List<Mall>,
    @Json(name = "name")
    val name: String
)

data class Mall(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "shops")
    val shops: List<Shop>
)

data class Shop(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)