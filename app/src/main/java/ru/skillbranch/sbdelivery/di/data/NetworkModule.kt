package ru.skillbranch.sbdelivery.di.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.skillbranch.sbdelivery.data.BuildConfig
import ru.skillbranch.sbdelivery.data.api.interceptors.ErrorInterceptor
import ru.skillbranch.sbdelivery.data.auth.util.AuthInterceptor
import ru.skillbranch.sbdelivery.data.auth.util.AuthenticatorImpl
import ru.skillbranch.sbdelivery.data.auth.util.ModifiedInterceptor
import ru.skillbranch.sbdelivery.data.common.api.ResponseErrorBodyConverter
import ru.skillbranch.sbdelivery.di.app.AppScope
import ru.skillbranch.sbdelivery.di.data.qualifiers.AuthenticationApi
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway
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
        authenticator: Authenticator,
        authInterceptor: AuthInterceptor,
        okHttpBuilder: OkHttpClient.Builder
    ): OkHttpClient {
        return okHttpBuilder
            .authenticator(authenticator)
            .addInterceptor(authInterceptor)
            .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @AuthenticationApi
    fun provideAuthenticatorOkHttpClient(
        okHttpBuilder: OkHttpClient.Builder
    ): OkHttpClient {
        return okHttpBuilder.build()
    }


    @Provides
    fun provideOkHttpClientBuilder(
        errorInterceptor: ErrorInterceptor,
        loggingInterceptor: LoggingInterceptor,
        modifiedInterceptor: ModifiedInterceptor
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .callTimeout(10L, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(modifiedInterceptor)
            .addInterceptor(errorInterceptor)
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
    @AuthenticationApi
    fun provideAuthenticatorRetrofit(
        retrofitBuilder: Retrofit.Builder,
        @AuthenticationApi okHttpClient: OkHttpClient
    ): Retrofit {
        return retrofitBuilder
            .client(okHttpClient)
            .build()
    }

    @Provides
    @AppScope
    fun provideAuthenticator(
        @AuthenticationApi loginGateway: LoginGateway
    ): Authenticator {
        return AuthenticatorImpl(loginGateway) {
            //TODO
        }
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
    fun provideLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
            .loggable(true)
            .setLevel(Level.BODY)
            .setLevel(Level.HEADERS)
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
    @AppScope
    fun provideGson(): Gson {
        return GsonBuilder().setDateFormat(DATE_FORMAT).create()
    }

    @Provides
    @AppScope
    fun provideAuthInterceptor(@AuthenticationApi loginGateway: LoginGateway): AuthInterceptor {
        return AuthInterceptor(loginGateway)
    }

    @Provides
    @AppScope
    fun provideModifiedInterceptor(): ModifiedInterceptor {
        return ModifiedInterceptor()
    }

}