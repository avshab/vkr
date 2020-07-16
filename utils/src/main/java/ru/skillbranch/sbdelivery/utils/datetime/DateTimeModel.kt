package ru.skillbranch.sbdelivery.utils.datetime

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class DateTimeModel(
    val dateTimeInMillis: Long
) : Comparable<DateTimeModel>,
    Parcelable {

    constructor(date: Date) : this(date.time)

    constructor(calendar: Calendar) : this(calendar.timeInMillis)

    companion object {
        val today: DateTimeModel
            get() = DateTimeModel(System.currentTimeMillis())

    }

    val isValid: Boolean
        get() = dateTimeInMillis != -1L && dateTimeInMillis != 0L

    @IgnoredOnParcel
    val dateModel =
        DateModel(dateTimeInMillis)

    val date: Date
        get() = Date(dateTimeInMillis)

    val year: Int
        get() = calendar.get(Calendar.YEAR)

    @IgnoredOnParcel
    private val calendar = Calendar.getInstance()
        .apply { timeInMillis = dateTimeInMillis }

    override fun compareTo(other: DateTimeModel): Int {
        return when {
            this.dateTimeInMillis < other.dateTimeInMillis -> -1
            this.dateTimeInMillis == other.dateTimeInMillis -> 0
            else -> 1
        }
    }
}