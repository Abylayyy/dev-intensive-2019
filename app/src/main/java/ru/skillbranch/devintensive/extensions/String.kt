package ru.skillbranch.devintensive.extensions

fun String.truncate(n: Int = 16) = if (n <= length) substring(0, n) + "..." else "index out of range"

fun String.stripHtml() : String {
    var s = replace("\\s+".toRegex(), " ")
    s = s.replace("<[^>]*>".toRegex(),"")
    return s
}

