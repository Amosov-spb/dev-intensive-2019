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

    class Builder {

        var id: String = "1"
        var firstName: String? = null
        var lastName: String? = null
        var avatar: String? = null
        var rating: Int = 0
        var respect: Int = 0
        var lastVisit: Date? = Date()
        var isOnline: Boolean = false

        fun id(id: String) = this.apply { this.id = id}
        fun firstName(firstName: String?) = this.apply { this.firstName = firstName }
        fun lastName(lastName: String) = this.apply { this.lastName = lastName }
        fun avatar(avatar: String) = this.apply { this.avatar = avatar }
        fun rating(rating: Int) = this.apply { this.rating = rating }
        fun respect(respect: Int) = this.apply { this.respect = respect }
        fun lastVisit(lastVisit: Date) = this.apply { this.lastVisit = lastVisit }
        fun isOnline(isOnline: Boolean) = this.apply { this.isOnline = isOnline }

        fun build() = User(id, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)
    }
}
