I couldn't have front end done as I had to install some softwares like (NodeJs, NPM etc) in order for me to be able to get Angular working.
but coz I'm using work laptop in order for me to install something on it I need Admin right and I need to explain to my manager why I need admin right 
so that why I couldn't done front end .


Back-end is done 
---Instructions on How to Test ---
1.On com.books.bookStoreApplication.bootsrapApp.ReadXmlData class line(38) you will see that where I read the xml 
  you will just need to place that xml on your own preferable folder and just copy the path and put it in that class.
2 when done with above you just need to run your application and go and check your H2 dabase(http://localhost:8080/h2-console)
  you will see that tables are created and data is populated.
3.you will need a tool like Postman to test my rest service and you can test all CRUD is working.

to Create a Book you will use this url(http://localhost:8080/book/createBook)
and below body structure 

{
        
"category": "",
        
"title": "",
        
"year": "",
        
"price":"",
        
	"authors": [
            
	    {
                
		"author": ""
            
      }
]

}



To get a Book and it's Athor(s) by Category use this URL(http://localhost:8080/book/category/cooking)
To Delete a Book you need this url (http://localhost:8080/book/deletebook/put a bookID here(e.g 1) )
To find a Author by it's ID you need this url(http://localhost:8080/author/findbyid/put a bookID here(e.g 1))
to Get All Books you need this url (http://localhost:8080/books/getAllBooks)