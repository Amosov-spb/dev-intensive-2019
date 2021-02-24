package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User private constructor(
        val id: String,
        var firstName: String?,
        var lastName: String?,
        var avatar: String?,
        var rating: Int = 0,
        var respect: Int = 0,
        val lastVisit: Date? = Date(),
        val isOnilne: Boolean = false) {

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastId", firstName = firstName, lastName = lastName, avatar = "не определен")
        }
    }

    object Builder {
        private var lastId: Int = -1

        fun build(firstName: String?, lastName: String?, avatar: String?, rating: Int = 0, respect: Int = 0,
                  lastVisit: Date? = Date(), isOnilne: Boolean = false): User {
            lastId++
            return User(lastId.toString(), firstName, lastName, avatar, rating, respect, lastVisit, isOnilne)
        }
    }
}
