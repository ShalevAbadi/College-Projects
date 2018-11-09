#include <stdio.h>
#include "printMenu.h"
char menuStr[] = "Please choose one of the following options\nP/p - Picture Manipulation\nN/n - Number Game\nE/e - Quit";

void printMenu(){
	printf("%s", menuStr);
}
