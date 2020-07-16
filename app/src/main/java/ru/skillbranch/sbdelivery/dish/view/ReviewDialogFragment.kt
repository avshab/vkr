package ru.skillbranch.sbdelivery.dish.view

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.dialog_fragment_review.*
import kotlinx.android.synthetic.main.dialog_fragment_review.dismissButton
import kotlinx.android.synthetic.main.dialog_fragment_review.sendReviewButton
import kotlinx.android.synthetic.main.dialog_fragment_review.view.*
import ru.skillbranch.sbdelivery.common.view.dialogs.BaseDialogFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.utils.extensions.arguments
import ru.skillbranch.sbdelivery.utils.extensions.onClick

/**
 * Created by Anna Shabaeva on 16.07.2020
 */


open class ReviewDialogFragment : BaseDialogFragment() {

    interface Callback {

        fun onDismiss(requestCode: Int) = Unit

        fun onSendButtonClick(requestCode: Int, text: String, rating: Int) = Unit

        fun onDismissButtonClick(requestCode: Int) = Unit

    }

    override val dialogLayoutResId: Int = R.layout.dialog_fragment_review

    private val dialogArgs by arguments<ReviewDialogArguments> { arguments }

    override val isCanceledOnBackPress: Boolean
        get() = dialogArgs.isCanceledOnBackPress

    override val isCanceledOnTouchOutside: Boolean
        get() = dialogArgs.isCanceledOnTouchOutside

    private var callback: Callback? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = parentFragment as? Callback
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dialogView.dismissButton.apply {
                onClick {
                    callback?.onDismissButtonClick(dialogArgs.callbackRequestCode)
                    dismiss()
                }
            }

        dialogView.sendReviewButton.apply {
                onClick {
                    callback?.onSendButtonClick(
                        requestCode = dialogArgs.callbackRequestCode,
                        text = dialogView.messageEditText.text.toString(),
                        rating = dialogView.ratingBar.rating.toInt()
                    )
                    dismiss()
                }
            }

    }

    override fun onDismiss(dialog: DialogInterface) {
        callback?.onDismiss(dialogArgs.callbackRequestCode)
        super.onDismiss(dialog)
    }
}

@Parcelize
class ReviewDialogArguments(
    val callbackRequestCode: Int,
    val isCanceledOnTouchOutside: Boolean = true,
    val isCanceledOnBackPress: Boolean = true
) : Parcelable