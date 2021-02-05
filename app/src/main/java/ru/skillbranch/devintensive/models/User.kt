package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class  User(
        val id          : String,
        var firstName   : String?,
        var lastName    : String?,
        var avatar      : String?,
        var rating      : Int = 0,
        var respect     : Int = 0,
        val lastVisit   : Date? = Date(),
        val isOnline    : Boolean = false
) {
    constructor(id:String, firstName: String?, lastName: String?): this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id:String): this(
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
        fun makeUser(fullName:String?) : User {
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "${lastId++}", firstName = firstName,lastName = lastName)
        }
    }
}