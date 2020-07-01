package ru.skillbranch.sbdelivery.data.auth.api.util

/**
 * Created by Anna Shabaeva on 01.07.2020
 */

const val AUTH_TYPE = "Bearer"

const val SKIP_AUTH_TYPE = "Skip-Auth"

const val AUTH_HEADER_NAME = "Authorization"

const val SKIP_AUTH_HEADER = "Authorization: $SKIP_AUTH_TYPE"

const val MODIFIED_SINCE = "If-Modified-Since"

fun buildAuthHeaderValue(accessToken: String): String {
    return "$AUTH_TYPE $accessToken"
}