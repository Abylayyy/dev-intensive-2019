package ru.skillbranch.devintensive.models

import java.util.*

class ImageMessage(
    id: String,
    chat: Chat,
    isIncoming: Boolean,
    date: Date = Date(),
    var image: String?
) : BaseMessage(id, chat, isIncoming, date) {

    override fun formatMessage(): String {
        /*return when (isIncoming) {
            false -> "${from?.firstName} отправил изображение \"${image}\" ${date.humanizeDiff()}"
            else -> "${from?.firstName} получил изображение \"${image}\" ${date.humanizeDiff()}"
        }*/
        return ""
    }
}