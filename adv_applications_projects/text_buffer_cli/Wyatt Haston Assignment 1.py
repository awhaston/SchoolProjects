# Program Name: Wyatt Haston Assignment 1.py
# Course: IT1114/Section 01/W01
# Student Name: Wyatt Haston
# Assignment Number: Lab 1
# Due Date: 01/21/2024
# Purpose: Text based app that shows, modifies, or clears an input buffer
# Resources: Class slides

def main():
    # Declaring input buffer and quit variables
    input_buffer = ''
    quit = False

    # Program event loop checking if quit == True
    while quit != True:
        # Print menu and prompting for user input
        print("Wyatt's String Application\n1: Append data to the input buffer\n2: Clear the input buffer\n3: Display the input buffer\n4: Exit the program")
        user_input = input('Please pick an option (1-4): ')
        
        # If checks on user input
        if(user_input == '1'):
            string_to_add = input('Enter string to append to input buffer: ')
            # Adding user input to input_buffer
            input_buffer += string_to_add
        elif(user_input == '2'):
            # Resetting buffer by setting to empty string
            input_buffer = ''
            print('Buffer cleared')
        elif(user_input == '3'):
            # Checking if input buffer is empty because '' is falsy
            # if not empty show input buffer or write that input buffer is empty
            if(input_buffer):
                print("Current input buffer:", input_buffer)
            else:
                print('Input buffer empty')
        elif(user_input == '4'):
            # Breaking loop if user enters 4
            quit = True
        # Catching all invalid inputs
        else:
            print('ERROR: INVALID INPUT')

        # Putting input to block so that output can be read
        # This only triggers if the input is not 1 or 4 which don't need a confirmation
        if((user_input != '1') and (user_input != '4')):
            input('Press any key to continue')
        

main()