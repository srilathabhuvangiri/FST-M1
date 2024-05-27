listOne =[2,4,3,1,2,4,6,7]
listTwo =[2,3,5,6,7,5,7,3,1]
print ("List One number : ", listOne)
print ("List Two number : ", listTwo)

thirdlist=[]

for i in listOne:
    if(i%2 == 0):
        thirdlist.append(i)

for j in listTwo:
    if(j%2 != 0):
        thirdlist.append(j)    

	
print("result List is:")
print(thirdlist)            