fun transcribeToRna(dna: String): String {
    var transcribedRNA : String = ""  //Initialize an empty string so you can add to the empty string in the loop used to transcribe the DNA
    val RNAConversion : Map<Char, String> = mapOf('G' to "C", 'C' to "G", 'T' to "A", 'A' to "U") //immutable key for the RNA & DNA
    for (letter in dna) transcribedRNA += RNAConversion[letter] //RNAConversion.getValue(letter)
    return transcribedRNA
}