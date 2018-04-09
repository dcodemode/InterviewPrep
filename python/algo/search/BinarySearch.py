from __future__ import print_function

class BinarSearch(object):

    #Iterative Binary Search on Arrays
    def search1(self, array, x):
        left = 0
        right = len(array) - 1

        while(left <= right):
            mid  = left + (right - left) / 2
            if(array[mid] == x):
                return mid
            elif(array[mid] < x):
                left = mid + 1
            else:
                right = mid - 1
        return -1

    # Binary Search Recursive
    def search(self, array, x, left, right):
        if(left > right):
            return -1

        mid = left + (right - left) / 2

        if(array[mid] == x):
            return mid
        elif(array[mid] < x):
            return self.search(array, x, mid + 1, right)
        else:
            return self.search(array, x, left, mid -1)

if __name__ == '__main__':

    b = BinarSearch()
    array = [1, 2, 4, 5, 6, 7, 9]

    #Iterative
    print(b.search1(array,0))

    #Recursive
    print(b.search(array, 0, 0, len(array)-1 ))
