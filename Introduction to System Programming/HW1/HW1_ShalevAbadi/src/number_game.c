/*
 * puzzle.c
 *
 *  Created on: Nov 13, 2018
 *      Author: shale
 */

#include "number_game.h"

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "general_methods.h"

#define ROWS 4
#define COLS 3
#define INVALID_MESSAGE_STR "Invalid step! \n"
#define STEP_STR "Your step: "
#define WIN_STR "You win! The game is over!"
#define SHUFFLE_COUNT 30

int empty_position_index = 0;
int puzzle[ROWS][COLS];
int* first_index_pointer = &puzzle[0][0];

void puzzle_main() {
	initialize_puzzle();
	print_matrix(ROWS, COLS, *puzzle);
	do {
		move();
	} while (!validate_win());
	printf("%s", WIN_STR);
}

void initialize_puzzle() {

	for (int i = 0; i < ROWS * COLS; i++) {
		*(first_index_pointer + i) = i;
	}
	shuffle_puzzle();
}

void shuffle_puzzle() {
	int rand_A_row, rand_A_col, rand_B_row, rand_B_col;
	int * randARowPointer = &rand_A_row;
	int * randAColPointer = &rand_A_col;
	int * randBRowPointer = &rand_B_row;
	int * randBColPointer = &rand_B_col;
	srand(time(NULL));
	for (int i = 0; i < SHUFFLE_COUNT; i++) {
		generate_row_and_col_randoms(randARowPointer, randAColPointer);
		generate_row_and_col_randoms(randBRowPointer, randBColPointer);
		int rand_A_index = rand_A_row * COLS + rand_A_col;
		int rand_B_index = rand_B_row * COLS + rand_B_col;
		swap(rand_A_index, rand_B_index, first_index_pointer);
		if (rand_A_index == empty_position_index) {
			empty_position_index = rand_B_index;
		} else if (rand_B_index == empty_position_index) {
			empty_position_index = rand_A_index;
		}
	}
}

void generate_row_and_col_randoms(int * row_pointer, int * col_pointer){
	*row_pointer = random_from_range(0, ROWS - 1);
	*col_pointer = random_from_range(0, COLS -1 );
}

void move() {
	printf("%s", STEP_STR);
	int user_input = 0;
	scanf("%d", &user_input);
	clear_buffer();
	if (!check_right(user_input)) {
		if (!check_left(user_input)) {
			if (!check_up(user_input)) {
				if (!check_down(user_input)) {
					printf("%s", INVALID_MESSAGE_STR);
					user_input = 0;
				}
			}
		}
	}
	print_matrix(ROWS, COLS, *puzzle);

}

int validate_win() {
	if (empty_position_index == ROWS * COLS - 1) {
		for (int i = 0; i < ROWS * COLS - 2; i++) {
			if (*(first_index_pointer + i) != i + 1) {
				return 0;
			}
		}
		return 1;
	}
	return 0;
}

int check_up(int userInput) {
	if (empty_position_index >= COLS) {
		int up = *(first_index_pointer + empty_position_index - COLS);
		if (up == userInput) {
			swap(empty_position_index - COLS, empty_position_index, *puzzle);
			empty_position_index = empty_position_index - COLS;
			return 1;
		}
	}
	return 0;
}

int check_down(int userInput) {
	if (empty_position_index < COLS * (ROWS - 1)) {
		int up = *(first_index_pointer + empty_position_index + COLS);
		if (up == userInput) {
			swap(empty_position_index + COLS, empty_position_index, *puzzle);
			empty_position_index = empty_position_index + COLS;
			return 1;
		}
	}
	return 0;
}

int check_left(int user_input) {
	if ((empty_position_index + COLS) % COLS != 0) {
		int left = *(first_index_pointer + empty_position_index - 1);
		if (left == user_input) {
			swap(empty_position_index - 1, empty_position_index, *puzzle);
			empty_position_index--;
			return 1;
		}
	}
	return 0;
}

int check_right(int userInput) {
	if ((empty_position_index) % COLS != COLS - 1) {
		int right = *(first_index_pointer + empty_position_index + 1);
		if (right == userInput) {
			swap(empty_position_index + 1, empty_position_index, *puzzle);
			empty_position_index++;
			return 1;
		}
	}
	return 0;
}

