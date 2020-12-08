import java.io.File

object Day3a : Runnable {
    override fun run() {
        val input = File("day3.input").readLines().map { it.trim() }
        val field = input.map {
            it.toCharArray()
        }.toTypedArray()
        val trees = checkSlope(3, 1, field)
        println(trees)
    }

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
            } else field[y][x] = 'O'
            y+=fall
        }
        return (treeCounter)
    }
}