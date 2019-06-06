package com.gitzblitz.shopfinder

import com.gitzblitz.shopfinder.model.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {

    @GET("cities")
    fun getAllCities(): Single<Data>

    @GET("city/{cityId}/malls")
    fun getMallsByCity(@Path("cityId") cityId: String): Single<List<Mall>?>

    @GET("city/{cityId}/mall/{mallId}")
    fun getMall(
        @Path("cityId") cityId: String,
        @Path("mallId") mallId: String
    ): Single<Mall>

    @GET("city/{cityId}")
    fun getCity(@Path("cityId") cityId: String): Single<City>

    @GET("city/{cityId}/mall/{mallId}/shop/{shopId}")
    fun getShop(
        @Path("cityId") cityId: String,
        @Path("mallId") mallId: String,
        @Path("shopId") shopId: String
    ): Single<Shop>
}