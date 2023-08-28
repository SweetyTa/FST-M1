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

repeat_game=input('Do you want to play one more round? ')
if(repeat_game == "yes"):
    print('Game starts once again')
elif(repeat_game=="No"):
    print('Game is over')
    raise SystemExit
else:
    print('Invalid input, closing the game')
    raise SystemExit




