def fibonacci(n):
    if n<=1:
        return n
    else:
        return (int(fibonacci(n-2)) + int(fibonacci(n-1)))
    
       
num=int(input("Enter the number "))
print ("The fibonacci series is ")
for i in range(num):
        print(fibonacci(i))