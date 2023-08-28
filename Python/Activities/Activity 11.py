fruits_details= {'kiwi': '10',
                 'apple': '20',
                 'banana': '30',
                 'mango': '40'
                 }
fruit_check=input('what fruit do you want?:')
if (fruit_check in fruits_details):
    print('Yes, its available')
else:
    print('Its not available')