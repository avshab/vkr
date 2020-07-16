package ru.skillbranch.sbdelivery.dish.view

import androidx.fragment.app.Fragment
import ru.skillbranch.sbdelivery.utils.extensions.showDialog

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

fun Fragment.showReviewDialog(
    requestCode: Int
) {
    showDialog<ReviewDialogFragment>(
        childFragmentManager,
        ReviewDialogArguments(
            isCanceledOnBackPress = true,
            isCanceledOnTouchOutside = true,
            callbackRequestCode = requestCode
        )
    )
}
