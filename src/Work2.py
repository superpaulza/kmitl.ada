import random

def Random(arr, n):
    for x in range(0, n):
        arr.append(random.randint(0, 50))

def MinMax(arr, n):
    if n == 2:
        if arr[0] > arr[len(arr)]: return (arr[0], arr[len(arr)])
        else: return (arr[len(arr)], arr[0])
    else:
        m = int(round(len(arr)/2,2))
        (max1, min1) = MinMax(arr[0:m-1], n/2)
        (max2, min2) = MinMax(arr[m:len(arr)-1, n/2])
        if max1 > max2: max = max1
        else: max = max2
        if min1 < min2: min = min1
        else: min = min2
        return (max, min)

arr = []
Random(arr, 100)
arr[0] = 9
arr[99] = 9
MinMax(arr, 100)