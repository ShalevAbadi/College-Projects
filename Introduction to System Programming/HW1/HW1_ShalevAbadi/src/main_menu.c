/*
 * mainMenu.c
 *
 *  Created on: Nov 13, 2018
 *      Author: shale
 */

#include "main_menu.h"

#include <stdio.h>
#include <stdlib.h>
#include "general_methods.h"
#include "number_game.h"
#include "picture_manipulation.h"
#define MAIN_MENU_STR "Please choose one of the following options\nP/p - Picture Manipulation\nN/n - Number Game\nE/e - Quit\n"
#define EXIT_MESSAGE "Bye Bye"

void main_menu_run() {
	do {
		print_main_menu();
		handle_main_menu_user_choice();
		clear_buffer();
	} while (1);
}

void print_main_menu() {
	printf("%s", MAIN_MENU_STR);
}

void handle_main_menu_user_choice() {
	char choice;
	choice = getchar();
	switch (choice) {
	case 'p':
	case 'P':
		picture_manipulation_main();
		break;
	case 'n':
	case 'N':
		puzzle_main();
		break;
	case 'e':
	case 'E':
		printf("%s", EXIT_MESSAGE);
		exit(0);
		break;
	default:
		clear_buffer();
	}

}
