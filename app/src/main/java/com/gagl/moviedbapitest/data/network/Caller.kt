package com.gagl.moviedbapitest.data.network

import com.gagl.moviedbapitest.data.domain.Resource
import org.json.JSONObject
import retrofit2.Response

suspend fun <T : Any> handleApi(
    call: suspend () -> Response<T>,
    errorMessage: String = "No se ha logrado completar la solicitud"
): Resource<T> {
    try {
        val response = call()
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.success(it)
            }
        }
        response.errorBody()?.let {
            return try {
                val errorString = it.string()
                val errorObject = JSONObject(errorString)
                Resource.error(
                    errorObject.getString("status_message") ?: errorMessage
                )
            } catch (ignored: Exception) {
                Resource.error(ignored.message)
            }
        }
        return Resource.error(errorMessage)
    } catch (e: Exception) {
        return Resource.error(errorMessage)
    }
}