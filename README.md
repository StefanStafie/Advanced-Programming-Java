#### Advanced-Programming-Java

# Lab 3

The classes Book, Food and Weapon should implement the interface Item.
   When printing a Knapsack with Knapsack.print, items are ordered according to name.
   Greedy and Dynamic are 2 classes that implement the Algorithm interface with the **solve** method.
   ProblemGenerator class creates Item[] objects randomly with a chosen number of items.
   The results of tests are as follow:


**10000 iterations on each test**

pairs: dynamic--greedy


capacity 500, itemCount 500 : 

	avg value:  	2501.794638376264  2470.371865336172
   	avg time:     	6.3644  0.2276

capacity 50, itemCount 50:

    avg value 	235.71401113725702  208.18711464508496
	avg time: 	0.0735  0.0192

Capacity 1000, itemCount 15: 	

    avg value  	787.7506059869218  787.7501364038869
	avg time  	0.5299  0.0053

Capacity 15, itemCount 1000:
        
 	avg value	488.1674715302053  465.9094789124492
    avg time	0.3442  0.3938



# Lab4

The Compulsory part can be viewed by uncommenting "//Compulsory compulsory = new Compulsory();" in Main

Problems are generated using ProblemGenerator. The number of hospitals and residents to be generated are given as parameters. The names are generated using Faker class (https://github.com/faker-ruby/faker)

A possible Matching is created using Algorithm on a Problem

For checking the corectness of Matching, use CheckStable;


# Lab5

Uploaded--
Implemented save, load and view; 

Optional:
    
    -Save and load using txt files. (in JSON format)
    -Classes for each Command (ListCommand, LoadCommand, ViewCommand, ReportHtmlCommand) that implement the interface Command
    -created shell (input "help" for command list)
    -ability to create catalog, add documents and tags to documents
    -report html creates index.html in current directory
    -created executable JAR

# Lab6

    Support for 3 Shapes (Rectangle, Circle, RegularPolygon).
    The configuration panel adapts to the current Shape.
    Support for 3 colors (Red, Green, Blue).
    Support for saving and loading the image to disk using a file chooser.
    Support for reset and exit.
To refresh canvas and configPanel, click on canvas after every change.

# Lab7
No update for Lab7

    The game plays itself in initialisation ( new Game(playerCount, tokenCount, progressionSize); )
    A thread is created for each Player.
    Each player takes progressionSize tokens from the Board (using getToken()). Then, he exchanges tokens (1 player token with 1 board token, using exchangeToken() ) until the player has a progression.
    Both getToken() and exchangeToken() are synchronised methods so that the players don't clash when they take tokens. After a token is taken from the board, it is removed from the list of tokens available in the board.
    A player may only keep progressionSize Tokens in hand.
    When a player obtains a progression, the main thread stops all other player threads (killing it softly) and prints the winner.

No update for Lab7 ^^^^^^

# Lab8

    The database is created using MySql and is hosted by localhost phpmyadmin. To use:
    - choice 1: copy the musicalalbums folder to your C:\xampp\mysql\data
    - choice 2: use musicalalbums.sql to create the database on your system.
 
- The Test class inserts 3 rows in artist table and 3 rows in album table using create(). Then uses findByName() and findByArtist() to return a result set and and print on screen.
- ArtistController, having the methods create(String name, String country) and findByName(String name):return ResultSet
- AlbumController, having the methods create(String name, int artistId, int releaseYear) and findByArtist(int artistId):return ResultSet
- Database class is a Singleton. Has Statement and Connection variables.