# Program Name: Wyatt Haston Assignment 3.py (use the name the program is saved as)
# Course: IT1114/Section 01/W01
# Student Name: Wyatt Haston
# Assignment Number: Lab 3
# Due Date: 02/04/2023
# Purpose: GUI based app that converts Miles per Gallon to Kilometers per Liter when they type. Also handles non number cases.
# Resources:
# https://www.tutorialspoint.com/python/python_gui_programming.htm
# https://www.geeksforgeeks.org/python-gui-tkinter/

from tkinter import *

# Initializing window
root = Tk()
root.title('Wyatt Haston Assignment 3')
    
# Function that runs every time the user_input changes
def onChange(str1, str2, str3):
    input_text = user_input.get()

    # Resets output if input is empty
    if(input_text == ''):
        output_var.set('')
        return
    
    # Try to convert to a float, if it fails remove the last character
    try:    
        input_float = float(input_text) 
        calculateKPL(input_float)
    except ValueError:    
        user_input.set(input_text[:-1])

# Function to convert mpg to kml
def calculateKPL(mpg):
    calculated = mpg * 0.425143707 
    # Write calculated output to label
    output_var.set(round(calculated, 2))


# Input variables
user_input = StringVar()
output_var = StringVar()
# This has the callback function onChange
user_input.trace_add('write', callback=onChange)
text_box = Entry(root, state='normal', textvariable=user_input)


# UI widgets
input_label = Label(root, text='Insert Miles Per Gallon (MPG)')
output_label = Label(root, text='Output: ')
output = Label(root, textvariable=output_var)
input_label.grid(row=0, column=0)
text_box.grid(row=0, column=1)
output_label.grid(row=2, column=0)
output.grid(row=2, column=1)


root.mainloop()
