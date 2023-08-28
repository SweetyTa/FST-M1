a = [1,2,3,4,5,6]
b = [10,20,35,67,50]
new = []
for num in a:
    if ((num % 2) != 0):
        new.append(num)
for num in b:
    if ((num % 2 ) == 0):
        new.append(num)

print ("new list is: " , new)




