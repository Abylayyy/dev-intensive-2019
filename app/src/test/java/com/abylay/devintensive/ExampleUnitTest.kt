package com.abylay.devintensive

import com.abylay.devintensive.extensions.TimeUnits
import com.abylay.devintensive.extensions.add
import com.abylay.devintensive.extensions.format
import com.abylay.devintensive.extensions.toUserView
import com.abylay.devintensive.models.User
import com.abylay.devintensive.utils.Utils
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_factory() {
        val user = User("1", firstName = "John", lastName = "Adams", lastVisit = Date())
        val user2 = user.copy(lastVisit = Date().add(5, TimeUnits.MINUTE))
        val user3 = user2.copy(lastVisit = Date().add(7, TimeUnits.HOUR))

        print("""
            first user -> ${user.lastVisit?.format()}
            second user -> ${user2.lastVisit?.format()}
            third user -> ${user3.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_parse_full_name() {
        println(Utils.parseFullName("John Doe"))
        println(Utils.parseFullName(null))
        println(Utils.parseFullName("${null} John"))
        println(Utils.parseFullName(""))
        println(Utils.parseFullName(" "))
        println(Utils.parseFullName("John"))
    }

    @Test
    fun test_initials() {
        println(Utils.toInitials("john" ,"doe")) //JD
        println(Utils.toInitials("John", null)) //J
        println(Utils.toInitials(null, null)) //null
        println(Utils.toInitials(" ", "")) //null
    }

    @Test
    fun test_transliteration() {
        println(Utils.transliteration("Женя Стереотипов"))
        println(Utils.transliteration("Amazing Петр","_"))
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user
        val (id, firstname, lastname) = getUserInfo()

        println("$id $firstname $lastname")
    }

    @Test
    fun test_data_maping() {
        val user = User.makeUser("Makeev Michael")
        println(user)
        val userView = user.toUserView()
        userView.printMe()
    }
}
