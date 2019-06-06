# Shopper
This is a project that uses the ShopFinder Library API module

# Library
Access the public methods of the API from the `WebServiceFacade.kt` . Instantiate an object of the facade


```kotlin
val service by lazy { WebServiceFacade()}

```

## API endpoints

These are the endpoint to fetch the required data

```kotlin
//return list of cities
getCities()

// return list of malls in particular city
getMallsByCity(cityId: String)

//get an individual mall given the cityId and mallId
getMall(cityId: String, mallId: String)

//get a city
getCity(cityId: String)

//get a shop
getShop(cityId: String, mallId: String, shopId: String)

```

## Usage

```kotlin 
service.getAllCities() // returns a list of cities

```

## Dependencies used
1. Retrofit
2. RxJava
3. OkHttp