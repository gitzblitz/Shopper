package com.gitzblitz.shopfinder

import android.util.Log
import com.gitzblitz.shopfinder.model.City
import com.gitzblitz.shopfinder.model.Data
import com.gitzblitz.shopfinder.model.Mall
import com.gitzblitz.shopfinder.model.Shop
import com.gitzblitz.shopfinder.utils.WebServiceError
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

object ServiceImpl {

    private val service = ServiceGenerator.provideWebService()


    fun getCities(): List<City> {
        var cities = listOf<City>()

        service.getAllCities()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe { result, error ->
                result.let {
                    cities = it.cities?: listOf()
                }
                WebServiceError.handleError(error)
            }
        return cities

    }

    fun getMallsByCity(cityId: String): List<Mall> {
        var malls = listOf<Mall>()

        service.getMallsByCity(cityId)
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                result.let {
                    malls = it ?: listOf()
                }
            }, { error ->
                WebServiceError.handleError(error)
            })

        return malls
    }

    fun getMall(cityId: String, mallId: String): Mall {
        var mall = Mall()
        service.getMall(cityId, mallId)
            .subscribeOn(Schedulers.io())
            .subscribe { result, error ->
                mall = result
                WebServiceError.handleError(error)
            }

        return mall
    }

    fun getCity(cityId: String): City {
        var city = City()
        service.getCity(cityId)
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                city = result
            }, { error ->
                WebServiceError.handleError(error)
            })
        return city
    }

    fun getShop(cityId: String, mallId: String, shopId: String): Shop {
        var shop = Shop()

        service.getShop(cityId, mallId, shopId)
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                shop = result
            }, { error ->
                WebServiceError.handleError(error)
            })

        return shop

    }

}