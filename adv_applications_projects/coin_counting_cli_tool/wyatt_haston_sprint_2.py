# Program Name:  wyatt_haston_sprint_1.py
# Course: IT1114/Section 01/W01
# Student Name: Wyatt Haston
# Due Date: 5/5/2024 
# Purpose: This program takes in a English phrase about amount of coins and return the amount in dollars
# Resources:
# Get args https://stackoverflow.com/questions/4033723/how-do-i-access-command-line-arguments

import sys


def parse_raw_input(input):
    # Including spaces to remove any spaces from resulting array items
    raw_numval_array = input.split(' and ')
    return raw_numval_array

def get_num(raw_num):
    # Try to convert to int and return None if not and int
    try:
        return int(raw_num)
    except:
        return None

def get_val(raw_val):
    # since penny changes on plural have seperate case for it
    if raw_val == "pennies" or raw_val == "penny":
        return 1
    # remove final s to make if checking easier
    if raw_val[-1] == "s":
        raw_val = raw_val[:-1]

    if raw_val == 'nickel':
        return 5
    elif raw_val == 'dime':
        return 10
    elif raw_val == 'quarter':
        return 25
    elif raw_val == 'half-dollar':
        return 50
    elif raw_val == 'dollar':
        return 100
    else:
        return None


def process_numval(raw_numval_array):
    numval_array = []

    for raw_numval in raw_numval_array:
        numvals = raw_numval.split(" ")

        # If there is not 2 items that means the input is incorrectly formatted and return none
        if len(numvals) != 2:
            return None 

        # Get the number values of the number and values
        num = get_num(numvals[0])
        val = get_val(numvals[1])

        # if we couldn't parse the values return none
        if num == None or val == None:
            return None

        numval_array.append([num, val])

    return numval_array 

def get_coin_from_val(val):
    if val == 1:
        return "penny"
    if val == 5:
        return "nickel"
    if val == 10:
        return 'dime'
    if val == 25:
        return 'quarter'
    if val == 50:
        return 'half-dollar'
    if val == 100:
        return 'dollar'

# Add all money in cents and return converted to USD by diving by 100
# Counts up the value of each coins and returns it
def get_total_usd(numval_array):
    total = 0
    coins = {}
    for numval in numval_array:
        # Check if val_iden exists and add to total
        val_iden = get_coin_from_val(numval[1])
        if val_iden in coins.keys():
            coins[val_iden] = coins[val_iden] + (1 * numval[0])
        else:
            coins[val_iden] = (1 * numval[0])
        total += numval[0] * numval[1]
    return [total/100, coins] 

def main():
    args = sys.argv
    # If we recieve more than 1 argument then print error and return 
    # Argument must be properly quoted in order for us to process it
    if len(args) != 2:
        print("Invalid input \nProper use is: \npython3 wyatt_haston_sprint_1.py \"1 penny and 1 dimes\"")
        return

    raw_input = args[1]
    raw_numval_array = parse_raw_input(raw_input)
    numval_array = process_numval(raw_numval_array)
    # if none that means it could not be processed
    if numval_array == None:
        print("Unable to parse input\nProper input example '1 penny and 12 dimes and 50 quarters'\nValid coins:\nPennies\nNickels\nDimes\nQuarters\nHalf-Dollars\nDollars")
        return

    # Return value is always total then coins
    [total, coins] = get_total_usd(numval_array)
    print("Coin breakdown:")
    for key in coins:
        val = coins[key]
        if key == 'penny':
            print('Pennies: {}'.format(val))
        else:
            print('{}s: {}'.format(key.capitalize(), val))
    # Format total to 2 floating decimal places
    print('Total: {}'.format(format(total, '.2f')))

main()
