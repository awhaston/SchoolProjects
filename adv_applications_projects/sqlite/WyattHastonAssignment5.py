# Program Name: WyattHastonAssignment5.py
# Course: IT1114/Section 01/W01
# Student Name: Wyatt Haston
# Assignment Number: Assignment 5
# Due Date: 03/24/2024
# Purpose: This program creates a db with a table that has a ID, Day of the week, and temperature, it then reads
# from a text file, and finally inserts that data into the DB
# Resources: Class lectures

import sqlite3

def main(): 
    # Open DB and file
    conn = sqlite3.connect("./db.db")
    rawText = open("./Assignment5input.txt")
    c = conn.cursor()

    # Create table DailyTemp if it doesn't already exist
    c.execute("CREATE TABLE IF NOT EXISTS DAILYTEMP(ID INTEGER PRIMARY KEY AUTOINCREMENT, DAY TEXT, TEMP FLOAT);")

    # For loop inserting data into database
    for line in rawText:
        items = line.split(" ")
        c.execute("INSERT INTO DAILYTEMP (DAY, TEMP) VALUES ('{}', {});".format(items[0], items[1]))

    # Get average temp for Thursdays
    c.execute("SELECT AVG(TEMP) FROM DAILYTEMP WHERE DAY='Thursday'")
    thursday_avg = c.fetchall()

    # Get average temp for Sundays
    c.execute("SELECT AVG(TEMP) FROM DAILYTEMP WHERE DAY='Sunday'")
    sunday_avg = c.fetchall()

    # Print averages to console
    print("Thursday's Average: {}".format(thursday_avg[0]))
    print("Sunday's Average: {}".format(sunday_avg[0]))

    # Commit and close db connection
    conn.commit()
    conn.close()

main()
