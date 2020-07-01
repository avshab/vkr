package ru.skillbranch.sbdelivery.data.common.preferences

import io.reactivex.Observable

class PreferenceImpl<T>(
    private val pref: com.f2prateek.rx.preferences2.Preference<T>
) : Preference<T> {

    override var value: T
        get() = pref.get()
        set(value) = pref.set(value)

    override val key: String
        get() = pref.key()

    override val defaultValue: T
        get() = pref.defaultValue()

    override val observable: Observable<T>
        get() = pref.asObservable()

    override fun isSet() = pref.isSet

    override fun delete() = pref.delete()

}