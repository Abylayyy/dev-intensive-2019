package com.abylay.devintensive.models

import com.abylay.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline: Boolean = false
) {

    constructor(userId: String, firstName: String?, lastName: String?, lastVisit: Date?): this(
        id = userId,
        firstName = firstName,
        lastName = lastName,
        lastVisit = lastVisit,
        avatar = null
    )

    init {
        println("He is alive!\n" +
                "${if (lastName == "Doe") "His name id $firstName $lastName" 
                else "And his name is $firstName $lastName"}\n"
        )
    }

    companion object Factory {
        private var lastId = -1

        fun makeUser(fullName: String?): User {
            lastId ++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(userId = "$lastId", firstName = firstName, lastName = lastName, lastVisit = Date())
        }
    }
}