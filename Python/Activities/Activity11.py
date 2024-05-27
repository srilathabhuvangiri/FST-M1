friuts = {"apple": 10,"banana": 20,"orange": 15,"mango": 16,"pipeapple": 7}

key_to_check = input("What are you looking for? ").lower()
 
if(key_to_check in friuts):
    print("Yes, this is available")
else:
    print("No, this is not available")