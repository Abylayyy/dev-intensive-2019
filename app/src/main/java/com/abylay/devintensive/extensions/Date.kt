package com.abylay.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.minutes
import kotlin.time.seconds

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val format = SimpleDateFormat(pattern, Locale("ru"))
    return format.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(): String {
    val time = Date().time
    return when(time - this.time) {
        in 0 until 2 * SECOND -> "только что"
        in SECOND until 45 * SECOND -> "несколько секунд назад"
        in 45 * SECOND until 75 * SECOND -> "минуту назад"
        in 75 * SECOND until 45 * MINUTE -> "${(time - this.time) / MINUTE} минут назад"
        in 45 * MINUTE until 75 * MINUTE -> "час назад"
        in 75 * MINUTE until 22 * HOUR -> "${(time - this.time) / HOUR} часов назад"
        in 22 * HOUR until 26 * HOUR -> "день назад"
        in 26 * HOUR until 360 * DAY -> "${(time - this.time) / DAY} дней назад"
        else -> "более года назад"
    }
}

fun TimeUnits.plural(n: Int): String {
    if (n > 0) {
        return when {
            n <= 1 && this == TimeUnits.SECOND -> "$n секунду"
            n > 1 && this == TimeUnits.SECOND -> "$n секунды"
            n <= 1 && this == TimeUnits.MINUTE -> "$n минуту"
            n > 1 && this == TimeUnits.MINUTE -> "$n минуты"
            n <= 1 && this == TimeUnits.HOUR -> "$n часу"
            n > 1 && this == TimeUnits.HOUR -> "$n часов"
            n <= 1 && this == TimeUnits.DAY -> "$n день"
            else -> "$n дня"
        }
    }
    return "number should not have to be negative"
}

enum class TimeUnits { SECOND, MINUTE, HOUR, DAY }