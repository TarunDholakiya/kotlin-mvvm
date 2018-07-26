package com.tarun.samplekotlindemo1.application

import android.content.Context
import com.google.gson.Gson
import com.tarun.samplekotlindemo1.BuildConfig
import com.tarun.samplekotlindemo1.rest.RemoteConfig
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by TARUN on 26-Jul-18.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(gsonConverterFactory: GsonConverterFactory,
                         rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
                         okHttpClient1: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(RemoteConfig.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient1)
                .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(cache: Cache,
                             loggingInterceptor: Interceptor): OkHttpClient.Builder {
        val client = OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            client.addNetworkInterceptor(loggingInterceptor)
        }
        return client
    }

    @Provides
    @Singleton
    fun providesCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory? {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory? {
        return RxJava2CallAdapterFactory.create()
    }
}