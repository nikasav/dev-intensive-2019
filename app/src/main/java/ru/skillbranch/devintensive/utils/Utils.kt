package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?):Pair<String?, String?> {
        val parts:List<String>? = fullName?.split(" ")
        var firstName   = parts?.getOrNull(0)
        var lastName    = parts?.getOrNull(1)

        if (parts.isNullOrEmpty())
            return null to null

        if (firstName.isNullOrEmpty())
            firstName = null
        if (lastName.isNullOrEmpty())
            lastName = null

        return firstName to lastName
    }

    fun transliteration(payloads: String, divider: String = " "): String {
        var res = ""
        val stringArray: List<String> = payloads.split(" ")

        stringArray.forEach {
            for (char in it.indices) {
                res += getCharRusToLatin(it[char])
            }
            res += divider
        }
        return res.dropLast(1)
    }

    private fun getCharRusToLatin(ch: Char) =
            when(ch) {
                'а'->"a"
                'б'->"b"
                'в'->"v"
                'г'->"g"
                'д'->"d"
                'е'->"e"
                'ё'->"e"
                'ж'->"zh"
                'з'->"z"
                'и'->"i"
                'й'->"i"
                'к'->"k"
                'л'->"l"
                'м'->"m"
                'н'->"n"
                'о'->"o"
                'п'->"p"
                'р'->"r"
                'с'->"s"
                'т'->"t"
                'у'->"u"
                'ф'->"f"
                'х'->"h"
                'ц'->"c"
                'ч'->"ch"
                'ш'->"sh"
                'щ'->"sh"
                'ъ'->""
                'ы'->"i"
                'ь'->""
                'э'->"e"
                'ю'->"yu"
                'я'->"ya"
                'А'->"A"
                'Б'->"B"
                'В'->"V"
                'Г'->"G"
                'Д'->"D"
                'Е'->"E"
                'Ё'->"E"
                'Ж'->"Zh"
                'З'->"Z"
                'И'->"I"
                'Й'->"I"
                'К'->"K"
                'Л'->"L"
                'М'->"M"
                'Н'->"N"
                'О'->"O"
                'П'->"P"
                'Р'->"R"
                'С'->"S"
                'Т'->"T"
                'У'->"U"
                'Ф'->"F"
                'Х'->"H"
                'Ц'->"C"
                'Ч'->"Ch"
                'Ш'->"Sh"
                'Щ'->"Sh"
                'Ы'->"I"
                'Э'->"E"
                'Ю'->"Yu"
                'Я'->"Ya"
                else -> ch
        }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var ch:Char?
        if (firstName != null && firstName != "" && firstName != " ") {
            ch = firstName.trim().capitalize()[0]
            if (lastName != null && lastName != "" && lastName != " ") {
                return "" + ch + lastName.trim().capitalize()[0]
            }else
               return "" + ch
        }else
            return null
    }
}