package ru.skillbranch.devintensive

import org.junit.Test
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Bender
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

class ExampleUnitTest {

    @Test
    fun test_user() {
        val user = User.makeUser("Tillabek Abylay")
        println(user)
    }

    @Test
    fun test_check() {
        print(Bender().checkAnswers(Bender.Question.SERIAL, "5555555"))
    }

    @Test
    fun test_format() {
        println(Date().format())
        println(Date().format("HH:mm"))
    }

    @Test
    fun test_baseMessage() {
        val user1 = User(
            "1",
            firstName = "John",
            lastName = "Adams",
            lastVisit = Date().add(
                -1,
                TimeUnits.HOUR
            )
        )
        val user2 = User(
            "2",
            firstName = "John",
            lastName = "Doe",
            lastVisit = Date().add(
                -2,
                TimeUnits.MINUTE
            )
        )
        println(
            user1.lastVisit?.let {
                BaseMessage.makeMessage(
                    user1,
                    Chat(
                        "1",
                        mutableListOf(user1, user2),
                        mutableListOf()
                    ),
                    it,
                    "image",
                    "Hello"
                ).formatMessage()
            }
        )
    }

    @Test
    fun test_humanize() {
        println("""
            ${Date().add(-1, TimeUnits.SECOND).humanizeDiff()}
            ${Date().add(-45, TimeUnits.SECOND).humanizeDiff()}
            ${Date().add(-75, TimeUnits.SECOND).humanizeDiff()}
            ${Date().add(-2, TimeUnits.MINUTE).humanizeDiff()}
            ${Date().add(-60, TimeUnits.MINUTE).humanizeDiff()}
            ${Date().add(-10, TimeUnits.HOUR).humanizeDiff()}
            ${Date().add(-30, TimeUnits.DAY).humanizeDiff()}
            ${Date().add(-370, TimeUnits.DAY).humanizeDiff()}
            ${Date().add(30, TimeUnits.DAY).humanizeDiff()}
        """.trimIndent())
    }

    @Test
    fun test_parse_full_name() {
        println("""
            ${Utils.parseFullName("John Doe")}
            ${Utils.parseFullName(null)}
            ${Utils.parseFullName("${null} John")}
            ${Utils.parseFullName("")}
            ${Utils.parseFullName(" ")}
            ${Utils.parseFullName("John")}
        """.trimIndent())
    }

    @Test
    fun test_initials() {
        println(Utils.toInitials("john" ,"doe"))
        println(Utils.toInitials("John", null))
        println(Utils.toInitials(null, null))
        println(Utils.toInitials(" ", ""))
    }

    @Test
    fun test_transliteration() {
        println(Utils.transliteration("Женя Стереотипов"))
        println(Utils.transliteration("Amazing Петр","_"))
        println(Utils.transliteration("Азамат cатыбалды Taz", "_"))
    }

    @Test
    fun test_plural() {
        println("""
            ${TimeUnits.SECOND.plural(1)}
            ${TimeUnits.MINUTE.plural(4)}
            ${TimeUnits.HOUR.plural(19)}
            ${TimeUnits.DAY.plural(222)}
        """.trimIndent())
    }

    @Test
    fun test_builder() {
        val user = User.Builder()
            .id("1")
            .firstName("Adam")
            .lastName("Driver")
            .avatar("image")
            .rating(5)
            .respect(10)
            .lastVisit(Date().add(-5, TimeUnits.HOUR))
            .isOnline(true)
            .build()
        println(user)
    }

    @Test
    fun test_truncate() {
        println("Samal jelde shalkar kolde demalamyz kaitamyz".truncate())
        println("Samal jelde shalkar kolde demalamyz kaitamyz".truncate(43))
    }

    @Test
    fun test_striphtml() {
        println("<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>".stripHtml())
        println("<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml())
    }

    /*@Test
    fun check_prime() {

        println(Utils.isPrime(17)) // true

        val array = Utils.update(
            arrayOf(
                arrayOf(0, 1, 0, 1, 1),
                arrayOf(0, 0, 3, 0, 2),
                arrayOf(0, 1, 2, 0, 1),
                arrayOf(0, 1, 0, 1, 0),
                arrayOf(0, 1, 0, 1, 0)
            ), 3, 1, 10
        )
        for (i in array.indices) {
            for (j in array[i].indices) {
                print("${array[i][j]} ")
            }
            println()
        }
        *//*
            0 10 0 10 10
            0 0 3 0 2
            0 10 2 0 10
            0 10 0 10 0
            0 10 0 10 0
        *//*
    }*/
}
