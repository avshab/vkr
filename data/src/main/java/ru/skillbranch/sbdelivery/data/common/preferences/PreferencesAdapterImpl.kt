package ru.skillbranch.sbdelivery.data.common.preferences

import android.content.SharedPreferences
import com.f2prateek.rx.preferences2.RxSharedPreferences

class PreferencesAdapterImpl(
    sharedPreferences: SharedPreferences
) : PreferencesAdapter {

    private val rxkPrefs =
        RxSharedPreferences.create(
            sharedPreferences
        )

    override fun getBoolean(key: String, defaultValue: Boolean): Preference<Boolean> {
        return PreferenceImpl(
            rxkPrefs.getBoolean(key, defaultValue)
        )
    }

    override fun getFloat(key: String, defaultValue: Float): Preference<Float> {
        return PreferenceImpl(
            rxkPrefs.getFloat(key, defaultValue)
        )
    }

    override fun getInt(key: String, defaultValue: Int): Preference<Int> {
        return PreferenceImpl(
            rxkPrefs.getInteger(key, defaultValue)
        )
    }

    override fun getLong(key: String, defaultValue: Long): Preference<Long> {
        return PreferenceImpl(
            rxkPrefs.getLong(key, defaultValue)
        )
    }

    override fun getString(key: String, defaultValue: String): Preference<String> {
        return PreferenceImpl(
            rxkPrefs.getString(key, defaultValue)
        )
    }

    override fun getStringSet(key: String, defaultValue: Set<String>): Preference<Set<String>> {
        return PreferenceImpl(
            rxkPrefs.getStringSet(key, defaultValue)
        )
    }

    override fun clear() = rxkPrefs.clear()

}