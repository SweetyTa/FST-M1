player1=input('enter 1st player name:')
player2=input('enter 2nd player name:')
player1_answer=input(player1 + ": Rock, paper or scissors?:").lower()
player2_answer=input(player2 + ": Rock, paper or scissors?:").lower()
if (player1_answer == 'rock') & (player2_answer=='scissors'):
    print("rock wins")
elif (player1_answer == 'scissors') & (player2_answer=='paper'):
    print('scissors wins')
elif (player1_answer == 'paper') & (player2_answer=='rock'):
    print("paper wins")
else:
    print("invalid input")





