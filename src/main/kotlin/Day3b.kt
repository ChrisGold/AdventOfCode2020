import java.io.File

object Day3b : Runnable {
    override fun run() {
        val slopes = arrayOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
        val results = slopes.map { (run, fall) -> (run to fall) to checkSlope(run, fall, readField()).toLong() }
        println(results)
        val product = results.map { it.second }.reduce(Long::times)
        println(product)
    }

    fun readField(): Array<CharArray> = File("day3.input").readLines().map { it.trim() }.map {
        it.toCharArray()
    }.toTypedArray()

    fun checkSlope(run: Int, fall: Int, field: Array<CharArray>): Int {
        val width = field[0].size
        val height = field.size
        var treeCounter = 0

        var x = 0
        var y = fall
        while (y < height) {
            x += run
            x %= width
            if (field[y][x] == '#') {
                treeCounter++;
                field[y][x] = 'X'
            } else field[y][x] = 'O';
            y+=fall
        }
        println("Run $run over Fall $fall")
        println(treeCounter)
        field.forEach { println(String(it)) }
        return (treeCounter)
    }
}