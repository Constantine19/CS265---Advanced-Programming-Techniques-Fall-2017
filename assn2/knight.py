# Konstantin Zelmanovich
# CS 265
# Assignment 2
# 11/13/2017
# Python 2.7.12 on tux4.cs.drexel.edu

from random import randint
import sys
import knight

message = True

class knightTour:
    def __init__(self, rows, columns):
        self.rows = rows
        self.columns = columns
        self.position = (0, 0)
        self.moves = [(2, 1), (-2, 1), (2, -1), (-2, -1), (1, 2), (-1, 2), (1, -2), (-1, -2)]
        self.board = list()
        self.true = True

        self.createBoard()

# Function to create a chess board
    def createBoard(self):
        self.board = [["x" for i in range(self.rows)] for j in range(self.columns)]
        self.board[0][0] = 1

# Function to print current state of a board
    def printBoard(self):
        for row in self.board:
            print row

# Function to check for available moves
    def checkMoves(self, position):
        available_moves = list()

        for i in self.moves:
            y = position[0] + i[0]
            x = position[1] + i[1]

            if y >= self.columns:
                continue
            elif y < 0:
                continue
            elif x >= self.rows:
                continue
            elif x < 0:
                continue
            else:
                try:
                    if self.board[y][x] == "x":
                        available_moves.append(i)
                except:
                    continue

        return available_moves

# Function to choose a random move from available moves
    def makeMove(self, position, i):
        try:
            moves = self.checkMoves(position)

            random_move = moves[randint(0, len(moves)-1)]
            y = position[0] + random_move[0]
            x = position[1] + random_move[1]
            self.position = (y, x)
            self.board[y][x] = i
        except:
            self.true = False

# Function to begin a knight's tour
    def beginTour(self):
        global message
        message = True
        z = 2
        while self.true:
            self.makeMove(self.position, z)
            z = z + 1
        for k in self.board:
            if "x" in k:
                message = False
                break

def main(rows, columns, attempts):
    for _ in range(attempts):
        tour = knight.knightTour(rows, columns)
        tour.beginTour()
        if knight.message:
            print "\nSUCCESS:\n"
            tour.printBoard()
            print "\n"
            break
        else:
            continue
    if not knight.message:
        print "\nFAIL:\n"
        tour.printBoard()
        print "\n"

# Magic function to run main function
if __name__ == '__main__':
    if len(sys.argv) != 4:
        print "\nPlease pass 3 arguments... rows, columns and attempts\n"
        exit()
    else:
        main(int(sys.argv[1]), int(sys.argv[2]), int(sys.argv[3]))
