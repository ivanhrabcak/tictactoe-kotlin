package me.ivan.tictactoe

data class Position(
    val x: Int,
    val y: Int
) {
    constructor(position: List<String>): this(position[0].toInt(), position[1].toInt())

    override fun toString(): String {
        return "{x: $x, y: $y}"
    }
}

class InvalidPositionException(message: String) : Exception(message)