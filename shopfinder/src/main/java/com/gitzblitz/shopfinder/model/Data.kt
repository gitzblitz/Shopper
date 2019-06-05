package com.gitzblitz.shopfinder.model
import com.squareup.moshi.Json


data class Data(
    @Json(name = "cities")
    val cities: List<City>
)

data class City(
    @Json(name = "id")
    var id: Int = -1,
    @Json(name = "malls")
    var malls: List<Mall> = listOf(),
    @Json(name = "name")
    var name: String = ""
)

data class Mall(
    @Json(name = "id")
    val id: Int = -1,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "shops")
    val shops: List<Shop> = listOf()
)

data class Shop(
    @Json(name = "id")
    val id: Int = -1,
    @Json(name = "name")
    val name: String = ""
)