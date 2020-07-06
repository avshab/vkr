package ru.skillbranch.sbdelivery.utils.extensions

import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.core.view.postDelayed
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

/**
 * Created by Anna Shabaeva on 25.06.2020
 */

const val FRAGMENT_TAG = "TAG"
const val FRAGMENT_ARG_KEY = "ARG_KEY"

inline fun Fragment.postDelayed(timeInMillis: Long, crossinline action: () -> Unit) {
    requireView().postDelayed(timeInMillis, action)
}


inline fun <reified ARG : Parcelable> Fragment.arguments(
    crossinline bundleProvider: () -> Bundle?
): Lazy<ARG> {
    return getArgs(bundleProvider)
}

inline fun <reified ARG : Parcelable> Fragment.arguments(): Lazy<ARG> {
    return getArgs { arguments }
}

inline fun <reified ARG : Parcelable> Fragment.nullableArguments(): Lazy<ARG?> {
    return getNullableArgs { arguments }
}

inline fun <reified ARG : Parcelable> Fragment.getNullableArgs(
    crossinline bundleProvider: () -> Bundle?
): Lazy<ARG?> {
    return lazy(LazyThreadSafetyMode.NONE) {
        bundleProvider()?.getParcelable<ARG>(getArgKey())
    }
}

inline fun <reified ARG : Parcelable> Fragment.getArgs(
    crossinline bundleProvider: () -> Bundle?
): Lazy<ARG> {
    return lazy(LazyThreadSafetyMode.NONE) {
        requireNotNull(bundleProvider()?.getParcelable<ARG>(getArgKey())) {
            "${ARG::class.java.name} not found in bundle"
        }
    }
}

inline fun <reified T : Fragment> Parcelable.toBundle(): Bundle {
    return bundleOf(T::class.getArgKey() to this)
}

inline fun <reified T : KClass<out Fragment>> T.getArgKey(): String {
    return "${java.simpleName}_$FRAGMENT_ARG_KEY"
}

inline fun <reified T : Fragment> T.getArgKey(): String = this::class.getArgKey()

fun AppCompatActivity.setupToolbar(toolbarView: Toolbar, initializer: (ActionBar.() -> Unit)? = null) {
    run {
        setSupportActionBar(toolbarView)
        supportActionBar?.let { initializer?.invoke(it) }
    }
}