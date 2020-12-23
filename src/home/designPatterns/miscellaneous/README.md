## Design patterns implementation exercise

#### Design patterns used here:
+ Strategy
+ Observer
+ Command
+ Prototype

-------------------------------------------

#### Exercise Description:
 
A **client** class generates random data (Generator), for example a set of numbers, in a certain range. This set of numbers is encapsulated in a 
"Command", which is a sort of data structure that integrates a set of parameters in an inter-exchangeable object. 

The client randomly generates commands, at a specified pace. The **Receiver** receives the command at the moment it is sent via the **Observer** 
pattern. This way the client doesn't need to be listening for an event all the time, but gets notified whenever there is a new command waiting to 
be executed.

The **Command** is then passed to a decider class, which decides the strategy to be applied when processing the received command. Every action 
taken is based on a random choice. The **Decider** is a class that switches states according to the mathematical properties of the set of numbers
in input. This set of rules must be specified in the code and is static, never changing. The Strategy pattern is used in the Decider class, since it 
will switch between its possible states dynamically. It also executes the action defined in the Command object received.

The set of possible **Strategies** should be implemented in the code, so that it can be expanded easily without the need of coding everything again.

Every object passed to the recipient class is **cloned** using the Prototype design pattern. The duplication serves for storing copies of the 
command objects for a later retrieval, without losing any important data.

-------------------------------------------

#### Exercise Objectives:

**The purpose of this exercise** is to use multiple design patterns and make them collaborate dynamically, while maintaining the code in order and 
allowing ease of code expansion. The classes should be structured so that adding new Strategies, or making new types of Command objects (with 
different parameters) should be straight-forward, while avoiding coding unnecessary classes and avoiding redundant calls in every structure.

