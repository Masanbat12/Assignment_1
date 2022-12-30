# Assignment_1
## Assignment_1_oop
### Observer Design Pattern
The observer design pattern is a software design pattern so an object that has a list of dependents that named
observers, that are notifying's on the spot on any changes that been in the progran and update the status of it immediately,
by using on one of the methods that been called.
### Introduction
In this assignment we were asked to create a system of messages that is sent to all the members of the group,
That are registered in the group,the creation of the class of the message system is used by an ArrayList,
to save all the members of the group, who could receive the messages that were sent.
ArraysList :Resizable-array implementation of the List interface.
Implements all optional list operations, and permits all elements, including null.
In addition to implementing the List interface, 
this class provides methods to manipulate the size of the array that is used internally to store the list. 
All the functions in the Sender class is applied in GroupAdmin class. 
They are methods that we received from the undoableStringBuilder class from assignment_0.
Most were in task number 0, which had to to be implemented in UndoableStringBuilder class,
and actually the GroupAdmin class is inherited those methods.
One of the featurs in the ConcreteMember class is to update and print all of group members in the list.
(we also could use in the ConcreteMember with an heap, that is data structure that holds
the all the members and the update data that is done.
So it we can use this data structure so the last data will come out (by peek order), 
and used toString function for print the data.)
All the clients who are registered in the group are updated in the message that exists in the GroupAdmin class,
so it creates a situation where all the members of the group are updated.
The significant function of the project is notifylistOfFriends which updates each of the participants with the message,
so that all participants can see the messages sent in the group.
We used methods that getting object as:
### in GroupAdmin class:
    //methods to register and unregister observers
    void register(observer.Member obj);
    void unregister(Member obj);
    //Inserts the string into this character sequence.
    void insert(int offset, String obj);
    // Appends the specified string to this character sequence.
    void append(String obj);
    // Removes the characters in a substring of this sequence.
    void delete(int start, int end);
    // Erases the last change done to the document, reverting
    // it to an older state.
    void undo();
 ### in ConcreteMembers class:
     //Method to use to update the program to a
     //changes that had been done on clients.
    public void update(UndoableStringBuilder usb)
    // Method to print the information to the string.
    public String toString();
  #### Tests:
  In this class's we test our program by the size of the object in memory using the JvmUtilities class that was given and its methods.


