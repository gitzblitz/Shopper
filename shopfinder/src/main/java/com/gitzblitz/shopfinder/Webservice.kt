package com.gitzblitz.shopfinder

import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {

    @GET("cities")
    fun getAllCities()

    @GET("city/{cityId}/malls")
    fun getMallsByCity(@Path("cityId") cityId: String)

    @GET("city/{cityId}/mall/{mallId}")
    fun getMall(
        @Path("cityId") cityId: String,
        @Path("mallId") mallId: String
    )

    @GET("city/{cityId}")
    fun getCity(@Path("cityId") cityId: String)

    @GET("city/{cityId}/mall/{mallId}/shop/{shopId}")
    fun getShop(
        @Path("cityId") cityId: String,
        @Path("mallId") mallId: String,
        @Path("shopId") shopId: String
    )
}