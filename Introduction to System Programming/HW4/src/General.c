#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "General.h"

#define SORT_COMPLETED_STR "Sorting completed!"

const char* optionStr[NofOptions] = { "Exit","Read City information from file",
	    "Show all Kindergartens","Show a specific Kindergarten",
	    "Save City information to file","Add a Kindergarten",
	    "Add a Child","Birthday to a Child",
	    "Count Hova children",
	    "Sort kindergartens by name",
	    "Sort children by ID",
	    "Sort kindergartens by type and children count"};

/**************************************************/
int menu()
/**************************************************/
/**************************************************/
{
	int option, i;

	printf("\n==========================");
	printf("\nSelect:\n");
	for (i = 0; i < NofOptions; i++)
		printf("\n\t%d. %s.", i, optionStr[i]);
	printf("\n");
	scanf("%d", &option);
	return option;
}

char* getStrExactLength(char* inpStr) {
	char* theStr = NULL;
	size_t len;

	len = strlen(inpStr) + 1;
	//allocate a place for the string in the right location in the array 
	theStr = (char*) malloc(len * sizeof(char));
	//Copy the string to the right location in the array 
	if (theStr != NULL)
		strcpy(theStr, inpStr);

	return theStr;
}

int checkAllocation(const void* p) {
	if (!p) {
		printf("ERROR! Not enough memory!");
		return 0;
	}
	return 1;
}

void insertionSort(void* arr, int size, int elementSize,
		int (*compare)(const void*, const void*)) {
	char* key = (char*) malloc(size);
	int i, j;
	for (i = elementSize; i < size * elementSize; i += elementSize) {
		memcpy(key, (char*) arr + i, size);
		for (j = i - elementSize; j >= 0 && (compare(key, (char*) arr + j) > 0);
				j -= elementSize) {
			memmove((char*) j + elementSize, (char*) arr + j, size);
		}
		memmove((char*) j + size, key, size);
	}
	free(key);
}

void printSortCompleted(){
	printf("%s", SORT_COMPLETED_STR );
}
