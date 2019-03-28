# -*- coding: utf-8 -*-

import json
import sys
import platform
reload(sys)
sys.setdefaultencoding('utf-8')

def quickSort(in_list,in_start,in_end):
    i,j = in_start,in_end
    key_value = in_list[i]


    while (i<j):
        while (i < j and in_list[j] >= key_value):
            j = j - 1
        in_list[i] = in_list[j]

        while (i < j and in_list[i] <= key_value):
            i = i + 1
        in_list[j] = in_list[i]

    in_list[i] = key_value
    
    print str(in_start) + '|' + str(i-1) + '|' + str(i+1)
    quickSort(in_list,in_start,i-1)
    quickSort(in_list,i+1,in_end)
    
    return in_list


if __name__ == "__main__":
    list_num = [6,1,4,9,2,5,8,7,10,2,3,12]
    list_result = quickSort(list_num,0,11)
    print list_num



def QuickSort(arr,firstIndex,lastIndex):
    if firstIndex<lastIndex:
        divIndex=Partition(arr,firstIndex,lastIndex)
 
        QuickSort(arr,firstIndex,divIndex)       
        QuickSort(arr,divIndex+1,lastIndex)
    else:
        return
 
 
def Partition(arr,firstIndex,lastIndex):
    i=firstIndex-1
    for j in range(firstIndex,lastIndex):
        if arr[j]<=arr[lastIndex]:
            i=i+1
            arr[i],arr[j]=arr[j],arr[i]
    arr[i+1],arr[lastIndex]=arr[lastIndex],arr[i+1]
    return i
 
 
arr=[1,4,7,1,5,5,3,85,34,75,23,75,2,0]
 
print("initial array:\n",arr)
QuickSort(arr,0,len(arr)-1)
print("result array:\n",arr)