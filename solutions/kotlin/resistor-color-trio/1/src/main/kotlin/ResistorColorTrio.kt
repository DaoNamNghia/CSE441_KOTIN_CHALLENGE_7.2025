object ResistorColorTrio {

    fun text(vararg input: Color): String {
        var output = StringBuilder("")

        var numOfZeros = input[2].ordinal

        output.append(input[0].ordinal)

        if (input[1].ordinal == 0) numOfZeros++ else output.append(input[1].ordinal)

        output.append("0".repeat(numOfZeros % 3))

        return output.append(" " + Unit.values()[numOfZeros / 3].name.toLowerCase()).toString()
    }
}