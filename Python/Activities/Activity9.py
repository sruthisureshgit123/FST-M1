list1 = list(input ("Enter list1 numbers seperated by comma ").split(","))
list2 = list(input ("Enter list2 numbers seperated by comma ").split(","))
list3 = []
for num in list1:
    if int(num)%2==0:
        list3.append(num)
for num in list2:
    if int(num)%2!=0:
        list3.append(num)
print ("Result Set is ",list3)