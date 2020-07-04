package ru.skillbranch.sbdelivery.data.profile.api

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Anna Shabaeva on 03.07.2020
 */
interface ProfileApiService {

    @GET("profile")
    fun profile(): Single<ProfileResponseBody>

}


