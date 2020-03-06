package com.abylay.devintensive.utils

import android.icu.text.Transliterator
import java.util.*

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        var firstname = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (firstname?.trimIndent().isNullOrEmpty()) {
            firstname = null
        }
        if (lastName?.trimIndent().isNullOrEmpty()) {
            lastName = null
        }
        return firstname to lastName
    }

    fun transliteration(payLoad: String, divider: String = " "): String {
        return "$payLoad$divider"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val first = firstName?.trimIndent().isNullOrEmpty()
        val last = lastName?.trimIndent().isNullOrEmpty()
        return when {
            first && last -> null
            !first && last -> "${firstName!![0].toUpperCase()}"
            first && !last -> "${lastName!![0].toUpperCase()}"
            else -> "${firstName!![0].toUpperCase()}${lastName!![0].toUpperCase()}"
        }
    }

    val map: Map<String, String>? = mapOf (
        "а" to "a", "б" to "b", "в" to "v",
        "г" to "g", "д" to "d", "е" to "e",
        "ё" to "e", "ж" to "zh", "з" to "z",
        "и" to "i", "й" to "i", "к" to "k",
        "л" to "l", "м" to "m", "н" to "n",
        "о" to "o", "п" to "p", "р" to "r",
        "с" to "s", "т" to "t", "у" to "u",
        "ф" to "f", "х" to "h", "ц" to "c",
        "ч" to "ch", "ш" to "sh", "щ" to "sh'",
        "ъ" to "", "ы" to "i", "ь" to "",
        "э" to "e", "ю" to "yu", "я" to "ya"
    )
}