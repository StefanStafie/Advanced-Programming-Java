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
