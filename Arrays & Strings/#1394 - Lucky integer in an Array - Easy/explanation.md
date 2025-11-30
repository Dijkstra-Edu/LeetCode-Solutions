### What this code is logically doing

- Declares three variables at the start of the method:  
  - `temp` is used as a temporary holder for the current array element being analyzed in the outer loop.  
  - `lucky` starts at `-1` and is meant to store a “special” value if the condition in the loop is ever satisfied; if it is never updated, `-1` is returned to indicate “no such value found”.  
  - `count` keeps track of how many times the current `temp` value occurs in the array during each pass of the inner loop.  

- Uses a nested loop structure to count frequencies:  
  - The outer loop `for (int i = 0; i < arr.length; i++)` picks each element `arr[i]` one by one and assigns it to `temp`, then resets `count` to `0` for that new value.  
  - The inner loop `for (int j = 0; j < arr.length; j++)` scans the entire array from start to end and compares every `arr[j]` with `temp`; whenever a match is found, `count` is incremented, so by the end of the inner loop `count` equals the total number of occurrences of `temp` in the array.  

- After finishing the inner loop for a given `temp`, it evaluates `if (count == arr.length)`:  
  - This condition checks whether the current value `temp` appears exactly as many times as the total number of elements in the array, which effectively means: “Is every element in the array equal to `temp`?”.  
  - If this condition is true, the code sets `lucky = temp`, so `lucky` is updated to this value for that iteration.  
  - Because this check happens for every `i`, if the condition becomes true multiple times (for example, when all elements are the same), `lucky` will be reassigned each time, and the value ultimately returned from the function will be the value from the **last** outer-loop iteration where `count == arr.length` held true, determined purely by the order of elements in the array.  
