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

Again, it reference is [Game of Life Wikipedia page](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).
