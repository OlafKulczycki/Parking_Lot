fun main() {
    val input = readln()
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    for (i in alphabet.indices) {
        if (input.contains(alphabet[i]) ) continue
        print(alphabet[i])
    }
}