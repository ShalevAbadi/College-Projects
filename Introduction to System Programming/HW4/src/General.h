#ifndef __PROTOTYPE__
#define __PROTOTYPE__

typedef unsigned char Byte;

typedef enum {
	EXIT,
	READ_CITY,
	SHOW_CITY,
	SHOW_GARDEN,
	WRITE_CITY,
	ADD_GARDEN,
	ADD_CHILD,
	CHILD_BIRTHDAY,
	COUNT_GRADUATE,
	SORT_KINDERGARTENS_BY_NAME,
	SORT_CHILDREN_BY_ID,
	SORT_KINDERGARTENS_BY_TYPE_AND_CHILDREN_COUNT,
	NofOptions
} MenuOptions;

int menu();
char* getStrExactLength(char* inpStr);
int checkAllocation(const void* p);
void insertionSort(void* arr, int size, int elementSize,
		int (*compare)(const void*,const void*));
void printSortCompleted();
void variadicPrint(char* str, ...);
#endif
