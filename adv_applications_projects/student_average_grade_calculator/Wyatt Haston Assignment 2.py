# Program Name: Wyatt Haston Assignment 2.py (use the name the program is saved as)
# Course: IT1114/Section 01/W01
# Student Name: Wyatt Haston
# Assignment Number: Lab 2
# Due Date: 01/28/2023
# Purpose: This program takes in a txt file with a student and their grades and then prints their average
# Resources: 
# (These links are me looking up how to do things the python way) 
# https://stackoverflow.com/questions/522563/how-to-access-the-index-value-in-a-for-loop 
# https://pythonprinciples.com/blog/python-convert-string-to-int
# https://stackoverflow.com/questions/20457038/how-to-round-to-2-decimals-with-python

import math

# Takes in raw file text and returns an array with first index as the name and the rest is the grades
def parseFile(rawText):
    formattedArray = []
    # Split by new lines which is 'Student # # # #'
    rawStudentArray = rawText.split('\n')
    for student in rawStudentArray:
        formattedStudent = []
        rawArray = student.split(' ')
        # For loop that turns numbers into ints
        for index, value in enumerate(rawArray):
            # First index is always students name and is not converted
            if(index == 0):
                formattedStudent.append(value)
            else:
                # convert to an int and append to the array
                convertedInt = int(value)
                formattedStudent.append(convertedInt)
        formattedArray.append(formattedStudent)
    #return the array
    return formattedArray

def findAverage(studentArray):
    studentAverageArray = []
    for index, value in enumerate(studentArray):
        student = []
        total = 0
        # For each student append its name and add all values to the total
        for index, studentValue in enumerate(value):
            if(index == 0):
                student.append(studentValue)
            else:
                total += studentValue
        # Append the rounded 2 decimal places the average
        student.append(round((total / (len(value) - 1)), 2))
        # Append array for each student of [Name, Average]
        studentAverageArray.append(student)
    return studentAverageArray 

def main():
    fileName = 'Assignment2input.txt'
    file = open(fileName, 'r')
    rawText = file.read()

    formattedArrayOfStudents = parseFile(rawText)
    averageArray = findAverage(formattedArrayOfStudents)

    for student in averageArray:
        # 0 is name, 1 is average
        print(student[0], student[1])

    file.close()

main()