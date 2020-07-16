package ru.skillbranch.sbdelivery.common.view.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.lifecycle.LiveData
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import androidx.lifecycle.Observer
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.utils.extensions.inflateCustomView

/**
 * Created by Anna Shabaeva on 16.07.2020
 */


abstract class BaseDialogFragment : AppCompatDialogFragment() {

    protected open val hasComponent: Boolean = false

    @get:LayoutRes
    protected abstract val dialogLayoutResId: Int

    protected abstract val isCanceledOnBackPress: Boolean

    protected abstract val isCanceledOnTouchOutside: Boolean

    protected val dialogView: View by lazy {
        inflateCustomView(dialogLayoutResId)
    }

    private val onDestroyDisposable = CompositeDisposable()

    @CallSuper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (hasComponent) {
            AndroidSupportInjection.inject(this)
        }
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        onDestroyDisposable.clear()
    }

    final override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog
            .Builder(requireContext())
            .apply {
                setView(dialogView)
                setCancelable(isCanceledOnBackPress)
                onDialogBuilderInitialized(this)
            }
            .create()
            .apply {
                applyDialogWindowBackground()
                setCanceledOnTouchOutside(isCanceledOnTouchOutside)
            }
    }

    protected open fun onDialogBuilderInitialized(builder: AlertDialog.Builder) = Unit

    private fun Dialog.applyDialogWindowBackground() {
        window?.setBackgroundDrawableResource(R.drawable.bg_dialog_with_insets)
    }

    protected inline fun <T> LiveData<T>.observe(crossinline observer: (T) -> Unit) {
        observe(requireActivity(), Observer { if (it != null) observer(it) })
    }

    protected fun Disposable.untilDestroy() = onDestroyDisposable.add(this)

}