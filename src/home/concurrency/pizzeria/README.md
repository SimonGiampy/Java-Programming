## Pizzeria Napoletana

The purpose of this exercise is to make different threads operating separately but collaborating with each other. Every
thread exchanges information with others and once a thread finishes its work, it terminates the execution.

#### Pizzeria Workflow Design
> This is a representation of a Pizzeria workflow. In the pizzeria there are pizzaioli, who make pizzas, and clients, who
> make orders. Each order is composed of one or more pizzas, served in cardboard boxes. The clients must choose the pizza
> from the menu, without the possibility of modifying the toppings on the pizza. Once the order is made, it can't be
> changed. The pizzeria's policy of serving the orders is FIFO (First In - First Out). So the client who ordered before 
> the others will be served first. The time taken by a pizzaiolo to make the pizza depends on the type of pizza. And the
> time taken to complete the order made by a client depends on the number of pizzas that the client ordered. Also, in
> order to complicate things even more, the simulation of this pizzeria includes only one wood oven, which can cook 
> maximum 5 pizzas at a time. If a pizzaiolo needs to put his pizza in the oven, but the oven is full, then he waits, and
> in the meantime, he prepares other pizzas. A pizzaiolo can have a maximum of 4 pizzas at a time, waiting to be cooked
> in the oven. All the pizzaioli make pizzas independently of each other. The pizzeria takes an order at a time and
> assigns it to one pizzaiolo, that is chosen based on how busy he is. The maximum number of pizzas that an order can
> have is 4 (this limit is set for simplicity purposes). 
<hr>

> The number of pizzaioli present in the pizzeria depend on the initial user input. After this input the simulation of
> pizzeria starts, and finishes after a certain amount of time has passed. Once the time has expired, then the pizzaioli
> finish serving the last pizzas. Then the pizzeria closes and shows the final statistics.
> In order to handle random timed events, insert a time multiplier for every action taken in the pizzeria, so everything 
> can be sped up or slowed down according to the number of pizzas served and the type of testing.
> At the end, the program shows some basic statistics, like the number of clients served, the money earned, the number
> of pizzas prepared, and the average of pizzas ordered by the clients.
<hr>

> Nice possible additions: expand the menu with more pizzas. The menu works like a database from which the clients can
> choose their pizzas. Each entry in the menu contains the name, price, and time needed to be prepared. Heavier pizzas
> take longer than simple ones to be prepared. This is used as variation in the workflow and multi threading load.


#### Code Implementation and Multi-Threading techniques:
> try to figure out a way of implementing this 

_Side note: the word "pizzaiolo" in italian is translated as "pizza chef" or "pizza maker" in english, and if I find it 
so horrible, that I refuse to translate this word into english. It stays in italian. Damn british people._