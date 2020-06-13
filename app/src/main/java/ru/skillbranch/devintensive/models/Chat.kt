package ru.skillbranch.devintensive.models

class Chat(
    val id: String,
    val message: MutableList<BaseMessage> = mutableListOf()
) {

}