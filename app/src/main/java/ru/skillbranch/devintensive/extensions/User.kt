package ru.skillbranch.devintensive.extensions

import java.util.*

class User private constructor(
    val id: String?,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int,
    var respect: Int,
    val lastVisit: Date?,
    val isOnline: Boolean
) {

    data class Builder(
        private var id: String? = null,
        private var firstName: String? = null,
        private var lastName: String? = null,
        private var avatar: String? = null,
        private var rating: Int = 0,
        private var respect: Int = 0,
        private var lastVisit: Date? = Date(),
        private var isOnline: Boolean = false
    ) {
        fun id(id: String?) = apply { this.id = id }
        fun firstName(id: String?) = apply { this.firstName = id }
        fun lastName(id: String?) = apply { this.lastName = id }
        fun avatar(id: String?) = apply { this.avatar = id }
        fun rating(id: Int) = apply { this.rating = id }
        fun respect(id: Int) = apply { this.respect = id }
        fun lastVisit(id: Date) = apply { this.lastVisit = id }
        fun isOnline(id: Boolean) = apply { this.isOnline = id }

        fun build() = User(
            id,
            firstName,
            lastName,
            avatar,
            rating,
            respect,
            lastVisit,
            isOnline
        )
    }
}