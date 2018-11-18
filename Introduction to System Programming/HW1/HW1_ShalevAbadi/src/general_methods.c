
#include "general_methods.h"

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void print_matrix(int rows,int cols, int * first_index_pointer) {
	int index = 0;
	for (int j = 0; j < rows; j++) {
		for (int i = 0; i < cols; i++) {
			printf("%3d  ", *(first_index_pointer + index));
			index++;
		}
		printf("\n");
	}
		printf("\n");
}

void swap(int first, int second, int * first_index_pointer) {
	int temp = *(first_index_pointer + first);
	*(first_index_pointer + first) = *(first_index_pointer + second);
	*(first_index_pointer + second) = temp;
}

int random_from_range(int lower, int upper){
	int res = (rand() % (upper - lower + 1)) + lower;
	return res;
}

void clear_buffer(){
	char garbage;
	do{
		scanf("%c", &garbage);
	}while(garbage != '\n');
}

