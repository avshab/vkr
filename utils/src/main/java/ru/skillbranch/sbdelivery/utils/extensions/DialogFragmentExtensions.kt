package ru.skillbranch.sbdelivery.utils.extensions

import android.os.Parcelable
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

fun DialogFragment.inflateCustomView(@LayoutRes layoutRes: Int): View {
    return requireActivity().layoutInflater.inflate(layoutRes, null)
}

inline fun <reified D : DialogFragment> dismissDialog(fragmentManager: FragmentManager) {
    val tag = "${D::class.java.simpleName}_$FRAGMENT_TAG"
    (fragmentManager.findFragmentByTag(tag) as? DialogFragment)?.dismiss()
}

inline fun <reified D : DialogFragment> showDialog(
    fragmentManager: FragmentManager,
    arguments: Parcelable? = null
) {
    val clazz = D::class.java
    val className = clazz.simpleName

    val tag = "${className}_$FRAGMENT_TAG"

    val fragment = fragmentManager.findFragmentByTag(tag) ?: clazz.newInstance()
    if (fragment is DialogFragment && !fragment.isAdded) {
        if (arguments != null) {
            fragment.arguments = arguments.toBundle<D>()
        }
        fragmentManager
            .beginTransaction()
            .add(fragment, tag)
            .commitAllowingStateLoss()
    }
}

val DialogFragment.notImplementedDialogCallbackException: IllegalStateException
    get() = IllegalStateException(
        "Parent fragment does not implement interface of ${this.javaClass}"
    )