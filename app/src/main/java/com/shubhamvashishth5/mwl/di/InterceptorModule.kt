package com.shubhamvashishth5.mwl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InterceptorModule {

    @Provides
    @Singleton
    @Named("authTokenInterceptor")
    fun provideAuthTokenInterceptor(): Interceptor{
        return Interceptor { chain ->
            val url= chain.request().url
                .newBuilder()
                .addQueryParameter("api_key","f71acba4f6d494b5f7d66b19dde5267c")
                .build()
//            val request= chain.request()
//                .newBuilder()
//                .addHeader("api_Key","f71acba4f6d494b5f7d66b19dde5267c")
            val request= chain.request().newBuilder().url(url)
            chain.proceed(request.build())
        }
    }

    @Provides
    @Singleton
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }
    }

}