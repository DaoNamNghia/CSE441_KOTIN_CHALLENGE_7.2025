class School {

    private val students = mutableMapOf<Int,List<String>>()
	
    fun add(student: String, grade: Int) {
		students[grade] = (grade(grade) + student).sorted()
    }

    fun grade(grade: Int) = students.getOrDefault(grade, listOf())

    fun roster() = students.toSortedMap().flatMap { it.value }
}