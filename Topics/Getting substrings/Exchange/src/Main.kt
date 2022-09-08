fun main() {
    val text = readln()
    println(text.last() + text.substring(1, text.length - 1) + text.first())
}