# Complete the exercises from the online textbook.

# If doubles are more versatile than ints, why don’t we always use them? Are there any disadvantages to doing this?

-   Memory usage: Doubles take up more memory than ints. This can be a concern in systems with limited memory, such as embedded systems or mobile devices.

-   Performance: Operations on doubles can be slower than those on ints due to the additional precision and range that doubles provide.

-   Precision: While doubles can represent a wider range of values than ints, they may not be precise enough for some applications that require exact precision. For example, financial calculations may require decimal precision, which doubles do not provide.

-   Compatibility: Some programming languages and platforms may not support doubles or may have limited support for them. In these cases, ints may be the only option.

# How much does the memory cost differ between the storing of an address of a 32 entry int array and a 300 entry int array?

The memory cost of storing the address of a 32 entry int array and a 300 entry int array is the same, regardless of the size of the array.

On a 32-bit architecture, the size of a memory address is typically 32 bits, or 4 bytes. This means that the memory required to store the address of an array is constant, regardless of the size of the array.

In contrast, the memory required to store the actual data in the arrays will differ. A 32 entry int array will require 32 integers x 4 bytes per integer = 128 bytes of memory. A 300 entry int array will require 300 integers x 4 bytes per integer = 1200 bytes of memory.

However, the memory cost of storing the address of the arrays themselves is constant and independent of the size of the arrays.

# Complete the exercises from the online textbook.

# Reexplain what the sentinel node is and why it’s important. Ask yourself if your code would error if you removed the sentinel. Is the sentinel a necessary component of your IntList?

Sentinel node is inaccessible node to client and used to avoid special case for empty list which make the implementation consistently.
Yeah. the sentinel node is a necessary component of the IntList because addLast would throw error when appeding a new list to a empty list.

# What is the downside of not having a size variable and rather just calculate the size each time?

The introduction of size varible change the time complexity of size from O(n) to O(1)

# Starting from the copy of SLList.java provided to you in the lecture code repository, implement the method deleteFirst, which deletes the first element in your SLList. Don’t forget to maintain the three invariants discussed above.

// delete the first item in the list
public void deleteFirst() {
size -= 1;
sentinel.next = sentinel.next.next;
}

# Starting from the copy of SLList.java provided to you in the lecture code repository, implement a second constructor that takes in an array of integers, and creates an SLList with those integers. Again, remember to maintain your invariants.

public SLList(int[] x) {
sentinel = new IntNode(63, null);
size = 0;
for (int i = 0; i < x.length; i++) {
addLast(x[i]);
}
}

# If the sentinel node was a null node, would it change anything or would the Intlist be able to function?

If the sentinel node was a null node, the Intlist would not be able to function properly because the null node would not be compatible with the argument n of the IntNode constructor. The IntNode constructor requires an integer value for n, which is used to store the value of each node in the list. A null node does not have a value, and therefore cannot be used to construct a valid IntNode. This would result in a type error being thrown by the compiler.

# Do problem 5 from midterm 1 in Kartik’s textbook

We want to add a method to IntList so that if 2 numbers in a row are the same, we add them together and
make one large node. For example:
1 → 1 → 2 → 3 becomes 2 → 2 → 3 which becomes 4 → 3

````public void addAd jacent ( ) {
    public void addAdjacent() {
        IntList p = this;
        while (p != null && p.rest != null) {
            if (p.first == p.rest.first) {
                p.first += p.rest.first;
                p.rest = p.rest.rest;
            } else {
                p = p.rest;
            }

        }
    }
}```
````

# Modify the Intlist class so that every time you add a value you “square” the IntList. For example, upon the insertion of 5, the below IntList would transform from:

1 => 2 to 1 => 1 => 2 => 4 => 5

and if 7 was added to the latter IntList, it would become

1 => 1 => 1 => 1 => 2 => 4 => 4 => 16 => 5 => 25 => 7

Additionally, you are provided the constraint that you can only access the size() function one time during the entire process of adding a node.

````public void add(int newValue) {
        int finalSize = size() * 2;
        IntList p = this;
        while (p != null) {
            IntList t = p.rest;
            p.rest = new IntList(p.first * p.first, null);
            p.rest.rest = t;
            int size = size();
            if (size == finalSize) {
                p.rest.rest = new IntList(newValue, null);
                break;
            }
            p = p.rest.rest;
        }
    }```
````
