user1 = input("Enter User1 name ")
user2 = input ("Enter User2 name ")

userinput1 = input("Enter User1 input- Rock,Paper or Scissors ").lower()
userinput2 = input ("Enter User2 input-Rock,Paper or Scissors ").lower()

if userinput2== userinput1:
    print("Its a tie")

elif userinput1 == "rock" and userinput2 == "scissors":
    print(user1, "won the game")

elif userinput1 == "rock" and userinput2 == "paper":
     print(user2, "won the game")

elif userinput1 == "paper" and userinput2 == "scissors":
    print(user2, "won the game")

elif userinput1 == "paper" and userinput2 == "rock":
     print(user1, "won the game")

elif userinput1 == "scissors" and userinput2 == "rock":
    print(user2, "won the game")

elif userinput1 == "scissors" and userinput2 == "paper":
     print(user1, "won the game")

else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.") 