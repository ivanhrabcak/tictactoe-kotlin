package me.ivan.tictactoe

class TicTacToe() {
    val field: Array<Int> = Array<Int>(9, {i -> 0})

    fun turn(player: Int, position: Position): Boolean {
        var index: Int = position.x * 3 + position.y
        if (field[index] != 0) {
            return false
        }
        field[index] = player
        return true
    }

    fun hasWon(): Int {
        /* horizontal lines */
        var index: Int = 0
        var counter : Int = 0
        var previous: Int = 0
        for (i: Int in field.indices) {
            val current: Int = field[i]
            if (previous == current && current != 0) {
                counter++
            }
            if (index == 2 || index == 5 || index == 8) {
                if (counter == 2) {
                    return field[i]
                }
                counter = 0
            }
            previous = current
            index++
        }
        /* diagonal lines */

        // \
        previous = 0
        counter = 0
        for (i: Int in 0..field.size step 4) {
            if (i == 0) {
                previous = field[i]
            }
            else {
                if (previous == field[i] && previous != 0) {
                    counter++
                }
                else {
                    break;
                }
            }
        }
        if (counter == 2) {
            return field[field.size - 1]
        }

        // /
        counter = 0
        previous = 0
        for (i: Int in field.size - 3 downTo 2 step 2) {
            if (i == field.size - 3) {
                previous = field[i]
            }
            else {
                if (previous == field[i] && previous != 0) {
                    counter++
                }
                else {
                    break
                }
            }
        }
        if (counter == 2) {
            return field[2]
        }

        /* vertical lines */
        for (i: Int in 0 until 3) {
            counter = 0
            previous = 0
            for (j: Int in i..field.size - 1 step 3) {
                if (j == i) {
                    previous = field[j]
                }
                else {
                    if (previous == field[j] && previous != 0) {
                        counter++
                    }
                    else {
                        break
                    }
                }
            }
            if (counter == 2) {
                return field[i]
            }
        }
        return 0
    }

    fun printField() {
        for (i: Int in 0 until 3) {
            print("|-----|-----|-----|\n")
            for (j: Int in 0 until 3) {
                print("|  ${if (field[i * 3 + j] == 1) "x" else if (field[i * 3 + j] == 2) "O" else " "}  ")
            }
            print("|\n")
        }
        print("|-----|-----|-----|\n")
    }
}