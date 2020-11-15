## Dance Floor: exercise explanation
>
#### English explanation of this exercise and its implementation:
> Consider a Java class called Dance Floor. In this dance floor there are dames and gentlemen who dance together. Their
> behavior is randomly updated and follows a cycle. The following is the description of the behavior of the ballet 
> participants.
>
> Dames: a dame is identified with a number. Its cycle of execution starts with them waiting for a gentleman to dance with.
> A dame is waiting until there is a gentleman who asks for a waiting dame, so they can start to dance. When the gentleman
> gets fed up with the dame, he dumps her, so she goes in crisis. A dame can get out of the crisis only if she finds
> another dame, so they get out of the crisis together and become available and waiting for a new gentleman.
>
> Gentlemen: a gentleman dances with a dame for a random time, then gets tired of dancing always with the same dame, and
> goes in crisis. He stays in crisis for a random time, then gets lonely. When he gets lonely, after a random time he asks
> for a new dame to dance with, and the Dance Floor handles the requests and chooses a random dame from the ones waiting.
> 
> The ballet goes on infinitely, as long as the user doesn't stop the execution. The number of dames and gentlemen is 
> defined in the Starter class.
>
#### Code Implementation:
> DanceFloor class handles all the requests from the gentlemen and moves the dames around. Each gentleman is a running 
> instance of a Runnable interface, so every gentleman is handled by its own thread. All threads start simultaneously,
> but their behavior changes after a random time of execution. The dames are listed in arraylists, so they can be swapped 
> of their stage easily by the DanceFloor class. The methods of DanceFloor can't be stopped and need different threads to
> interact with it, so the dames can be distributed correctly.

[Professor's Github Repository](https://github.com/MattiaSalnitri/SE_01_introJava)