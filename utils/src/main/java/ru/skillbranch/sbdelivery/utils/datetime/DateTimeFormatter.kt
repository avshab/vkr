package ru.skillbranch.sbdelivery.utils.datetime

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import ru.skillbranch.sbdelivery.utils.datetime.DateTimeFormatter.DateTimePattern.*

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

class DateTimeFormatter {

    private enum class DateTimePattern(val pattern: String) {
        MONTH_FULL("LLLL"),
        MONTH_FULL_YEAR("LLLL yyyy"),
        DAY_MONTH_YEAR("d.MM.yyyy"),
        DAY_MONTH_FULL_YEAR("d MMMM yyyy"),
        DAY_MONTH_FULL("d MMMM"),
        TIME_24_HOUR("HH:mm"),
        DATE_TIME("dd.MM.yyyy ${TIME_24_HOUR.pattern}"),
        DATE_TIME_WITH_DAY_OF_WEEK("d MMMM, EEE, HH:mm"),
        DATE_TIME_WITH_DAY_OF_WEEK_AND_YEAR("d MMMM yyyy, EEE, HH:mm"),
        DAY_OF_WEEK_FULL("EEEE"),
        DAY_OF_WEEK_SHORT("E"),
        YEAR_DAY_MONTH("yyyy-MM-dd")
    }

    private var localePatternFormats =
        Locale.getDefault() to EnumMap<DateTimePattern, DateFormat>(DateTimePattern::class.java)

    private val DateTimePattern.dateFormat: DateFormat
        get() {
            val defaultLocale = Locale.getDefault()
            val locale = localePatternFormats.first

            if (locale != defaultLocale) {
                localePatternFormats = defaultLocale to EnumMap(DateTimePattern::class.java)
            }

            return localePatternFormats.second.getOrPut(this) {
                SimpleDateFormat(pattern, defaultLocale)
            }
        }

    @Synchronized
    fun formatDateTime(dateModel: DateTimeModel): String {
        return if (dateModel.year == DateModel.today.year) {
            DATE_TIME_WITH_DAY_OF_WEEK.format(dateModel.date)
        } else {
            DATE_TIME_WITH_DAY_OF_WEEK_AND_YEAR.format(dateModel.date)
        }
    }

    @Synchronized
    fun formatDateStandard(dateModel: DateModel): String {
        return DAY_MONTH_YEAR.format(dateModel.date)
    }

    @Synchronized
    fun formatFullMonthYearStandard(dateModel: DateModel): String {
        return DAY_MONTH_FULL_YEAR.format(dateModel.date)
    }

    @Synchronized
    fun formatTime24Hour(dateTimeModel: DateTimeModel): String {
        return TIME_24_HOUR.format(dateTimeModel.date)
    }

    @Synchronized
    fun formatDayOfWeekFull(dateTimeModel: DateModel): String {
        return DAY_OF_WEEK_FULL.format(dateTimeModel.date)
    }

    @Synchronized
    fun formatDayOfWeekShort(dateTimeModel: DateModel): String {
        return DAY_OF_WEEK_SHORT.format(dateTimeModel.date)
    }

    @Synchronized
    fun formatMonthFull(dateTimeModel: DateModel): String {
        return MONTH_FULL.format(dateTimeModel.date)
    }

    @Synchronized
    fun formatMonthFullYear(dateTimeModel: DateModel): String {
        return MONTH_FULL_YEAR.format(dateTimeModel.date)
    }

    @Synchronized
    fun formatYearMonthFull(dateTimeModel: DateModel): String {
        return DateTimePattern.YEAR_DAY_MONTH.format(dateTimeModel.date)
    }


    private fun DateTimePattern.format(date: Date): String = this.dateFormat.format(date)
}


