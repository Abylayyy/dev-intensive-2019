package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class TextMessage(
    id: String,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, chat, isIncoming, date) {

    override fun formatMessage(): String {
        /*return when (isIncoming) {
            false -> "${from?.firstName} отправил сообщение \"${text}\" ${date.humanizeDiff()}"
            else -> "${from?.firstName} получил сообщение \"${text}\" ${date.humanizeDiff()}"
        }*/
        return ""
    }

}