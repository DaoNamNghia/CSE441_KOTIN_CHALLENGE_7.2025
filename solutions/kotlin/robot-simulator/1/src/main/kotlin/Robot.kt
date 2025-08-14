class Robot(var gridPosition: GridPosition = GridPosition(0, 0),
            var orientation: Orientation = Orientation.NORTH) {
    fun turnRight() {
        orientation = when (orientation) {
            Orientation.NORTH -> Orientation.EAST
            Orientation.EAST -> Orientation.SOUTH
            Orientation.SOUTH -> Orientation.WEST
            Orientation.WEST -> Orientation.NORTH
        }
    }

    fun turnLeft() {
        orientation = when (orientation) {
            Orientation.NORTH -> Orientation.WEST
            Orientation.EAST -> Orientation.NORTH
            Orientation.SOUTH -> Orientation.EAST
            Orientation.WEST -> Orientation.SOUTH
        }
    }

    fun advance() {
        gridPosition = when (orientation) {
            Orientation.NORTH -> gridPosition.copy(y = gridPosition.y + 1)
            Orientation.SOUTH -> gridPosition.copy(y = gridPosition.y - 1)
            Orientation.EAST -> gridPosition.copy(x = gridPosition.x + 1)
            Orientation.WEST -> gridPosition.copy(x = gridPosition.x - 1)
        }
    }

    fun simulate(input: String) {
        input.forEach {
            when (it) {
                'L' -> turnLeft()
                'R' -> turnRight()
                'A' -> advance()
                else -> throw IllegalArgumentException("unhandled instruction '$it'")
            }
        }
    }
}