fun pepTalk(name: String) : String {
    val array = name.split(" ").toTypedArray()
    val firstName = array[0]
    val secondName = array[1]
    return "Don't lose the towel, traveler $firstName $secondName!"
}   
// do not change the function above        

fun main() {
    val name = readLine()!!
    println("Good luck!")
    try {
        val advice = pepTalk(name)
        print(advice)
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Don't lose the towel, nameless one.")
    } catch (i: java.lang.Exception) {
        println("Don't lose the towel, nameless one.")
    }
}