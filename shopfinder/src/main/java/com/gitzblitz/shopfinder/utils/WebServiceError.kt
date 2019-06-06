package com.gitzblitz.shopfinder.utils

import android.util.Log
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException

object WebServiceError {
    val TAG: String = WebServiceError::class.java.simpleName

    fun handleError(e: Throwable) {
        // handle http errors
        // handle other errors eg sockettimeout timeout, unknown hos

        when (e) {
            is HttpException -> handleHTTPExceptions(e)
            is UnknownHostException -> handleUnknownHostException(e)
            is SocketException -> handleSocketException(e)
            else -> handleOtherExceptions(e)

        }
    }

    private fun handleOtherExceptions(e: Throwable) {
        e.printStackTrace()
    }

    private fun handleSocketException(e: SocketException) {
        logException("Socket Exception", e)

    }

    private fun handleUnknownHostException(e: UnknownHostException) {
        logException("Unknown host", e)
    }


    private fun handleHTTPExceptions(e: HttpException) {
        when (e.code()) {
            301 -> logException("Permanently Moved", e)
            400 -> logException("Bad Request", e)
            404 -> logException("Not Found", e)
            405 -> logException("Method Not Allowed", e)
            406 -> logException("Not Acceptable", e)
            408 -> logException("Request Timeout", e)
            500 -> logException("Internal Server", e)
            503 -> logException("Service Unavailable", e)

        }
    }


    private fun logException(message: String, e: Exception) {
        Log.e(TAG, message)
        e.printStackTrace()
    }
}