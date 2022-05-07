package com.example.testingapi.api.di


import com.example.testingapi.api.MainRepository
import com.example.testingapi.api.data.PieoneApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): PieoneApi {
        return Retrofit.Builder()
            .baseUrl("https://admin.dev.pieme.info/WebService/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PieoneApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: PieoneApi): MainRepository {
        return MainRepository(api)
    }
}