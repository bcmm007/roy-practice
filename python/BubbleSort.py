def insertSort(in_list):
    for i in range(len(in_list)-1):
        for j in range(len(in_list)-1-i):
        	if in_list[j] > in_list[j+1]:
        	    in_list[j],in_list[j+1] = in_list[j+1],in_list[j]

    return in_list
if __name__ == "__main__":
    list_num = [6,1,4,9,2,5,8,7,10,13,3,12]
    list_result = insertSort(list_num)
    print(list_result)