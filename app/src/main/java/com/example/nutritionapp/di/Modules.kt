package com.example.nutritionapp.di

import com.example.nutritionapp.data.repositoryimpl.RepositoryImp
import com.example.nutritionapp.data.source.remote.API
import com.example.nutritionapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Modules {
    @Provides
    @Singleton
    fun  provideRetrofit(): Retrofit {

        val logingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor();
        logingInterceptor.level  = HttpLoggingInterceptor.Level.BODY

        val httpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logingInterceptor)
            .build()

        val builder: Retrofit.Builder = Retrofit.Builder()
        val retrofit: Retrofit = builder.baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create())
            .client(httpClient)
            .build()

        return retrofit
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit):API{
        val api:API = retrofit.create(API::class.java)
        return api
    }
    @Provides
    @Singleton
    fun provideRepositoryImpl(api:API):RepositoryImp{
        return RepositoryImp(api)
    }

}