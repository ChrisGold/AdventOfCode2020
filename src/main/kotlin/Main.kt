object Main {

    private val challenges = mapOf(
        "1a" to Day1a,
        "1b" to Day1b,
        "2a" to Day2a,
        "2b" to Day2b,
        "3a" to Day3a,
        "3b" to Day3b,
        "4a" to Day4
    )

    @JvmStatic
    fun main(args: Array<String>) {
        challenges[args[0]]!!.run()
    }
}