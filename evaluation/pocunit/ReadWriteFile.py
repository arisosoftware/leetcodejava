# https://www.pythonforbeginners.com/files/reading-and-writing-files-in-python


file = open(“testfile.txt”,”w”) 
 
file.write(“Hello World”) 
file.write(“This is our new text file”) 
file.write(“and this is another line.”) 
file.write(“Why? Because we can.”) 
 
file.close() 


file = open(“testfile.text”, “r”) 
print file.read() 


file = open(“testfile.txt”, “r”)
 
print file.read(5) 
