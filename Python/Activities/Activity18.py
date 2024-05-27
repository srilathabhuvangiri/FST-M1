# Import pandas
import pandas

dataframe = pandas.read_csv("sample.csv")
# Print the full data
print("Full Data: ")
print(dataframe)

# Print the values in the Usernames column only
print("===============")
print("Username:")
print(dataframe["Username"])

# Print the username and password of the second row
print("===============")
print("Username: ", dataframe["Username"][1], " | ", "Password: ", dataframe["Password"][1])

#Sort the Usernames column in ascending order
print("====================================")
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Username'))

#Sort the Passwords column in descending order
print("====================================")
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Password', ascending=False))