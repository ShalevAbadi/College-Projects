
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "utilities.h"

void printMatrix(int rows,int cols, int * firstIndexPointer) {
	int index = 0;
	for (int j = 0; j < rows; j++) {
		for (int i = 0; i < cols; i++) {
			printf("%3d  ", *(firstIndexPointer + index));
			index++;
		}
		printf("\n");
	}
		printf("\n");
}

void swap(int first, int second, int * firstIndexPointer) {
	int temp = *(firstIndexPointer + first);
	*(firstIndexPointer + first) = *(firstIndexPointer + second);
	*(firstIndexPointer + second) = temp;
}

int randomFromRange(int lower, int upper){
	int res = (rand() % (upper - lower + 1)) + lower;
	return res;
}

void clearBuffer(){
	char garbage;
	do{
		scanf("%c", &garbage);
	}while(garbage != '\n');
}

