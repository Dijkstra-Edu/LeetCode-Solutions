# 👉 Approach 1: Brute Force (Using Sorting)
def getElementsBruteForce(arr):
    n = len(arr)
    if n < 2:
        print("[Brute Force] Second smallest and second largest: -1 -1")
        return

    arr_sorted = sorted(arr)
    print("[Brute Force] Second smallest is", arr_sorted[1])
    print("[Brute Force] Second largest is", arr_sorted[n - 2])


# 👉 Approach 2: Better (Two Traversals)
def getElementsBetter(arr):
    n = len(arr)
    if n < 2:
        print("[Better] Second smallest and second largest: -1 -1")
        return

    small = float('inf')
    large = float('-inf')

    for i in range(n):
        small = min(small, arr[i])
        large = max(large, arr[i])

    second_small = float('inf')
    second_large = float('-inf')

    for i in range(n):
        if arr[i] < second_small and arr[i] != small:
            second_small = arr[i]
        if arr[i] > second_large and arr[i] != large:
            second_large = arr[i]

    second_small = second_small if second_small != float('inf') else -1
    second_large = second_large if second_large != float('-inf') else -1

    print("[Better] Second smallest is", second_small)
    print("[Better] Second largest is", second_large)


# 👉 Approach 3: Optimal (Single Traversal)
def getElementsOptimal(arr):
    n = len(arr)
    if n < 2:
        print("[Optimal] Second smallest and second largest: -1 -1")
        return

    small = float('inf')
    second_small = float('inf')
    large = float('-inf')
    second_large = float('-inf')

    for i in range(n):
        if arr[i] < small:
            second_small = small
            small = arr[i]
        elif arr[i] < second_small and arr[i] != small:
            second_small = arr[i]

        if arr[i] > large:
            second_large = large
            large = arr[i]
        elif arr[i] > second_large and arr[i] != large:
            second_large = arr[i]

    second_small = second_small if second_small != float('inf') else -1
    second_large = second_large if second_large != float('-inf') else -1

    print("[Optimal] Second smallest is", second_small)
    print("[Optimal] Second largest is", second_large)


# ✅ Test Cases
if __name__ == "__main__":
    print("Test Case 1:")
    arr1 = [1, 2, 4, 6, 7, 5]
    getElementsBruteForce(arr1)
    getElementsBetter(arr1)
    getElementsOptimal(arr1)

    print("\nTest Case 2:")
    arr2 = [10, 10, 10]
    getElementsBruteForce(arr2)
    getElementsBetter(arr2)
    getElementsOptimal(arr2)

    print("\nTest Case 3:")
    arr3 = [5]
    getElementsBruteForce(arr3)
    getElementsBetter(arr3)
    getElementsOptimal(arr3)
