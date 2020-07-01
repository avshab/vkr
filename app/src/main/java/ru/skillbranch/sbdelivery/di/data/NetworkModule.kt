package ru.skillbranch.sbdelivery.di.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.skillbranch.sbdelivery.data.BuildConfig
import ru.skillbranch.sbdelivery.data.api.interceptors.ErrorInterceptor
import ru.skillbranch.sbdelivery.data.auth.api.util.AuthInterceptor
import ru.skillbranch.sbdelivery.data.auth.api.util.ModifiedInterceptor
import ru.skillbranch.sbdelivery.data.common.api.ResponseErrorBodyConverter
import ru.skillbranch.sbdelivery.di.app.AppScope
import ru.skillbranch.sbdelivery.domain.auth.login.AuthGateway
import ru.skillbranch.sbdelivery.utils.interceptor.ConnectionChecker
import java.util.concurrent.TimeUnit

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class NetworkModule {

    private companion object {
        const val READ_TIMEOUT_SECONDS = 5L

        // Examples: 2018-02-17T12:09:43, 2018-10-11T17:31:37
        const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    }

    @Provides
    @AppScope
    fun provideOkHttpClient(
        okHttpBuilder: OkHttpClient.Builder
    ): OkHttpClient {
        return okHttpBuilder
            .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    fun provideOkHttpClientBuilder(
        errorInterceptor: ErrorInterceptor,
        loggingInterceptor: LoggingInterceptor,
        //authInterceptor: AuthInterceptor,
        modifiedInterceptor: ModifiedInterceptor
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .callTimeout(50L, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(errorInterceptor)
            //.addInterceptor(authInterceptor)
            .addInterceptor(modifiedInterceptor)
    }

    @Provides
    @AppScope
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        retrofitBuilder: Retrofit.Builder
    ): Retrofit {
        return retrofitBuilder
            .client(okHttpClient)
            .build()
    }

    @Provides
    @AppScope
    fun provideLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
            .loggable(true)
            .setLevel(Level.BASIC)
            .setLevel(Level.HEADERS)
            .logger { level, tag, message ->
                when (level) {
                    Platform.INFO -> Log.i("--TAG", message)
                    Platform.WARN -> Log.e("--TAG", message)
                    else -> Log.d("--TAG", message)
                }
            }
            .build()
    }

    @Provides
    @AppScope
    fun provideResponseErrorBodyConverter(retrofit: Retrofit): ResponseErrorBodyConverter {
        return ResponseErrorBodyConverter(
            retrofit
        )
    }

    @Provides
    @AppScope
    fun provideErrorInterceptor(connectionChecker: ConnectionChecker): ErrorInterceptor {
        return ErrorInterceptor(connectionChecker)
    }

    @Provides
    fun provideRetrofitBuilder(
        gson: Gson
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_ENDPOINT)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Provides
    @AppScope
    fun provideGson(): Gson {
        return GsonBuilder().setDateFormat(DATE_FORMAT).create()
    }


    @Provides
    @AppScope
    fun provideAuthInterceptor(loginGateway: AuthGateway): AuthInterceptor {
        return AuthInterceptor(loginGateway)
    }

    @Provides
    @AppScope
    fun provideModifiedInterceptor(): ModifiedInterceptor {
        return ModifiedInterceptor()
    }

}