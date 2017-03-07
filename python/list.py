my_list = ["apple", "pear", "orange"]

print(len(my_list))

print(my_list)

my_list.append("banana") #append adds to the list
print(my_list)

my_list.insert(1, "kiwi") #insert method to add string at a specific location
print(my_list)

my_list.remove("banana") #remove method where it tells to remove a stated string
print(my_list)

my_list.extend(["banana", "grapefruit", "lemon"]) # to add multiple strings
print(my_list)

new_list = my_list[0:2] # using slice method to get first two strings
print(new_list)

my_fruit = my_list.pop() #takes the last element

my_eat = my_list.pop(0) #take first element

my_favorite = my_list[0]

print(my_eat) # .pop(0)

print(my_fruit) # .pop()

print(my_favorite)


