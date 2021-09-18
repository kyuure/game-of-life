# game-of-life
This repo is intended for GoAcademy Engineering Mini Bootcamp 2021 (Kampus Merdeka Path, i think).


## Game of Life Algorithm (J. H. Conway, 1970)
From [the Wikipedia page](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life),
Game of Life is a Cellular Automaton that is a zero-player game (the program
plays by itself, one can only see an observe it). It is Turing complete.

### Rules
This algorithm is an infinite n dimensional grid of cell (normally a square).
Each cell have 2 states only, alive or dead. Every cell in this universe at each
generation is affected by their neighbours from the last generation. Because
this program is intended for 2 dimension, the cells have 8 neighbours to
interact with. And there are only 4 rules applied, that is:
1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

From those rules, it can be simplified to:
1. Any live cell with two or three live neighbours survives.
2. Any dead cell with three live neighbours becomes a live cell.
3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.

Again, it references is [Game of Life Wikipedia page](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Rules).

### Algorithm
Based on those 3 rules, the algorithm will be (python syntax)
```py
for y in range(Yaxis):
  for x in range(Xaxis):
    # Total neighbour that's alive
    totalNeighbour = 0

    # Check every neighbours
    for b in range(-1,1+1):
      for a in range(-1,1+1):
        # The cells that's alive have value of 1, and cells that's dead atm
        # has value of 0. So to calculate total neighbours that is alive, we
        # can just add each neighbours' value.
        totalNeighbour += grid[b][a]

    # Check cell's status
    if grid[y][x]:
      # The cell alive
      if totalNeighbour < 2 or totalNeighbour > 3:
        # Dies becuase (under/over)population
        newGrid[y][x] = 0
      else:
        # still lives.
        newGrid[y][x] = grid[y][x]
    else:
      # The cell dead
      if totalNeighbour == 3:
        # become a live because of reproduction
        newGrid[y][x] = 1
      else:
        # still dead.
        newGrid[y][x] = grid[y][x]
```
