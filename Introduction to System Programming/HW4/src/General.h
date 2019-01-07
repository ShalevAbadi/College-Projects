#ifndef __PROTOTYPE__
#define __PROTOTYPE__

typedef unsigned char Byte;

typedef enum
{
	EXIT,
	READ_CITY,
	SHOW_CITY,
	SHOW_GARDEN,
	WRITE_CITY,
	ADD_GARDEN,
	ADD_CHILD,
	CHILD_BIRTHDAY,
	COUNT_GRADUATE,
	NofOptions
} MenuOptions;


int		menu();
char*	getStrExactLength(char* inpStr);
int		checkAllocation(const void* p);




#endif
