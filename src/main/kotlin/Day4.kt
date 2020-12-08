import java.awt.Color
import java.io.File
import java.lang.Exception

object Day4 : Runnable {

    val fields = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    val eyecolour = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    override fun run() {
        val data = File("day4.input").readText().split(System.lineSeparator() + System.lineSeparator())
        val normalized = data.map { it.replace(System.lineSeparator(), " ") }
        val passports = normalized.map { parse(it) }
        val complete = passports.filter { passport ->
            fields.all { it in passport.keys }
        }
        val valid = complete.filter {
            try {
                val byr = it["byr"]!!.toInt()
                byr in 1920..2002 || return@filter false
                val iyr = it["iyr"]!!.toInt()
                iyr in 2010..2020 || return@filter false
                val eyr = it["eyr"]!!.toInt()
                eyr in 2020..2030 || return@filter false
                val hgt = it["hgt"]!!
                checkHeight(hgt) || return@filter false
                val hcl = it["hcl"]!!
                checkColour(hcl) || return@filter false
                val ecl = it["ecl"]!!
                ecl in eyecolour || return@filter false
                val pid = it["pid"]!!
                (pid.length == 9 && pid.toIntOrNull() != null)
            } catch (ex: Exception) {
                false
            }

        }
        //println(complete)
        println("Complete: " + complete.size)
        println("Valid: " + valid.size)
    }

    fun checkHeight(input: String): Boolean {
        val magnitude = input.substring(0, input.length - 2).toInt()
        if (input.endsWith("in")) {
            return magnitude in 59..76
        } else if (input.endsWith("cm")) {
            return magnitude in 150..193
        }
        return false
    }

    fun checkColour(input: String): Boolean {
        return input.startsWith("#") && input.length == 7 && input.substring(1).toUpperCase().toIntOrNull(16) != null
    }

    fun parse(line: String): Map<String, String> = line.trim().split(" ").map {
        val (key, value) = it.split(":")
        key to value
    }.toMap()
}