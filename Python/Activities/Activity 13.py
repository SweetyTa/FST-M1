def sum(numbers):
    sum=0
    for number in numbers:
        sum+=number
    return sum
numList = [10,20,30,40,50]
result=sum(numList)
print('the sum of all element is:' +str(result))

