1. What is generic?

Generics enable types to be parameters in methods, classes, and interfaces. This allows for stronger type checks at compile time, which helps eliminate bugs in code and runtime errors. It also eliminates the need for type casting. Generics allows for code to be reused on collections of different types.

3. How we can extend generic class, interface?

When using generics, bounds can be set in the declaration of a class, method, or interface, within the diamonds of the type declaration. Using the naming convention for generics, you can declare type T within the diamonds, followed by extends and then a class name. After the class name you can also add any interface names separated by a comma. This then specifies which types can be used as the type arguments in a parameterized type.

4. What is collection hierarchy?

The collection hierarchy starts with each class being a subclass of Iterable. Then, within the collection hierarchy, there are sets, lists, queues, and then separately there are also maps.

5. What are the differences between Set, List, Queue, Map?

A set is a type of collection where objects are stored without duplicates and in no particular order. A list can have duplicates, and will also maintain an insertion order. Queues work similarly to lists, however they function off of FIFO (first in first out) or LIFO (last in first out) methodology. Lastly a map works similarly to a set, except that objects are stored and referenced using key, value pairs unique to each pairing. 

6. How we can iterate the Map?

You can create an iterator object from your map, and then using a loop, you can use iterator methods such as hasNext() to iterate through each item in a map. 

7. What do you know about collections with Hash?

Collections that use Hash store elements using that element's unique hashCode(). This allows for quick lookup of these elements because each element's hashCode() is unique to that element, and will point directly to the location that the element is stored in the collection. 

8. Why do we need Iterable interface?

Implementing the Iterable interface allows users to be able to move through a collection's elements sequentially. 

9. What is collision? How to handle that?

A collision occurs when two elements of a Hash collection have the same hashCode(). Collisions can primarily be resolved using one of two methods. Chaining is a method that involves using a linked list at the index of the duplicate hashCode(). The values will be stored in the linked list at that index and can be searched through by value. The other method is called open addressing, and this involves searching for a new open index in the table using a probing sequence that will store the value in the new empty index once one is found. 

10. What do you know about threadsafe collections?

It can be very important to implement threadsafe collections because if your code is running multiple threads on collections that share mutable data, then there can be issues when multiple threads try to access and change the same data at the same time. You can make your code threadsafe in several ways, but a few of them would be by either making sure you are using immutable data, or you can use the synchronized keyword that will synchronize your threads.

