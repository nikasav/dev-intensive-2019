package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
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
    fun test_parseFullName() {
        val fullNames = arrayListOf(null, "" , " ", "John", " John")

        for(fullName in fullNames){
            println("--$fullName--\n ${Utils.parseFullName(fullName).first} ${Utils.parseFullName(fullName).second}")
        }
    }

    @Test
    fun test_toInitials() {
        println(Utils.toInitials("john" ,"doe")) //JD
        println(Utils.toInitials("John" ,"doe")) //JD
        println(Utils.toInitials("ohn" ,"Doe")) //JD
        println(Utils.toInitials("John", null)) //J
        println(Utils.toInitials(null, null)) //null
        println(Utils.toInitials(" ", "")) //null
        println(Utils.toInitials("Lll", ""))
    }

    @Test
    fun test_transliteration() {
        println(Utils.transliteration("Женя Стереотипов")) //Zhenya Stereotipov
        println(Utils.transliteration("Amazing Петр","_")) //Amazing_Petr
    }

    @Test
    fun test_DateFormat() {
        println(Date().format()) //14:00:00 27.06.19
        println(Date().format("HH:mm")) //14:00
    }

    @Test
    fun test_humanizeDiff() {
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff()) //2 часа назад
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff()) //5 дней назад
        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff()) //через 2 минуты
        println(Date().add(7, TimeUnits.DAY).humanizeDiff()) //через 7 дней
        println(Date().add(-400, TimeUnits.DAY).humanizeDiff()) //более года назад
        println(Date().add(400, TimeUnits.DAY).humanizeDiff()) //более чем через год
       }

    @Test
    fun test_addDate() {
        println(Date().add(2, TimeUnits.SECOND)) //Thu Jun 27 14:00:02 GST 2019
        println(Date().add(-4, TimeUnits.DAY)) //Thu Jun 23 14:00:00 GST 2019
    }

    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2", "Jon", "Week")
        val user3 = User("3", "Jone","Silver", null, lastVisit = Date(), isOnline = true)
        }

    @Test
    fun test_factory() {
        val user = User.makeUser("John Wick")
        val user3 = User.makeUser("John")
        val user4 = User.makeUser(" Kbhfg")
        val user5 = User.makeUser(" ")
        val user6 = User.makeUser(null)

        val user2 = user.copy(id = "2", lastName = "Cena", lastVisit = Date())

        println(user)
        println(user3)
        println(user4)
        println(user5)
        println(user6)

        println(user2)
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user  = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_data_maping() {
        val user = User.makeUser("Макеев Михаил")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(newUser)
        val userView = newUser.toUserView()
        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Макеев Михаил")

        println(BaseMessage.makeMessage(user, Chat("0"), Date(),"text",  "any text message").formatMessage()) //Василий отправил сообщение "any text message" только что
        println(BaseMessage.makeMessage(user, Chat("0"), Date(), "image", "https://anyurl.com").formatMessage()) //Василий получил изображение "https://anyurl.com" 2 часа назад
    }

}