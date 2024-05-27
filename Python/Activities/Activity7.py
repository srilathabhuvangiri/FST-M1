# static list
my_list =[1,4,5,3,6,7]
print(my_list)
temp = 0
for i in my_list:
    temp+=i
    print(i)
print("Sum of all elements in list",temp)


#read list from consloe
my_list1 =list(input("Enter the numbers to a list :").split(", "))
print(my_list1)
temp1 = 0
for i in my_list1:
    temp1+=int(i)
    print(i)
print("Sum of all elements in list",temp1)