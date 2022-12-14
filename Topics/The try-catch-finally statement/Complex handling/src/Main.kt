import java.io.IOException
import java.lang.ArithmeticException

fun suspiciousFunction (param: Int) {
    when (param) {
        0 -> throw Exception("Some exceptions?")
        1 -> throw ArithmeticException("Division by zero")
        2 -> throw Exception("An exception occurred here")
        3 -> throw IOException()
    }
}        

fun handleException (data: Int) {
    try {
        suspiciousFunction(data)
    } catch (e: ArithmeticException) {
        println(e.message)
    } catch (i: IOException) {
        println("The IOException occurred")
    } catch (s: Exception) {
        println(s.message)
    } finally {
        println("Handling completed successfully!")
    }
}