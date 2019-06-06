package com.gitzblitz.shopfinder.interfaces

import com.gitzblitz.shopfinder.webservice.ServiceImpl
import com.gitzblitz.shopfinder.model.City
import com.gitzblitz.shopfinder.model.Mall
import com.gitzblitz.shopfinder.model.Shop

// this will be a facade singleton class, entry point into the and on
class WebServiceFacade {

    fun getMallsByCity(cityId: String): List<Mall> = ServiceImpl.getMallsByCity(cityId)

    fun getCities(): List<City> = ServiceImpl.getCities()

    fun getMall(cityId: String, mallId: String): Mall = ServiceImpl.getMall(cityId, mallId)

    fun getCity(cityId: String): City = ServiceImpl.getCity(cityId)

    fun getShop(cityId: String, mallId: String, shopId: String): Shop = ServiceImpl.getShop(cityId,mallId,shopId)


}