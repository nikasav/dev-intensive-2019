package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND    = 1000L
const val MINUTE    = 60 * SECOND
const val HOUR      = 60 * MINUTE
const val DAY       = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yyyy") : String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time

    time +=when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}
    fun Date.humanizeDiff(date: Date = Date()): String {
        if (date == null)
            return "только что"

        var delta = (Date().time - this.time)/1000
        if (delta > 0){
            if (delta in (0..1))
                return "только что"
            if (delta in (1..45))
                return "несколько секунд назад"
            if (delta in (45..75))
                return "минуту назад"
            if (delta in (75..4 * 60))
                return "${delta / 60} минуты назад"
            if (delta in (4 * 60..45 * 60))
                return "${delta / 60} минут назад"

            if (delta in (45 * 60..75 * 60))
                return "час назад"
            if (delta in (75 * 60..4 * 3600))
                return "${delta / 3600} часа назад"
            if (delta in (4 * 3600..22 * 3600))
                return "${delta / 3600} часов назад"

            if (delta in (22 * 3600..26 * 3600))
                return "день назад"
            if (delta in (26 * 3600..2 * 24 * 3600))
                return "${delta / (3600 * 24)} дня назад"
            if (delta in (4 * 24 * 3600..360 * 24 * 3600))
                return "${delta / (3600 * 24)} дней назад"
            return "более года назад"
        }else{
            delta = kotlin.math.abs(delta)
            if (delta in (0..1))
                return "только что"
            if (delta in (1..45))
                return "через несколько секунд"
            if (delta in (45..75))
                return "через минуту"
            if (delta in (75..4 * 60))
                return "через ${delta / 60} минуты"
            if (delta in (4 * 60..45 * 60))
                return "через ${delta / 60} минут"

            if (delta in (45 * 60..75 * 60))
                return "через час"
            if (delta in (75 * 60..4 * 3600))
                return "через ${delta / 3600} часа"
            if (delta in (4 * 3600..22 * 3600))
                return "через ${delta / 3600} часов"

            if (delta in (22 * 3600..26 * 3600))
                return "через день"
            if (delta in (26 * 3600..2 * 24 * 3600))
                return "через ${delta / (3600 * 24)} дня"
            if (delta in (4 * 24 * 3600..360 * 24 * 3600))
                return "через ${delta / (3600 * 24)} дней"
            return "более чем через год"
        }
    }

    enum class TimeUnits{
        SECOND,
        MINUTE,
        HOUR,
        DAY
    }
