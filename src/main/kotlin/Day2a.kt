import java.io.File

object Day2a : Runnable {

    data class PasswordEntry(val char: Char, val lower: Int, val upper: Int, val password: String) {
        fun isValid() = password.count { it == char } in lower.rangeTo(upper)
    }

    fun parse(line: String): PasswordEntry {
        val regex = Regex("(\\d+)-(\\d+) (\\w): (\\w+)")
        val match = regex.matchEntire(line.trim())!!
        val (_, lower, upper, char, password) = match.groupValues
        return PasswordEntry(char[0], lower.toInt(), upper.toInt(), password)
    }

    override fun run() {
        val entries = File("day2.input").readLines().map { parse(it) }
        val filtered = entries.filter { it.isValid() }
        println(filtered.size)
    }


}