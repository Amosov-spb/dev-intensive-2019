package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Int) =
         when (this) {
            SECOND -> "$value ${formName(value, "секунда", "секунды", "секунд")}"
            else -> "Тип не определен"
        }

    private fun formName(value: Int, form1: String, form2_4: String, formOther: String): String {
        val lastDigit = getLastDigit(value)

        return when {
            value in 11..19 -> formOther
            lastDigit == 1 -> form1
            lastDigit in 2..4 -> form2_4
            else -> formOther
        }
    }

    private fun getLastDigit(value: Int): Int {
        val valueString = value.toString();

        return valueString.substring(valueString.length - 1).toInt()
    }


}

// Функция расширения - статическая функция, которую можно применить к экземпляру класса
fun Date.format(pattern: String = "HH:mm:ss dd.MM.yyyy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))

    return dateFormat.format(this)
}

// Прибавляем к дате заданное количество времени
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

fun Date.humanizeDiff(date: Date = Date()): String {
    return when (val diff = (date.time - this.time)) {
        in 0 * SECOND..1 * SECOND -> "только что"
        in 1 * SECOND..45 * SECOND -> "несколько секунд назад"
        in 45 * SECOND..75 * SECOND -> "минуту назад"
        in 75 * SECOND..45 * MINUTE -> "${(diff / MINUTE).toInt()} минут назад"
        in 45 * MINUTE..75 * MINUTE -> "час назад"
        in 75 * MINUTE..22 * HOUR -> "N часов назад"
        in 22 * HOUR..26 * HOUR -> "день назад"
        in 26 * HOUR..360 * DAY -> "${(diff / DAY).toInt()} дней назад"
        else -> "более года назад"
    }
}


