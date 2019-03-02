/********************************************************
 * lifegame.h -- utility functions for Convoy's Game of Life. *
 * *
 * Author. TODO.*
 * *
 * Purpose. function prototypes for the game. *
 * *
 * Usage. *
 * Call the functions in main() to evolve the world. *
 ********************************************************/

/* Warning: Do NOT modify the contents of this file. */

#ifndef LIFEGAME_H_
#define LIFEGAME_H_

/* state constants */
#define DEAD  0
#define ALIVE 1

/*
 * sets up world, 
 * all cells initialized to DEAD or ALIVE; 
 * all cells in next generation are initialized to DEAD 
 */
void initialize_world(void);

/* returns the width (x) and height (y) of the world */
int get_world_width(void);
int get_world_height(void);

/* 
 * returns the state (DEAD or ALIVE) of the cell at (x,y);
 * x coordinates go from 0, ..., width - 1, and
 * y coordinates go from 0, ..., height- 1; 
 * returns DEAD for cells outside this range 
 */
int get_cell_state(int x, int y);

/*
 * sets the state of the cell at (x,y) in the next generation;
 * x coordinates go from 0, ..., width - 1, and
 * y coordinates go from 0, ..., height- 1; 
 * calls abort() if invalid coordinates are specified 
 */
void set_cell_state(int, int, int);

/* 
 * set the state of all the cells in the next generation, and 
 * call finalize_evolution() to update the current state of the 
 * world to the next generation 
 */
void next_generation(void);

/* 
 * returns the state of the cell at (x,y) in the next generation, 
 * according to the rules of Conway's Game of Life 
 */
int get_next_state(int, int);

/* returns the number of ALIVE neighbors for cell at (x,y) */
int num_neighbors(int, int);

/*
 * updates world state to next generation, and 
 * resets all next generation states to DEAD 
 */
void finalize_evolution(void);

/* outputs the current world state to the console */
void output_world(void);

#endif /* LIFEGAME_H_ */
