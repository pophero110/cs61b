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
