/*
 * handleUserChoice.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */

#include <stdio.h>
#include <stdlib.h>
#include "handleUserChoice.h"
#include "pictureManipulation.h"
#include "puzzleMain.h"

void handleUserChoice() {
	char choice;
	char exitMessage[] = "Bye Bye";
	do{
		choice = getchar();
		switch (choice) {
		case 'p':
		case 'P':
			pictureManipulation();
			break;
		case 'n':
		case 'N':
			puzzleMain();
			break;
		case 'e':
		case 'E':
			printf("%s", exitMessage);
			exit(0);
			break;
		default:
		getchar();
		}
	} while(1);

}
