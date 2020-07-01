package ru.skillbranch.sbdelivery.data.common.preferences

import androidx.annotation.CheckResult

interface PreferencesAdapter {

    @CheckResult
    fun getBoolean(key: String, defaultValue: Boolean): Preference<Boolean>

    @CheckResult
    fun getFloat(key: String, defaultValue: Float): Preference<Float>

    @CheckResult
    fun getInt(key: String, defaultValue: Int): Preference<Int>

    @CheckResult
    fun getLong(key: String, defaultValue: Long): Preference<Long>

    @CheckResult
    fun getString(key: String, defaultValue: String): Preference<String>

    @CheckResult
    fun getStringSet(key: String, defaultValue: Set<String>): Preference<Set<String>>

    fun clear()

}