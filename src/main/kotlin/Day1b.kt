import java.io.File

object Day1b : Runnable {
    override fun run() {
        val target = 2020
        val numbers = File("day1.input").readLines().map { it.trim().toInt() }

        numbers.forEach { a ->
            numbers.forEach { b ->
                numbers.forEach { c ->
                    val sum = a + b + c
                    if(sum == target){
                        println("The three numbers are $a, $b, and $c, with a product of ${a * b * c}")
                    }
                }
            }
        }
    }
}