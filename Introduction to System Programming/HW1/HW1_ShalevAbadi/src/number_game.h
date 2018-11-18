/*
 * puzzle.h
 *
 *  Created on: Nov 13, 2018
 *      Author: shale
 */

void puzzle_main();
void initialize_puzzle();
void shuffle_puzzle();
void move();
int validate_win();
int check_left(int userInput);
int check_right(int userInput);
int check_up(int userInput);
int is_empty_position_on_top();
int is_empty_position_on_bottom();
int is_empty_position_on_right_edge();
int is_empty_position_on_left_edge();
int check_down(int userInput);
void generate_row_and_col_randoms(int * rowPointer, int * colPointer);
