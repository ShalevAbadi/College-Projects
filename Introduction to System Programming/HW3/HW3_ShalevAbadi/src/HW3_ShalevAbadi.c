/*
 ============================================================================
 Name        : HW3_ShalevAbadi.c
 Author      : Shalev Abadi
 Version     :
 Copyright   : 
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "MenuFunctions.h"
#include "City.h"

typedef enum {
	EXIT,
	READ_CITY,
	SHOW_CITY,
	SHOW_GARDEN,
	WRITE_CITY,
	ADD_GARDEN,
	ADD_CHILD,
	CHILD_BIRTHDAY,
	COUNT_GRADUATE
} MENU;

int main() {
	City utz = { NULL, 0 };
	int uReq;
//first time read
	readCity(&utz);

	do {
		uReq = menu();
		switch (uReq) {
		case READ_CITY:
			readCity(&utz);
			break;
		case SHOW_CITY:
			showCityGartens(&utz);
			break;
		case SHOW_GARDEN:
			showSpecificGardenInCity(&utz);
			break;
		case WRITE_CITY:
			saveCity(&utz);
			break;
		case ADD_GARDEN:
			cityAddGarden(&utz);
			break;
		case ADD_CHILD:
			addChildToSpecificGardenInCity(&utz);
			break;
		case CHILD_BIRTHDAY:
			birthdayToChild(&utz);
			break;
		case COUNT_GRADUATE:
			printf("There are %d children going to school next year\n",
					countChova(&utz));
			break;
		}
	} while (uReq != EXIT);
	releaseCity(&utz); //free all allocations
	return 1;
}
