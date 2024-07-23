case class Book(title: String, author: String, isbn: String)
object LibraryManagement {
  // Initial set of books
  var books: Set[Book] = Set(
    Book("1984", "George Orwell", "1234567890"),
    Book("To Kill a Mockingbird", "Harper Lee", "0987654321"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "1029384756")
  )

  // Function to add a new book to the library
  def addBook(book: Book): Unit = {
    books += book
  }

  // Function to remove a book from the library by its ISBN
  def removeBook(isbn: String): Unit = {
    books = books.filterNot(_.isbn == isbn)
  }

  // Function to check if a book is in the library by its ISBN
  def isBookInLibrary(isbn: String): Boolean = {
    books.exists(_.isbn == isbn)
  }

  // Function to display the current library collection
  def displayLibrary(): Unit = {
    books.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  // Function to search for a book by its title
  def searchByTitle(title: String): Option[Book] = {
    books.find(_.title == title)
  }

  // Function to display all books by a specific author
  def booksByAuthor(author: String): Set[Book] = {
    books.filter(_.author == author)
  }

  def main(args: Array[String]): Unit = {
    // Display the current library collection
    displayLibrary()

    // Add a new book
    println("\nAdding a new book...")
    addBook(Book("Brave New World", "Aldous Huxley", "1122334455"))
    displayLibrary()

    // Remove a book by ISBN
    println("\nRemoving a book with ISBN 1234567890...")
    removeBook("1234567890")
    displayLibrary()

    // Check if a book is in the library by ISBN
    println("\nChecking if ISBN 0987654321 is in the library...")
    println(isBookInLibrary("0987654321"))

    // Search for a book by title
    println("\nSearching for the book 'The Great Gatsby'...")
    println(searchByTitle("The Great Gatsby"))

    // Display all books by a specific author
    println("\nDisplaying all books by 'Harper Lee'...")
    booksByAuthor("Harper Lee").foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
  }
}

// Run the main method
LibraryManagement.main(Array())