package com.gagl.moviedbapitest.di

import com.gagl.moviedbapitest.data.network.TheMovieDbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    private const val TMDB_KEY =
    private const val URL = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    fun providesOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }

    @Provides
    @Singleton
    fun providesAuthInterceptor(): Interceptor {
        return Interceptor {
            val newRequest = it.request()
                .newBuilder()
                .url(it.request().url().newBuilder().addQueryParameter("api_key", TMDB_KEY).build()).build()
            it.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    fun providesRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun providesMovieApi(retrofit: Retrofit): TheMovieDbApi {
        return retrofit.create(TheMovieDbApi::class.java)
    }
}