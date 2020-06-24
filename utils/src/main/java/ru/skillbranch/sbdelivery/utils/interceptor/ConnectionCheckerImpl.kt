package ru.skillbranch.sbdelivery.utils.interceptor

import android.content.Context
import ru.skillbranch.sbdelivery.utils.exceptions.isConnected

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

class ConnectionCheckerImpl(
    private val context: Context
) : ConnectionChecker {

    override fun isConnected(): Boolean {
        return context.isConnected()
    }
}