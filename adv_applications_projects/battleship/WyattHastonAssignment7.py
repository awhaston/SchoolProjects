# Program Name: WyattHastonAssignment7.py (use the name the program is saved as)
# Course: IT1114/Section 01/W01
# Student Name: Wyatt Haston
# Assignment Number: Assignment 7 
# Due Date: 4/21/23 
# Purpose: This is a battleship board game against a computer
# Resources:
#   Matching game from midterm for wrapping and rendering a lot of buttons programmatically
#   Sleep to wait for computer turn https://realpython.com/python-sleep/
#   Python ternaries https://www.geeksforgeeks.org/ternary-operator-in-python/
#   Python interestion to check if there is no matching ship coords https://www.geeksforgeeks.org/python-check-two-lists-least-one-element-common/
#   Getting the last digit of a number https://stackoverflow.com/questions/5254827/how-to-check-last-digit-of-number


from tkinter import *
import tkinter.messagebox as message_box
from random import randint
import argparse

# Class to wrap button objects and predefined methods to set styles
class GameButton:
    def __init__(self, id, h, w, row, col, computer):
        self.id = id
        self.row = row
        self.col = col
        self.h = h 
        self.w = w 
        self.button_obj = None
        self.computer = computer
        self.hit = False
    
    # Styling methods
    def set_miss(self):
        self.hit = True
        self.button_obj.config(state='disabled', text='O', bg='white')
    
    def set_ship(self):
        self.button_obj.config(text='■')
    
    def set_hit(self):
        self.hit = True
        self.button_obj.config(state='disabled', text='X', bg='red')
    
# Class storing all ship methods and creation
class GameShip:
    def __init__(self, id):
        self.id = id
        self.ships = []
        
    def add_ship(self, size):
        valid = False
        # While loops generate new ships until a valid ship is found
        while(valid == False):
            ship = {
                'size': size,
                'coords': [],
                'hit': [],
                'sunk': False
            } 
            # new ships start at a random id
            start_id = randint(0, 399)
            direction = randint(0,1)
            ship['coords'].append(start_id)

            for i in range(size - 1):
                # 0 is up
                if(direction == 0):
                    offset = 20 * (i + 1)
                    # We are only going up and columns lose 20 going up
                    # if the offset is less than 0 then it is an invalid ship and a new one needs to be made
                    if(start_id - offset < 0):
                       break 
                    ship['coords'].append(start_id - offset)
                # 1 is left
                elif(direction == 1):
                    offset = ((i * 1) + 1)
                    # Checking if size is too big and would overflow into next row
                    # Example grid tiles ending in 8 or 9 are illegal for a size of 3
                    # Last digit can get gotten by getting the modulus of the id by 10 and checking if it is above the 10 - size
                    # I got how to get the final digit from stack overflow, but I'm a little proud to have found the pattern/logic
                    if((start_id + offset) % 10 < 10 - size):
                       break 
                    ship['coords'].append(start_id + offset)

            # Checking if there is any repeated values
            for main_ship in self.ships:
                for coords in ship:
                    if coords in main_ship['coords']:
                       continue 

            # Checks if ship is the correct size
            if(len(ship['coords']) == ship['size']):
                valid = True

        # Add ship to list of ships 
        self.ships.append(ship)
    
    # Print a ships coordinates
    def print_coords(self):
        print(self.id)
        for ship in self.ships:
            print(ship['coords'])

    # Loop through ships to find it and on hit check if sun
    def check_hit(self, coord):
        hit = False
        for ship in self.ships:
            if(coord in ship['coords']):
                ship['hit'].append(coord)
                hit = True
                if len(ship['hit']) == ship['size']:
                    ship['sunk'] = True
                
        return hit 
    
    # Returns all sunk ships that will be later used to check the winner
    def check_sunk(self):
        sunk = 0
        for ship in self.ships:
            if ship['sunk'] == True:
                sunk = sunk + 1

        return sunk
        

# Class holding all game state and events 
class Game:
    def __init__(self, root, debug): 
        self.turn = 'player'
        self.player_grid = []
        self.computer_grid = []
        # Init GameShip classes
        self.player_ships = GameShip('player') 
        self.computer_ships = GameShip('computer') 
        # ids of computer buttons the player hit or missed 
        self.player_hits = []
        self.player_misses = []
        self.player_sunk= 0 
        # ids of player buttons the computer hit or missed 
        self.computer_hits = []
        self.computer_misses = [9000] # 9000 is impossible value to assure new hit target coords are generated
        self.computer_sunk = 0 
        self.click = False
        # Since root is accessed a lot, storing in class state
        self.root = root
        self.winner = ''
        # Debug value to show ids
        self.debug = debug

    def create_grid(self, array, x_offset, computer):
        row = 20
        col = 20

        # Double loop for making grid
        # Creation of grid was taken from midterm matching game
        for x in range(row):
            for y in range(col):
                id = x * col + y
                player_ship = False

                # Checking if id belongs to a player ship
                if computer == False:
                    for ship in self.player_ships.ships:
                        if id in ship['coords']:
                            player_ship = True

                # Creating game buttons and showing gray box if it is a player ship
                gb = GameButton(id=id, h=3, w=3, row=x + 1, col=y + x_offset, computer=computer)
                if player_ship == False:
                    gb.button_obj = Button(self.root, command=lambda gb = gb: self.handle_click(gb), text='      ', height=1, width=3, bg='blue', state='normal' if computer else 'disabled')
                else:
                    gb.button_obj = Button(self.root, command=lambda gb = gb: self.handle_click(gb), text='      ', height=1, width=3, bg='gray', state='normal' if computer else 'disabled')
                    gb.set_ship()

                array.append(gb)
    
    # Initialize ships using ships class
    def create_ships(self):
        self.player_ships.add_ship(3)
        self.computer_ships.add_ship(3)
        self.player_ships.add_ship(2)
        self.computer_ships.add_ship(2)
        self.player_ships.add_ship(3)
        self.computer_ships.add_ship(3)
        self.player_ships.add_ship(2)
        self.computer_ships.add_ship(2)
        self.player_ships.add_ship(4)
        self.computer_ships.add_ship(4)

        # Print out coords for debug purposes
        if self.debug:
            self.player_ships.print_coords()
            self.computer_ships.print_coords()

    # Player click logic
    def handle_click(self, button):
        # Prevent click if computer turn, computer button, or already clicked
        if(self.turn == 'computer' or button.computer == False or self.click == True):
            return
        
        self.click = True
        
        # Since we have button id checking hit and setting hit properties is easier
        if(self.computer_ships.check_hit(button.id)):
            message_box.showinfo('HIT', 'HIT')
            self.player_hits.append(button.id)
            button.set_hit()
        else:
            self.player_misses.append(button.id)
            button.set_miss()
        
        # Handle computer turn functions
        self.swap_turn()
        self.handle_computer_turn()
        self.click = False


    def handle_computer_turn(self):
        # Invaid button id placed in missed shots so while loop always triggers
        # While loop constantly generate new id until a valid one is found
        target_coord = 9000

        while (target_coord in self.computer_hits or target_coord in self.computer_misses):
            target_coord = randint(0, 399)
        
        # Checking hit logic
        hit = self.player_ships.check_hit(target_coord)

        if(hit):
            self.computer_hits.append(target_coord)
        else:
            self.computer_misses.append(target_coord)

        # Get hit button and set hit properties
        for b in self.player_grid:
            if(b.id == target_coord):
                if(hit):
                    message_box.showinfo('Uh oh!', "You've been hit!")
                    b.set_hit()
                else:
                    b.set_miss()
        
        self.swap_turn()

    def unrender_grid(self, grid):
        for b in grid:
            b.button_obj.grid_forget()

    def render_grid(self, grid):
        for b in grid:
            # if -d or --debug is set show the Ids
            if self.debug == True:
                b.button_obj.config(text=b.id)
            b.button_obj.grid(row=b.row, column=b.col)
    
    # Seperate render grid methods for player and computer in case of wanting seperate logic
    def render_player(self):
        self.render_grid(self.player_grid)

    def render_computer(self):
        self.render_grid(self.computer_grid)

    # Renders text labeling boards
    def render_layout(self):
        label = Label(self.root, text='')
        player = Label(self.root, text='Player Board')
        computer = Label(self.root, text='Computer Board')
        player.grid(row=0, column=0, columnspan=10)
        computer.grid(row=0, column=22, columnspan=10)
        label.grid(row=0, column=21, padx=5)
    
    # Gets the winner based on what is passed in and display win/lose with amount of guesses 
    def handle_win(self, winner):
        self.winner = winner
        guesses = len(self.player_hits) + len(self.player_misses)
        
        if(winner == 'computer'):
            message = 'Oh no! You lose with {} guesses!'.format(str(guesses))
            message_box.showinfo('TOO BAD', message) 
        if(winner == 'player'):
            message = 'You Win! It took {} guesses!'.format(str(guesses))
            message_box.showinfo('CONGRATULATIONS', message)
        # Exit after game is over
        exit(0)
        
    # Each turn swap check if there is a winner and handle win
    def swap_turn(self):
        if(self.turn == 'computer'):
            sunk = self.player_ships.check_sunk()

            if sunk == len(self.player_ships.ships):
                self.handle_win('computer')
                return
            
            self.turn = 'player'
        else:
            sunk = self.computer_ships.check_sunk()

            if sunk == len(self.computer_ships.ships):
                self.handle_win('player')
                return
            self.turn = 'computer'
 
    # Create game logic
    def create_game(self):
        self.create_ships()
        self.create_grid(self.player_grid, 0, False)
        self.create_grid(self.computer_grid, 22, True)
        self.render_computer()
        self.render_layout()
        self.render_player()


def main():
    # Parser to add debug flag to show ids
    parser = argparse.ArgumentParser(description='Battleship game', formatter_class=argparse.ArgumentDefaultsHelpFormatter)
    parser.add_argument('-d', '--debug', action='store_true', help='enable debug ids')
    args = parser.parse_args()
    debug = vars(args)['debug']

    # Tkinter Logic
    root = Tk()
    root.title('Wyatt Haston Assignment 7: Battleship')
    root.minsize(850, 850)

    # Initialize and start game
    game = Game(root, debug=debug)
    game.create_game()

    # Start main loop
    root.mainloop()
    
main()