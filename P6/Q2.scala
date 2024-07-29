import scala.io.StdIn._

object StudentRecordApp {

  def calculatePercentageAndGrade(marks: Int, totalMarks: Int): (Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
    (percentage, grade)
  }
  
  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks < 0 || totalMarks <= 0) {
      (false, Some("Marks and total marks must be positive integers"))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks"))
    } else {
      (true, None)
    }
  }
  
  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var result: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'D')

    while (!isValid) {
      print("Enter student name: ")
      val name = readLine().trim

      print("Enter marks obtained: ")
      val marks = readInt()

      print("Enter total possible marks: ")
      val totalMarks = readInt()

      // Validate input
      val (valid, errorMessage) = validateInput(name, marks, totalMarks)
      if (valid) {
        val (percentage, grade) = calculatePercentageAndGrade(marks, totalMarks)
        result = (name, marks, totalMarks, percentage, grade)
        isValid = true
      } else {
        println(s"Invalid input: ${errorMessage.get}")
      }
    }
    result
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks Obtained: $marks")
    println(s"Total Possible Marks: $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }
  
  def main(args: Array[String]): Unit = {
    val studentRecord = getStudentInfo()
    printStudentRecord(studentRecord)
  }
}