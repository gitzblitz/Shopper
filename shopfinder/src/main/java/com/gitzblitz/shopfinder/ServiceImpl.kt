package com.gitzblitz.shopfinder

import com.gitzblitz.shopfinder.model.City
import com.gitzblitz.shopfinder.model.Mall
import com.gitzblitz.shopfinder.model.Shop
import io.reactivex.schedulers.Schedulers

object ServiceImpl {

    private val service = ServiceGenerator.provideWebService()


    fun getCities(): List<City> {
        var cities = listOf<City>()

        service.getAllCities()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({ result ->
                result.let {
                    cities = it ?: listOf()
                }
            }, {

            })

        return cities

    }

    fun getMallsByCity(cityId: String): List<Mall> {
        var malls = listOf<Mall>()

        service.getMallsByCity(cityId)
            .subscribeOn(Schedulers.io())
            .subscribe { result, error ->
                result.let {
                    malls = it ?: listOf()
                }

                error.printStackTrace()
            }

        return malls
    }

    fun getMall(cityId: String, mallId: String): Mall {
        var mall = Mall()
        service.getMall(cityId, mallId)
            .subscribeOn(Schedulers.io())
            .subscribe { result, error ->
                mall = result
                error.printStackTrace()
            }

        return mall
    }

    fun getCity(cityId: String): City {
        var city = City()
        service.getCity(cityId)
            .subscribeOn(Schedulers.io())
            .subscribe { result, error ->
                city = result

                error.printStackTrace()
            }

        return city
    }

    fun getShop(cityId: String, mallId: String, shopId: String): Shop {
        var shop = Shop()

        service.getShop(cityId, mallId, shopId)
            .subscribeOn(Schedulers.io())
            .subscribe { result, error ->
                shop = result

                error.printStackTrace()
            }

        return shop

    }


}