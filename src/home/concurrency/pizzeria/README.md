## Pizzeria Napoletana

The purpose of this exercise is to make different threads operating separately but collaborating with each other. Every
thread exchanges information with others and once a thread finishes its work, it terminates the execution. Every thread
has its own priority of execution, and exchanges information with the main thread (Pizzeria) and with other threads.
The main goal of this little project is to understand how multi-threading programming works in java, and learn how to
implement data structures and synchronization techniques (low and high level) in order to get the desired parallelization.

A description of the exercise and its implementation follows.

#### Pizzeria Workflow Design

This is a representation of a Pizzeria workflow. In the pizzeria there are pizzaioli, who make pizzas, and clients, who
make orders. Each order is composed of one or more pizzas, served in cardboard boxes. The clients must choose the pizza
from the menu, without the possibility of modifying the toppings on the pizza. Once the order is made, it can't be
changed. The pizzeria's policy of serving the orders is FIFO (First In - First Out). So the client who ordered before 
the others will be served first. The time taken by a pizzaiolo to make the pizza depends on the type of pizza. And the
time taken to complete the order made by a client depends on the number of pizzas that the client ordered. Also, in
order to complicate things even more, the simulation of this pizzeria includes only one wood oven, which can cook 
maximum 5 pizzas at a time. The time taken for a pizza to be cooked in the oven is constant and equal for all kinds of
pizza. If a pizzaiolo needs to put his pizza in the oven, but the oven is full, then he waits until the oven has a free
spot, while in the meantime, he prepares other pizzas. A pizzaiolo can have a maximum of 4 pizzas at a time, already 
prepared and waiting to be cooked in the oven. All the pizzaioli make pizzas independently of each other. 
The pizzeria takes one order at a time and assigns it to one pizzaiolo, that is chosen based on how busy he is. The 
maximum number of pizzas that an order can have is 4 (this limit is for simplicity purposes). 
<hr>

The number of pizzaioli present in the pizzeria depend on the initial user input. Also the clients "spawing" rate can be
defined by the user input, this way, the threads can be stressed differently accoring to the workload required. 
After this input the simulation of pizzeria starts, and finishes after a certain amount of time has passed. Once the time 
has expired, then the pizzaioli finish serving the last pizzas. After that, the pizzeria closes and shows the statistics
calculated. In order to efficiently handle random timed events, there is a time multiplier for every action taken in the
 pizzeria, so everything can be sped up or slowed down according to the number of pizzas and clients being served. This
 is also useful for testing and debugging the program, especially for seeing the orders handling in real time. The time
 multiplier is a constant value defined for specific actions (like cooking in the oven, or the pizza preparation time)
 and indicates the time factor expressed in milliseconds. The time factor is the time unit for a certain action, or, in
 other words, the amount of time a certain action needs in order to be completed.
<hr>

#### Serving priority and Client Satisfaction

Every client gets an assigned serving priority, randomly generated, according to a weight. The proportion of high priority
serving clients present simultaneously in the pizzeria, compared to the number of low priority customers in the pizzeria,
must be adjusted so that there aren't many prioritized clients and few non prioritized. At a certain time, the number of 
non prioritized clients should be at least triple the number of high priority clients. 
Also, every client adds a tip to the money paid for the order. The tip calculation is based on factors like:
- how much money the order costs
- how much time the client waited before being served
- how many other clients are present in the pizzeria at the same time
- how many clients are waiting for their order
This way, if a client waits too much time compared to the time it takes to cook all the pizzas, tips zero or few money. 
Instead, if a client gets served quite fast, the tip increases. 

<hr>

The satisfaction factor is a sort of 5 start based review system, which takes into account the speed of service. Every 
client, after being served does three things:
- pays the order, and the pizzeria receives the money
- adds a tip according to the serving time
- leaves a review for the pizzeria, based on the serving time

<hr>

#### Statistics calculated after a simulation finishes

- Number of clients to be served
- Average of pizzas served for a client
- Money earned through payments and tips
- Average time taken for serving a client
- Average waiting time for a client
- Average client satisfaction: the pizzas cooking time compared to the time taken to complete the order and serve the client
- Average client tipping

<hr>

#### Code Implementation and Multi-Threading techniques:

Every Client is handled by a thread, whose execution depends only on by the Pizzeria Class, which takes care of the orders
management. The Pizzeria is the main thread, which assigns each client to a pizzaiolo. The pizzaiolo takes the order created
by the client and completes it. Since every client has its own priority, the Pizzeria prioritizes the clients with the 
highest serving priority. Gennaro is the class which task is to randomly generate ("spawn") the clients. Once a client is
generated, it creates an order (in which the pizzas are chosen randomly), and the pizzeria handles it immediately. 
The Pizzaiolo class is a thread that runs from the beginning, until all the orders have been completed, and is terminated 
only when the pizzeria closes. During the execution, all the classes collaborate and send information to the Statistics 
class, which gathers all the data and calculates the interesting values and statistics of the simulation. 
The menu is an enumeration that acts like a database from which the clients can choose their pizzas. Each entry in the
 menu contains the name, price, and time needed to be prepared. Heavier pizzas take longer than simple ones to be 
 prepared. This is used as variation in the workflow and multi threading workload.

<hr>

> _Side note: the word "pizzaiolo" in italian is translated as "pizza chef" or "pizza maker" in english. I find it 
> so horrible, that I refuse to translate this word into english. It stays in italian. Damn british people._