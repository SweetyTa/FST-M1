import pandas
dataframe = pandas.read_excel("../Resources/activity19.xlsx", sheet_name="Sheet1")
print(dataframe)
print("Number of rows and columns: ", dataframe.shape)
print("Emails: ", (dataframe['Email']))
print("Sorted data: ", dataframe.sort_values('FirstName'))