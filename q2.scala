object LibraryManagement {


    case class Book( title: String, author: String, isbn:String)

    var library: Set[Book] = Set(

    Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"),
    Book("1984", "George Orwell", "9780451524935"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565")

  )

    def addBook(book:Book):Unit = {

         library += book
            println(s"Book '${book.title}' added to the library.")

         }

    def removeBook(isbn:String):Unit = {

        val initialSize = library.size

        library = library.filterNot(_.isbn==isbn)

        if(library.size < initialSize) {

            println(s"Book with ISBN '$isbn' removed from the library.")
        } else
    
        {
            println(s"No book with ISBN '$isbn' found in the library.")
        }
     }

    def isbookInLibrary(isbn:String):Boolean = {
        library.exists(_.isbn == isbn)
     }
    

    def displayLibrary():Unit = {

        println("Current Library Collection:")

        library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    }

    def searchBookbyTitle(title:String): Unit = {

        library.find(_.title.equalsIgnoreCase(title)) match {

            case Some(book) =>  println(s"Found Book - Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
            case None => println(s"No book with title '$title' found in the library.")
        }

    }

    def displayBooksByAuthor(author:String): Unit = {
        val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))

        if(booksByAuthor.nonEmpty)
        {
            println(s"Books by Author '$author':")
            booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))

        }

        else {

                println(s"No books by author '$author' found in the library.")
        }

    }

    def main(args:Array[String]) : Unit = {

        displayLibrary()

        val newBook = Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488")

        addBook(newBook)

        removeBook("9780451524935")

        println(s"Is book with ISBN '9780316769488' in the library? ${isbookInLibrary("9780316769488")}")

        displayLibrary()

        searchBookbyTitle("The Great Gatsby")

        displayBooksByAuthor("Harper Lee")
    }




}