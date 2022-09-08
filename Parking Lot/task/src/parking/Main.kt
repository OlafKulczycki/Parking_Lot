package parking

data class Car (val regNr: String, val color: String)
val parkingLot = mutableMapOf<Int, Car>()
val freeCarSpot = Car("empty", "empty")
fun create(size: Int){
    if (parkingLot.isNotEmpty()) {
        parkingLot.clear()
    }
    for (i in 1..size) {
        parkingLot[i] = freeCarSpot
    }
    println("Created a parking lot with $size spots.")
}
fun park (regNr: String, color: String) {
    if (parkingLot.containsValue(freeCarSpot)) {
        for (i in 1..parkingLot.size) {
            if (parkingLot[i]!! == freeCarSpot) {
                parkingLot[i] = Car(regNr, color)
                println("$color car parked in spot $i.")
                break
            }
        }
    } else
        println("Sorry, the parking lot is full.")
}
fun leave (spot: Int) {
    val parkingSpotRegNr = parkingLot[spot]!!.regNr
    if (parkingSpotRegNr != "empty") {
        parkingLot[spot] = freeCarSpot
        println("Spot $spot is free.")
    } else {
        println("There is no car in spot $spot.")
    }
}
fun status() {
    var empty = true
    for (i in 1..parkingLot.size) {
        val parkingSpot = parkingLot[i]!!
        if (parkingSpot != freeCarSpot) {
            println("$i " + parkingSpot.regNr + " " + parkingSpot.color)
            empty = false
        }
    }
    if (empty) println("Parking lot is empty.")
}
fun regByColor(tColor: String) {
    val list = parkingLot.filterValues { car -> car.color.lowercase() == tColor.lowercase() }.values.joinToString { car -> car.regNr }
    if (list.isNotEmpty()) {
        println(list)
   } else {
        println("No cars with color $tColor were found.")
    }
}
fun spotByColor(tColor: String) {
    val output = mutableListOf<String>()
    var hasColor = false
    for (i in 1..parkingLot.size) {
        if (parkingLot[i]!!.color.lowercase() == tColor.lowercase()) {
            output.add(i.toString())
            hasColor = true
        }
    }
    if (hasColor) println(output.joinToString()) else println("No cars with color $tColor were found.")
}
fun spotByReg(tReg: String) {
    var tRegAvailable = false
    for (i in 1..parkingLot.size)
        if (parkingLot[i]!!.regNr == tReg) {
            println(i)
            tRegAvailable = true
            break
        }
    if (!tRegAvailable) println("No cars with registration number $tReg were found.")
}

fun main() {
    var running = true
    while (parkingLot.isEmpty()) {
        val input = readln()
        val splitInput = input.split(" ")
        if (input.contains("create")) {
            create(splitInput[1].toInt())
            break
        } else if (input.contains("exit")) {
            running = false
            break
        } else
            println("Sorry, a parking lot has not been created.")
    }
    while (running) {
        val input = readln()
        val splitInput = input.split(" ")
        val command = splitInput.firstOrNull()
        when(command) {
            "create" -> create(splitInput[1].toInt())
            "park" -> park(splitInput[1], splitInput[2])
            "exit" -> running = false
            "leave" -> leave(splitInput[1].toInt())
            "status" -> status()
            "reg_by_color" -> regByColor(splitInput[1])
            "spot_by_color" -> spotByColor(splitInput[1])
            "spot_by_reg" -> spotByReg(splitInput[1])
            else -> println("error")
        }
    }
}
