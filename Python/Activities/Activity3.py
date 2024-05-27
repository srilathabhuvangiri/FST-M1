user1 = input('Enter user1 name: ')
user2 = input('Enter user2 name: ')

user1Choice = input(user1 + ", do you want to choose rock, paper or scissors?").lower()
user2Choice = input(user2 + ", do you want to choose rock, paper or scissors?").lower()
print('user1Choice'+user1Choice)
print('user2Choice'+user2Choice)
if user1Choice == user2Choice:
    print("Its a tie")
elif user1Choice=='rock':
    if user2Choice=='paper':
        print("paper wins")
    else:
        print("rock wins")
elif user1Choice=='paper':
    if user2Choice=='scissors':
        print("Scissors wins")
    else:
        print("paper wins")
elif user1Choice=='scissors':
    if user2Choice=='rock':
        print("rocks wins")
    else:
        print("scissors wins")        	
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")
