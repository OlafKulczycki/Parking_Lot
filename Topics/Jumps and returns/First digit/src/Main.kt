fun main() {
    val input = readln().toString()
    for (i in input.indices) {
        if (input[i].isDigit()) {
            println(input[i])
            break
        }
    }
}