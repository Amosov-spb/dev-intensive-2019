package ru.skillbranch.devintensive.utils

object Utils {

    private val dictionary = mapOf<Char, String>(
            'а' to "a",
            'б' to "b",
            'в' to "v",
            'г' to "g",
            'д' to "d",
            'е' to "e",
            'ё' to "e",
            'ж' to "zh",
            'з' to "z",
            'и' to "i",
            'й' to "i",
            'к' to "k",
            'л' to "l",
            'м' to "m",
            'н' to "n",
            'о' to "o",
            'п' to "p",
            'р' to "r",
            'с' to "s",
            'т' to "t",
            'у' to "u",
            'ф' to "f",
            'х' to "h",
            'ц' to "c",
            'ч' to "ch",
            'ш' to "sh",
            'щ' to "sh'",
            'ъ' to "",
            'ы' to "i",
            'ь' to "",
            'э' to "e",
            'ю' to "yu",
            'я' to "ya"
    )

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String? = null): String? {
        val firstNameLocal = (firstName ?: "").trim()
        val lastNameLocal = (lastName ?: "").trim()

        if ((firstNameLocal.isNullOrEmpty()) && (lastNameLocal.isNullOrEmpty()))
            return null

        return getInitials(firstNameLocal) + getInitials(lastNameLocal)
    }

    private fun getInitials(string: String) = (if (string.isEmpty()) "" else string?.substring(0, 1)?.capitalize())


    fun transliteration(payload: String, divider: String = " "): String {
        var res = mutableListOf<String>()
        for (c in payload.toCharArray()) {
            when (c) {
                ' ' -> res.add(divider)
                c.toUpperCase() -> {
                    var v = dictionary.get(c.toLowerCase())
                    res.add(v?.toUpperCase().toString())
                }
                else -> {
                    var v = dictionary.get(c)
                    res.add(v.toString())
                }
            }
        }

        val r = res.joinToString("", "", "")
        return r
    }
}



