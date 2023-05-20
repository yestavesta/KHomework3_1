fun main() {
    println(agoText(86399))
}

fun isJustNow(seconds: Int): Boolean {
    return (seconds in 0..59)
}

fun isMinutesAgo(seconds: Int): Boolean {
    return (seconds >= 60 && seconds < 60 * 60)
}

fun isHoursAgo(seconds: Int): Boolean {
    return (seconds >= (60 * 60) && seconds < (24 * 60 * 60))
}

fun isOneDayAgo(seconds: Int): Boolean {
    return (seconds >= (24 * 60 * 60) && seconds < (24 * 60 * 60 * 2))
}

fun isTwoDaysAgo(seconds: Int): Boolean {
    return (seconds >= (24 * 60 * 60 * 2) && seconds < (24 * 60 * 60 * 3))
}

fun textMinutes(seconds: Int): String {
    val minutes = (seconds / 60).toInt()
    return when {
        (minutes % 10 == 1) && (minutes != 11) -> "Был(а) $minutes минуту назад"
        ((minutes % 10 == 2) || (minutes % 10 == 3) || (minutes % 10 == 4)) && (minutes < 10 || minutes > 20) -> "Был(а) $minutes минуты назад"
        else -> "Был(а) $minutes минут назад"
    }
}

fun textHours(seconds: Int): String {
    val hours = (seconds / 60 / 60).toInt()
    return when {
        (hours % 10 == 1) && (hours != 11) -> "Был(а) $hours час назад"
        ((hours % 10 == 2) || (hours % 10 == 3) || (hours % 10 == 4)) && (hours < 10 || hours > 20) -> "Был(а) $hours часа назад"
        else -> "Был(а) $hours часов назад"
    }
}

fun agoText(seconds: Int): String {
    return when {
        isJustNow(seconds) -> "Был(а) только что"
        isMinutesAgo(seconds) -> textMinutes(seconds)
        isHoursAgo(seconds) -> textHours(seconds)
        isOneDayAgo(seconds) -> "Был(а) вчера"
        isTwoDaysAgo(seconds) -> "Был(а) позавчера"
        else -> "Был(а) давно"
    }
}




