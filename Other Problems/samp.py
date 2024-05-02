def partition(myList):
    lenLeftSubset=1
    lenRightSubset=len(myList)-1
    indexRightSubset=1
    leftSubset=myList[0]
    rightSubset=0
    print("leftsubset=", leftSubset)

    for i in range(1, len(myList)):
        rightSubset+=myList[i]

    # print("rightsubset=", rightSubset)
    resultIndexes=[]
    
    for i in range(1, len(myList)):
        if(leftSubset/lenLeftSubset==rightSubset/lenRightSubset):
            resultIndexes.append(i-1)
            resultIndexes.append(i)
            indexRightSubset=i
            break
            
        else:
            leftSubset+=myList[i]
            lenLeftSubset+=1
            rightSubset-=myList[i]
            lenRightSubset-=1

    if(len(resultIndexes)==0):
        print(-1)
    print("Left subset: ")
    for i in range(0, lenLeftSubset):
        print(myList[i], end=", ")

    print("")

    print("Right subset: ")
    for i in range(indexRightSubset, len(myList)):
        print(myList[i], end=", ")

myList=[6,3,3, 8,2,2]
partition(myList)