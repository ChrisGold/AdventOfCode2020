import java.io.File

object Day1a : Runnable{
    override fun run() {
        val target = 2020
        val numbers = File("day1.input").readLines().map { it.trim().toLong() }
        val numbersSet = numbers.toSet()
        val correspondents = numbers.map { target - it }
        val i = correspondents.withIndex().first { (i, v): IndexedValue<Long> -> v in numbersSet }.index
        val a = numbers[i]
        val b = correspondents[i]
        println("The two numbers are $a and $b, with a product of ${a*b}")
    }
}