tuple1 = tuple(input("Enter tuple numbers seperated by comma ").split(","))
print ("Elements that are divisible by 5 are")
for num in tuple1:
    if int(num)%5==0:
        print(num)