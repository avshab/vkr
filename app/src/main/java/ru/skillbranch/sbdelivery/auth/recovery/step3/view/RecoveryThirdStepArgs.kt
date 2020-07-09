package ru.skillbranch.sbdelivery.auth.recovery.step3.view

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Anna Shabaeva on 09.07.2020
 */

@Parcelize
class RecoveryThirdStepArgs (
    val email: String,
    val code: String
) : Parcelable