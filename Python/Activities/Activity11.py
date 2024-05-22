	
fruit_shop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}

search= input("Enter the fruit name to know the price ").lower()

if(search in fruit_shop):
    print("Yes, this is available")
    print("Price is",fruit_shop[search])
else:
    print("No, this is not available")
