package ru.skillbranch.sbdelivery.utils.datetime

import android.text.format.DateUtils
import java.util.*

/**
 * Created by Anna Shabaeva on 16.07.2020
 */


fun createCalendarFromMillis(timeInMillis: Long): Calendar {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = timeInMillis
    return calendar
}

fun createCalendarFromSeconds(timeInSeconds: Long): Calendar {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = secondsToMillis(timeInSeconds)
    return calendar
}

val todaysMidnightCalendar: Calendar
    get() {
        return Calendar
            .getInstance()
            .setHours(0).setMinutes(0).setSeconds(0).setMilliseconds(0)
    }

val tomorrowsMidnightCalendar: Calendar
    get() = todaysMidnightCalendar.addDays(1)

val lastDayOfCurrentMonthCalendar: Calendar
    get() {
        return todaysMidnightCalendar.apply {
            val lastDayOfMonth = getActualMaximum(Calendar.DAY_OF_MONTH)
            setDayOfMonth(lastDayOfMonth)
        }
    }

val firstDayOfCurrentMonthCalendar: Calendar
    get() {
        return todaysMidnightCalendar.apply {
            val firstDayOfMonth = getActualMinimum(Calendar.DAY_OF_MONTH)
            setDayOfMonth(firstDayOfMonth)
        }
    }

val yesterdayCalendar: Calendar
    get() = todaysMidnightCalendar.addDays(-1)

fun createCalendarWith(year: Int, month: Int, day: Int): Calendar =
    Calendar.getInstance().setYear(year).setMonth(month).setDay(day)

fun createCalendarWith(month: Int, day: Int): Calendar =
    Calendar.getInstance().setMonth(month).setDay(day)

fun createCalendarWith(day: Int): Calendar =
    Calendar.getInstance().setDay(day)

fun Calendar.getInstance(timeMillis: Long): Calendar {
    val calendar = Calendar.getInstance()
    if (timeMillis != 0L) {
        calendar.timeInMillis = timeInMillis
    }
    return calendar
}

// -------------- Calendar chained setters -------------- //

fun Calendar.setDay(day: Int): Calendar {
    set(Calendar.DATE, day)
    return this
}

fun Calendar.setDayOfMonth(dayOfMonth: Int): Calendar {
    set(Calendar.DAY_OF_MONTH, dayOfMonth)
    return this
}

fun Calendar.setMonth(month: Int): Calendar {
    set(Calendar.MONTH, month)
    return this
}

fun Calendar.setWeekOfMonth(week: Int): Calendar {
    set(Calendar.WEEK_OF_MONTH, week)
    return this
}

fun Calendar.setYear(year: Int): Calendar {
    set(Calendar.YEAR, year)
    return this
}

fun Calendar.setHours(hours: Int): Calendar {
    set(Calendar.HOUR_OF_DAY, hours)
    return this
}

fun Calendar.setMinutes(minutes: Int): Calendar {
    set(Calendar.MINUTE, minutes)
    return this
}

fun Calendar.setSeconds(seconds: Int): Calendar {
    set(Calendar.SECOND, seconds)
    return this
}

fun Calendar.setMilliseconds(millis: Int): Calendar {
    set(Calendar.MILLISECOND, millis)
    return this
}

fun Calendar.addDays(days: Int): Calendar {
    add(Calendar.DATE, days)
    return this
}

fun Calendar.addMinutes(minutes: Int): Calendar {
    add(Calendar.MINUTE, minutes)
    return this
}

fun Calendar.addMonths(months: Int): Calendar {
    add(Calendar.MONTH, months)
    return this
}

fun Calendar.addYears(years: Int): Calendar {
    add(Calendar.YEAR, years)
    return this
}

fun Calendar.subtractMonths(moths: Int): Calendar {
    add(Calendar.MONTH, -moths)
    return this
}

fun Calendar.subtractDays(days: Int): Calendar {
    add(Calendar.DATE, -days)
    return this
}

fun Calendar.addMonth(): Calendar = addMonths(1)


// ------------- Calendar cloning with set -------------- //

fun Calendar.cloneCalendar(): Calendar {
    return (clone() as Calendar)
}

fun Calendar.cloneAndSetDay(day: Int): Calendar {
    return cloneCalendar().setDay(day)
}

fun Calendar.cloneAndAddMinutes(minutes: Int): Calendar {
    return cloneCalendar().addMinutes(minutes)
}

fun Calendar.cloneAndAddDay(day: Int): Calendar {
    return cloneCalendar().addDays(day)
}

fun Calendar.cloneAndAddMonths(months: Int): Calendar {
    return cloneCalendar().addMonths(months)
}

fun Calendar.cloneAndSetWeekOfMonth(week: Int): Calendar {
    return cloneCalendar().setWeekOfMonth(week)
}

fun Calendar.cloneAndSubtractMonths(months: Int): Calendar {
    return cloneCalendar().addMonths(-months)
}

fun Calendar.cloneAndSubtractYears(years: Int): Calendar {
    return cloneCalendar().addYears(-years)
}

// ------------ Calendar convenient methods ------------- //

fun Calendar.isTheSameDay(anotherCalendar: Calendar): Boolean =
    this[Calendar.DATE] == anotherCalendar[Calendar.DATE]
            && this[Calendar.MONTH] == anotherCalendar[Calendar.MONTH]
            && this[Calendar.YEAR] == anotherCalendar[Calendar.YEAR]

fun Calendar.isTheSameWeek(anotherCalendar: Calendar): Boolean =
    this[Calendar.WEEK_OF_MONTH] == anotherCalendar[Calendar.WEEK_OF_MONTH]
            && this[Calendar.MONTH] == anotherCalendar[Calendar.MONTH]
            && this[Calendar.YEAR] == anotherCalendar[Calendar.YEAR]

fun Calendar.isToday(): Boolean {
    val todayCalendar = todaysMidnightCalendar
    return this[Calendar.DATE] == todayCalendar[Calendar.DATE]
            && this[Calendar.MONTH] == todayCalendar[Calendar.MONTH]
            && this[Calendar.YEAR] == todayCalendar[Calendar.YEAR]
}

fun Calendar.isTomorrow(): Boolean {
    val tomorrowCalendar = todaysMidnightCalendar.addDays(1)
    return this[Calendar.DATE] == tomorrowCalendar[Calendar.DATE]
            && this[Calendar.MONTH] == tomorrowCalendar[Calendar.MONTH]
            && this[Calendar.YEAR] == tomorrowCalendar[Calendar.YEAR]
}

fun Calendar.isYesterday(): Boolean {
    val yesterdayCalendar = todaysMidnightCalendar.addDays(-1)
    return this[Calendar.DATE] == yesterdayCalendar[Calendar.DATE]
            && this[Calendar.MONTH] == yesterdayCalendar[Calendar.MONTH]
            && this[Calendar.YEAR] == yesterdayCalendar[Calendar.YEAR]
}

fun Calendar.isTheActualMonth(): Boolean {
    val todayCalendar = todaysMidnightCalendar
    return this[Calendar.MONTH] == todayCalendar[Calendar.MONTH]
            && this[Calendar.YEAR] == todayCalendar[Calendar.YEAR]
}

fun Calendar.isGreater(anotherCalendar: Calendar): Boolean {
    return this.timeInMillis > anotherCalendar.timeInMillis
}

val Calendar.isGreaterThanToday: Boolean
    get() = this.timeInMillis > tomorrowsMidnightCalendar.timeInMillis

fun Calendar.isLess(anotherCalendar: Calendar): Boolean {
    return this.timeInMillis < anotherCalendar.timeInMillis
}

val Calendar.isLessThanToday: Boolean
    get() = this.timeInMillis < todaysMidnightCalendar.timeInMillis

fun Calendar.isGreaterOrEqual(anotherCalendar: Calendar): Boolean {
    return this.timeInMillis >= anotherCalendar.timeInMillis
}

fun Calendar.isLessOrEqual(anotherCalendar: Calendar): Boolean {
    return this.timeInMillis <= anotherCalendar.timeInMillis
}

fun Calendar.localizeFirstDayOfWeekInMonth(firstDayOfWeekInLocale: Int): Int {
    val originalFirstDayOfWeek = cloneAndSetDay(1).get(Calendar.DAY_OF_WEEK)
    val isSunday = originalFirstDayOfWeek == Calendar.SUNDAY
    return originalFirstDayOfWeek + when (firstDayOfWeekInLocale) {
        Calendar.MONDAY -> if (isSunday) 6 else -1
        Calendar.TUESDAY -> if (isSunday) 5 else -2
        Calendar.WEDNESDAY -> if (isSunday) 4 else -3
        Calendar.THURSDAY -> if (isSunday) 3 else -4
        Calendar.FRIDAY -> if (isSunday) 2 else -5
        Calendar.SATURDAY -> if (isSunday) 1 else -6
        else -> originalFirstDayOfWeek
    }
}

// --------------------- System time -------------------- //

val currentTimeSeconds: Long
    get() = secondsToMillis(System.currentTimeMillis())

fun isTimePassed(timeInMillis: Long): Boolean = System.currentTimeMillis() > timeInMillis

fun secondsToMillis(timeInSeconds: Long): Long = timeInSeconds * DateUtils.SECOND_IN_MILLIS

fun millisToSeconds(timeInMillis: Long): Long = timeInMillis / DateUtils.SECOND_IN_MILLIS

