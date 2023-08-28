import pandas

# Structure our data as a dictionary
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

# Create a new DataFrame using the data
dataframe = pandas.DataFrame(data)

# Write the data to a csv file
dataframe.to_csv("../Resources/activity_17.csv")