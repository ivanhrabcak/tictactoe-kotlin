package me.ivan.tictactoe

import java.util.*
import java.util.concurrent.TimeUnit

fun String.runCommand() {
    ProcessBuilder(*split(" ").toTypedArray())
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()
            .waitFor(60, TimeUnit.MINUTES)
}

fun clearScreen() {
    if (System.getProperty("os.name").startsWith("Windows")) {
        "cls".runCommand()
    }
    else {
        "clear".runCommand()
    }
}

fun main(args: Array<String>) {
    val ticTacToe: TicTacToe = TicTacToe()
    var position: Position
    var currentPlayer: Int = 1
    ticTacToe.printField()
    while (ticTacToe.hasWon() == 0) {
        try {
            print("? ")
            position = Position(readLine()!!.split(" "))
        }
        catch (e: NumberFormatException) {
            while (true) {
                try {
                    print("? ")
                    position = Position(readLine()!!.split(" "))
                    break
                }
                catch(e: java.lang.NumberFormatException) {
                    continue
                }
            }
        }
        ticTacToe.turn(currentPlayer, position)
        if (currentPlayer == 1) {
            currentPlayer = 2
        }
        else {
            currentPlayer = 1
        }
        clearScreen()
        ticTacToe.printField()

    }
    clearScreen()
    ticTacToe.printField()
    println("Player ${ticTacToe.hasWon()} has won!")
}