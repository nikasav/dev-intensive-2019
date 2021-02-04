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
                'а' -> "a"
                'А' -> "A"
                'б' -> "b"
                'Б' -> "B"
                'в' -> "v"
                'В' -> "V"
                'г' -> "g"
                'Г' -> "G"
                'д' -> "d"
                'Д' -> "D"
                'е' -> "e"
                'Е' -> "E"
                'ё' -> "je"
                'Ё' -> "Je"
                'ж' -> "zh"
                'Ж' -> "Zh"
                'з' -> "z"
                'З' -> "Z"
                'и' -> "i"
                'И' -> "I"
                'й' -> "y"
                'Й' -> "Y"
                'к' -> "k"
                'К' -> "K"
                'л' -> "l"
                'Л' -> "L"
                'м' -> "m"
                'М' -> "M"
                'н' -> "n"
                'Н' -> "N"
                'о' -> "o"
                'О' -> "O"
                'п' -> "p"
                'П' -> "P"
                'р' -> "r"
                'Р' -> "R"
                'с' -> "s"
                'С' -> "S"
                'т' -> "t"
                'Т' -> "T"
                'у' -> "u"
                'У' -> "U"
                'ф' -> "f"
                'Ф' -> "F"
                'х' -> "kh"
                'Х' -> "Kh"
                'ц' -> "c"
                'Ц' -> "C"
                'ч' -> "ch"
                'Ч' -> "Ch"
                'ш' -> "sh"
                'Ш' -> "Sh"
                'щ' -> "jsh"
                'Щ' -> "Jsh"
                'ъ' -> "hh"
                'Ы' -> "Ih"
                'ы' -> "ih"
                'ь' -> "Jh"
                'э' -> "eh"
                'Э' -> "Eh"
                'ю' -> "ju"
                'Ю' -> "Ju"
                'я' -> "ja"
                'Я' -> "Ja"
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