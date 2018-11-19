/*
 * pictureManipulation.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include "picture_manipulation.h"

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "general_methods.h"

void fill_matrix_with_randoms();
void picture_manipulation_print_menu();
void handle_pm_choice(int * returnToMainMenu);
void flip_vertical();
void rotate_matrix_90_degrees_clockwise();
void transpose_matrix();
void rotate_matrix_90_degrees_counter_clockwise();
void flip_horizontal();

#define PM_SIZE 5
#define PM_MENU_STR "\nPlease choose one of the following options\n1 - 90 degree clockwise\n2 - 90 degree counter clockwise\n3 - Flip Horizontal\n4 - Flip Vertical\n-1 - Quit\n"
#define PM_AFTER_STR "--------- picture after manipulation ---------\n"
#define PM_INVALID_STR "invalid input\n"
#define PM_LOWER_RAND 0
#define PM_UPPER_RAND 99
#define PM_DIGITS 2

int PM_MATRIX[PM_SIZE][PM_SIZE];
int *matrix_first_index_pointer = &PM_MATRIX[0][0];

void picture_manipulation_main() {
	fill_matrix_with_randoms();
	int return_to_main_menu = 0;
	do {
		print_matrix(PM_SIZE, PM_SIZE, matrix_first_index_pointer);
		handle_pm_choice(&return_to_main_menu);
		if (!return_to_main_menu) {
			printf("%s", PM_AFTER_STR);
		}
	} while (!return_to_main_menu);
}

void fill_matrix_with_randoms() {
	srand(time(NULL));
	for (int i = 0; i < PM_SIZE * PM_SIZE; i++) {
		*(matrix_first_index_pointer + i) = random_from_range(PM_LOWER_RAND,
		PM_UPPER_RAND);
	}
}

void picture_manipulation_print_menu() {
	printf("%s", PM_MENU_STR);
}

void handle_pm_choice(int * return_to_main_menu) {
	int is_invalid_choice;
	int choice;
	do {
		clear_buffer();
		picture_manipulation_print_menu();
		scanf("%d", &choice);
		is_invalid_choice = 0;
		switch (choice) {
		case 1:
			rotate_matrix_90_degrees_clockwise();
			break;
		case 2:
			rotate_matrix_90_degrees_counter_clockwise();
			break;
		case 3:
			flip_horizontal();
			break;
		case 4:
			flip_vertical();
			break;
		case -1:
			*return_to_main_menu = 1;
			break;
		default:
			is_invalid_choice = 1;
			printf("%s", PM_INVALID_STR);
			break;
		}
	} while (is_invalid_choice);

}

void rotate_matrix_90_degrees_clockwise() {
	transpose_matrix();
	flip_vertical();
}

void rotate_matrix_90_degrees_counter_clockwise() {
	flip_vertical();
	transpose_matrix();
}

void transpose_matrix() {
	int first_index, second_index;
	for (int i = 0; i < PM_SIZE; i++) {
		for (int j = i + 1; j < PM_SIZE; j++) {
			first_index = i * PM_SIZE + j;
			second_index = j * PM_SIZE + i;
			swap(first_index, second_index, matrix_first_index_pointer);
		}
	}
}

void flip_vertical() {
	int first_index, second_index;
	for (int i = 0; i < PM_SIZE; i++) {
		for (int j = 0; j < PM_SIZE / 2; j++) {
			first_index = i * PM_SIZE + j;
			second_index = i * PM_SIZE + (PM_SIZE - 1 - j);
			swap(first_index, second_index, matrix_first_index_pointer);
		}
	}
}

void flip_horizontal() {
	int first_index, second_index;
	for (int i = 0; i < PM_SIZE / 2; i++) {
		for (int j = 0; j < PM_SIZE; j++) {
			first_index = (i * PM_SIZE + j);
			second_index = (PM_SIZE - 1 - i) * PM_SIZE + j;
			swap(first_index,second_index , matrix_first_index_pointer);
		}
	}
}


