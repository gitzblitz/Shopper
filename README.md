# Shopper
This is a project that uses the ShopFinder Library API module

# Library
Access the public methods of the API from the `WebServiceFacade.kt` . Instantiate an object of the facade


```kotlin
val service by lazy { WebServiceFacade()}

```

## Usage

```kotlin 
	service.getAllCities() // returns a list of cities

```

## Dependencies used
1. Retrofit
2. RxJava
3. OkHttp