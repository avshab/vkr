package ru.skillbranch.sbdelivery.utils.datetime

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class DateModel(
    val dateInMillis: Long
) : Comparable<DateModel>,
    Parcelable {

    constructor(date: Date) : this(date.time)

    constructor(calendar: Calendar) : this(calendar.timeInMillis)

    constructor(day: Int, month: Int, year: Int) : this(
        Calendar.getInstance()
            .setYear(year)
            .setMonth(month)
            .setDay(day)
            .timeInMillis
    )

    companion object {
        val today: DateModel
            get() = DateModel(System.currentTimeMillis())
    }

    @IgnoredOnParcel
    private val calendar = newCalendarInstance

    val newCalendarInstance: Calendar
        get() = buildCalendar()

    val isValid: Boolean
        get() = dateInMillis != -1L && dateInMillis != 0L

    val year: Int
        get() = calendar.get(Calendar.YEAR)

    val month: Int
        get() = calendar.get(Calendar.MONTH)

    val dayOfMonth: Int
        get() = calendar.get(Calendar.DAY_OF_MONTH)

    val dayOfYear: Int
        get() = calendar.get(Calendar.DAY_OF_YEAR)

    val weekOfMonth: Int
        get() = calendar.get(Calendar.WEEK_OF_MONTH)

    val weekOfYear: Int
        get() = calendar.get(Calendar.WEEK_OF_YEAR)


    val yesterday: DateModel
        get() {
            val tmpCalendar = Calendar.getInstance().apply {
                time = calendar.time
                add(Calendar.DAY_OF_MONTH, -1)
            }
            return DateModel(tmpCalendar.time)
        }

    val tomorrow: DateModel
        get() {
            val tmpCalendar = Calendar.getInstance().apply {
                time = calendar.time
                add(Calendar.DAY_OF_MONTH, 1)
            }
            return DateModel(tmpCalendar.time)
        }


    val date: Date
        get() = Date(dateInMillis)

    private fun buildCalendar(): Calendar {
        return Calendar.getInstance().apply {
            timeInMillis = dateInMillis
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
    }

    override fun compareTo(other: DateModel): Int {
        var result = year - other.year
        if (result == 0) {
            result = month - other.month
            if (result == 0) {
                result = dayOfMonth - other.dayOfMonth
            }
        }
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is DateModel) {
            return false
        }
        return year == other.year && month == other.month && dayOfMonth == other.dayOfMonth
    }

    override fun hashCode(): Int {
        var result = year
        result = 31 * result + month
        result = 31 * result + dayOfMonth
        return result
    }

    override fun toString(): String {
        return "$dayOfMonth/${month.inc()}/$year"
    }

}