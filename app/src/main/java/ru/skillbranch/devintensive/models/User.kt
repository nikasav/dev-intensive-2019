package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class  User(
        val id: String,
        var firstName: String?,
        var lastName: String?,
        var avatar: String?,
        var rating: Int = 0,
        var respect: Int = 0,
        val lastVisit: Date? = Date(),
        val isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?): this(
            id = id,
            firstName = firstName,
            lastName = lastName,
            avatar = null
    )

    constructor(id: String): this(
            id = id,
            firstName = "",
            lastName = "",
            avatar = null
    )

    init {
        println("Hello $lastName $firstName . ")
    }

    companion object Factory {
        private var lastId : Int = 0
        fun makeUser(fullName: String?) : User {
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "${lastId++}", firstName = firstName, lastName = lastName)
        }
    }

    class Builder {
        private var userId: String = ""
        private var firstName: String? = null
        private var lastName: String? = null
        private var avatar: String? = null
        private var rating: Int = 0
        private var respect: Int = 0
        private var lastVisit: Date = Date()
        private var isOnline: Boolean = false

        fun setUserId(userId: String): Builder {
            this.userId = userId
            return this
        }

        fun setFirstName(firstName: String?): Builder {
            this.firstName = firstName
            return this
        }

        fun setLastName(lastName: String?): Builder {
            this.lastName = lastName
            return this
        }

        fun setAvatar(avatar: String?): Builder {
            this.avatar = avatar
            return this
        }

        fun setRating(rating: Int): Builder {
            this.rating = rating
            return this
        }
        fun setRespect(respect: Int): Builder {
            this.respect = respect
            return this
        }
        fun setLastVisit(lastVisit: Date): Builder {
            this.lastVisit = lastVisit
            return this
        }
        fun setIsOnline(isOnline: Boolean): Builder {
            this.isOnline = isOnline
            return this
        }

        fun build(): User {
            return User(userId, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)
        }
    }
}