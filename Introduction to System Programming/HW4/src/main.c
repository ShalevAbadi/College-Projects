#include <stdio.h>
#include <stdlib.h>

#include "test.h"
#include "General.h"
#include "Kindergarten.h"
#include "Child.h"
#include "City.h"

int main(int argc, char* argv[]) {
	int useBinaryFormat;
	sscanf(argv[2], "%d", &useBinaryFormat);
	int uReq;
	City utz = { NULL, 0 };

	//first time read
	readCity(&utz, useBinaryFormat);
	do {
		uReq = menu();
		switch (uReq) {
		case READ_CITY:
			readCity(&utz, useBinaryFormat);
			break;

		case SHOW_CITY:
			showCityGardens(&utz);
			break;

		case SHOW_GARDEN:
			showSpecificGardenInCity(&utz);
			break;

		case WRITE_CITY:
			saveCity(&utz, useBinaryFormat);
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
		case SORT_KINDERGARTENS_BY_NAME:
			sortCityKindergartensByName(&utz);
			break;

		case SORT_CHILDREN_BY_ID:
			sortCityKindergartenKidsByID(&utz);
			break;

		case SORT_KINDERGARTENS_BY_TYPE_AND_CHILDREN_COUNT:
			sortCityKindergartensByTypeAndChildrenCount(&utz);
			break;
        case LINKED_LIST_SAME_GARDEN_TYPE:
            kindergartenLinkedList(&utz);
			break;

		}
	} while (uReq != EXIT);

	releaseCity(&utz); //free all allocations
	return EXIT_SUCCESS;
}

