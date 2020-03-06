package com.abylay.devintensive.models

import com.abylay.devintensive.extensions.humanizeDiff
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean,
    date: Date = Date(),
    var image: String?
) : BaseMessage(id, from, chat, isIncoming, date) {

    override fun formatMessage(): String {
        return when (isIncoming) {
            false -> "${from?.firstName} отправил изображение ${image} ${date.humanizeDiff()}"
            else -> "${from?.firstName} получил изображение ${image} ${date.humanizeDiff()}"
        }
    }
}