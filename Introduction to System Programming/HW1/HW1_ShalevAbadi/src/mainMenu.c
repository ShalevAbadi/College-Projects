/*
 * mainMenu.c
 *
 *  Created on: Nov 13, 2018
 *      Author: shale
 */


#include <stdio.h>
#include <stdlib.h>
#include "mainMenu.h"
#include "pictureManipulation.h"
#include "puzzle.h"
#define MAIN_MENU_STR "Please choose one of the following options\nP/p - Picture Manipulation\nN/n - Number Game\nE/e - Quit\n"
#define EXIT_MESSAGE "Bye Bye"

void printMainMenu(){
	printf("%s", MAIN_MENU_STR);
}

void handleMainMenuUserChoice() {
	char choice;
	do{
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
			exit(0);
			break;
		default:
		getchar();
		}
	} while(1);

}
