Leaves and Wombats
==================
        
This scenario is part of the book 

    "Introduction to Programming with Greenfoot"
    by Michael Kolling
    ISBN: 0-13-603753-4

This scenario is discussed in detail in that book.

Copyright (c) Michael Kolling. Some rights reserved.

USER INSTRUCTIONS:
You'll need to add some wombats before anything happens. Right-click
the wombats class to instantiate new wombats. You can also add leaves
to the world for the wombats to eat.

EXERCISES THAT I DID
Exercise 1
Open up your Wombat program again.
Modify a wombat such that it is able to count the number of steps taken. You can do that by adding an instance variable to a wombat, and increase this variable every time a step is taken. Test.

Exercise 2
Modify a wombat such that it can only take 50 steps during its lifetime. When a wombat has taken 50 steps, it must disappear. A hint is that an object can remove another object by executing the following:

getWorld().removeObject(anObject);
where anObject refers to the object that must be removed. The reserved word this refers to the object in execution.

Exercise 3
Modify a Wombat so the following rules are complied:

When a Wombat is born it can take 50 steps without eating any leaves.
Every time it eats a leaf, it may take another 25 steps.

Exercise 4
As it is now a wombat cannot pass a stone. Modify a Wombat so that it can!
Modify a Wombat so that it can eat a stone-shared field.
But it is a hard diet! That is, it costs five leaves to eat a stone!
