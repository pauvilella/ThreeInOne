# ThreeInOne
Exercise related with Stacks and Queues.

## Exercise Challenge
Describe how you could use a single array to implement three stacks.

### Solution
I have implemented a single array, and the elements of the three stacks are in the same array.
The elements of the first stack are going to be at indexes; 0, 3, 6, 9, etc. The elements of the second stack are going to be in 1, 4, 7, etc. and so on. 
So I have an offset of 3 (because there are 3 stacks). This is a good implementation because the arrays haven't fixed length and, if some array has much more elements than other, it's handled appropriate. 
We are only limited to the length of the array, but this can also be solved by resizing the array when needed.