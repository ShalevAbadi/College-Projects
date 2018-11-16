
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "generalMethods.h"

void printMatrix(int rows,int cols, int * p) {
	int index = 0;
	for (int j = 0; j < rows; j++) {
		for (int i = 0; i < cols; i++) {
			printf("%3d  ", *(p + index));
			index += 1;
		}
		printf("\n");
	}
		printf("\n");
}

void swap(int first, int second, int * arr) {
	int temp = *(arr + first);
	*(arr + first) = *(arr + second);
	*(arr + second) = temp;
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

