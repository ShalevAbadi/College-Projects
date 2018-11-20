/*
 * mainMenu.c
 *
 *  Created on: Nov 13, 2018
 *      Author: shale
 */


#include "mainMenu.h"

#include <stdio.h>

#include "numberGame.h"
#include "pictureManipulation.h"
#include "utilities.h"


#define MAIN_MENU_STR "Please choose one of the following options\nP/p - Picture Manipulation\nN/n - Number Game\nE/e - Quit\n"
#define MAIN_MENU_INVALID_STR "Invalid Choice"
#define EXIT_MESSAGE "Bye Bye"

int mainMenuRun() {
	int run = 1;
	while(run) {
		printMainMenu();
		run = handleMainMenuUserChoice();
		clearBuffer();
	};
	return 0;
}

void printMainMenu() {
	printf("%s", MAIN_MENU_STR);
}

int handleMainMenuUserChoice() {
	char choice;
	choice = getchar();
	switch (choice) {
	case 'p':
	case 'P':
		pictureManipulationMain();
		break;
	case 'n':
	case 'N':
		puzzleMain();
		break;
	case 'e':
	case 'E':
		printf("%s", EXIT_MESSAGE);
		return 0;
		break;
	default:
		clearBuffer();
		printf("%s", MAIN_MENU_INVALID_STR);
		break;
	}
	return 1;


}
