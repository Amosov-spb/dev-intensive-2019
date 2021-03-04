package ru.skillbranch.devintensive.extensions

fun String.truncate(countSymbol: Int = 16): String {
    val strEnd = "..."
    val formatStr = this.trimEnd()

    val l = formatStr.length
    return if (l <= countSymbol)
        formatStr
    else
        formatStr.substring(0, countSymbol) + strEnd
}

fun String.stripHtml() : String {
    return this.replace(Regex("<[^<]*>"), "").replace(Regex("\\s+"), " ")
}
