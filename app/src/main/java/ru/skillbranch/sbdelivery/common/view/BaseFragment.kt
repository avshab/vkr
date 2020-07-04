package ru.skillbranch.sbdelivery.common.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.navigation.BackAndHomeButtonsHandler

/**
 * Created by Anna Shabaeva on 07.06.2020
 */
abstract class BaseFragment : Fragment(), BackAndHomeButtonsHandler {

    interface ToolbarHandler {
        fun setVisibility(isVisibly: Boolean)
    }

    @get:LayoutRes protected abstract val layoutResId: Int

    @get:MenuRes protected open val menuResId: Int? = null

    protected open val hasComponent: Boolean = true

    protected val navController: NavController
        get() = findNavController()

    private val onStopDisposable = CompositeDisposable()
    private val onDestroyViewDisposable = CompositeDisposable()

    private var callback: ToolbarHandler? = null

    open val toolbarVisibility = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (menuResId != null) setHasOptionsMenu(true)
        callback = activity as? ToolbarHandler
    }

    override fun onResume() {
        callback?.setVisibility(toolbarVisibility)
        super.onResume()
    }

    @CallSuper
    override fun onAttach(context: Context) {
        if (hasComponent) {
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    @CallSuper
    override fun onStop() {
        super.onStop()
        onStopDisposable.clear()
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        onDestroyViewDisposable.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menuResId?.let { inflater.inflate(it, menu) }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun handleBackButton(): Boolean {
        Log.i("--TAG", "setVisibility = true")
        callback?.setVisibility(true)
        return false
    }

    override fun handleUpButton(): Boolean  {
        Log.i("--TAG", "setVisibility = true")
        callback?.setVisibility(true)
        return false
    }

    protected inline fun <T> LiveData<T>.observe(crossinline observer: (T) -> Unit) {
        observe(viewLifecycleOwner, Observer { if (it != null) observer(it) })
    }

    protected fun Disposable.untilStop() = onStopDisposable.add(this)

    protected fun Disposable.untilDestroyView() = onDestroyViewDisposable.add(this)

}