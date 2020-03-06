package com.abylay.devintensive.extensions

import com.abylay.devintensive.models.User
import com.abylay.devintensive.models.UserView
import com.abylay.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView {
    //val nickname = Utils.transLiteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Еще ни разу не был" else if (isOnline) "online" else "Последний раз был " +
            lastVisit.humanizeDiff()

    return UserView(
        id,
        fullName = "$firstName $lastVisit",
        nickName = "nickname",
        initials = initials,
        avatar = avatar,
        status = status)
}

private fun Date.humanizeDiff(date: Date = Date()): String {
    return ""
}
