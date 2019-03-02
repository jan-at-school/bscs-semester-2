/********************************************************
 * testmain.c -- program to test the game. *
 * *
 * Author. TODO.*
 * *
 * Purpose. Demonstration of a Convoy's Game of Life. *
 * *
 * Usage. *
 * Runs the program and the evolved world appears. *
 ********************************************************/
 
/* Warning. Do NOT modify the contents of this file. */

/* include standard functions for game */
#include <stdlib.h>
#include <time.h>
 
/* include helper functions for game */
#include "lifegame.h"

/* number of generations to evolve the world */
#define NUM_GENERATIONS 50

void wait_for(unsigned int secs);

int millisleep(unsigned ms);

void delay(int milliseconds);

int main(void)
{
	int n;
	
	/* initialize the world */
	initialize_world();
	output_world();
	printf("\nThe last:\n");
	for (n = 0; n < NUM_GENERATIONS; n++)
		next_generation();
		
	/* output final world state to console */
	output_world();

	/* uncomment this section to animate the evolving generations */
	
	initialize_world();	
	for (n = 0; n < NUM_GENERATIONS; n++){
		output_world();
		delay(400);
		next_generation();		
	}	
	
	/* remember to comment it out when making the submission */
	system("pause");
	return EXIT_SUCCESS;
}

void wait_for (unsigned int secs) {
    unsigned int ret_time = time(0) + secs; // get finishing time
    while(time(0) < ret_time);    			// loop until it arrives
}

void delay(int milliseconds)
{
    long pause;
    clock_t now, then;

    pause = milliseconds * (CLOCKS_PER_SEC/1000);
    now = then = clock();
    while( (now - then) < pause )
        now = clock();
}