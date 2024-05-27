import pandas

#create Dictionary
data = {
  "Username" : ["admin", "srilatha", "saanvi"],
  "Password" : ["password", "password1", "password123"]
}

# Create a DataFrame using that data
dataframe = pandas.DataFrame(data)

# Print the DataFrame
print(dataframe)

dataframe.to_csv("sample.csv", index=False)