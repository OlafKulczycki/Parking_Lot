open class Bottle(val volume: Float) {
    open fun getFullInfo(): String = "$volume volume"
}

open class GlassBottle(volume: Float, val color: String) : Bottle(volume) {
    fun getFullInfo(): String = super.getFullInfo() + ", $color color"
}
fun main(args: Array<String>) {
  // put your code here
}
