fun solution() {
    val first = readln().toInt()
    val second = readln().toInt()
    try {
        println(first / second)
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("This is the end, my friend.")
    }
}