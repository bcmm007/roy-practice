def insertSort(in_list):
    i = 1
    j = 0
    while i < len(in_list):
    	if in_list[i] < in_list[i-1]:
            j = i-1
            temp = in_list[i]
            while j>=0 and in_list[j] > temp:
                in_list[j+1] = in_list[j]
                j = j -1
            in_list[j+1] = temp
        i = i + 1


    return in_list
if __name__ == "__main__":
    list_num = [6,1,4,9,2,5,8,7,10,13,3,12]
    list_result = insertSort(list_num)
    print list_result