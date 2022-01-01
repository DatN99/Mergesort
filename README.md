# Mergesort


src/com/company/Main.java contains my mergesort.
It's a recursive divide and conquer algorithm that sorts an integer array
 
The worst case and average case time complexities are both O(NlogN).
For every recursive call, the array is divided into two halves.
 
For 8 elements, the array would be divided 3 times. However, for each array division,
the algorithm requires that both sides are sorted before merging. Therefore, all elements are being iterated through for each division.
 
For example, if an array with 8 elements were mergesorted, On the first recursive call, it would iterate through 8(log2 8) = 8(3) = 24 elements
 
This is a little hard to understand so here's another way to explain it:
The recurrence relation for mergesort can be described as (time for mergesort) = (time to sort left subarray) + (time to sort right sub array) + (time to merge)
In other words, it can be written as T(n) = T(n/2) + T(n/2) + n which can be simplified to O(NlogN)
 
Compared to quicksort, this algorithm handles better the worst-case scenario. In quicksort, there is no guarantee that
the pivot position will divide the array evenly. If the pivot is too close to either the beginning or end, the sorting
may take up to O(n^2) time.
 
However, mergesort guarantees the array is split evenly for every division.


operations:

print -> prints array

mergesort -> returns sorted array using mergesort given an unsorted (or sorted) array
