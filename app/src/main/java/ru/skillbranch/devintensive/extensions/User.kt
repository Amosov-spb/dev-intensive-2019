package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView {
    val nickName = ""
    //val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Ни разу не был" else if (isOnilne) "online" else "Последний раз был ${this.lastVisit.humanizeDiff()} "

    return UserView(
            id,
            fullName = "$firstName $lastName",
            nickName = nickName,
            initials = initials,
            avatar = avatar,
            status = status
    )
}


