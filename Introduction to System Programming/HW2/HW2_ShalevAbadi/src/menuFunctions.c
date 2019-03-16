/*
 * menuFunctions.c
 *
 *  Created on: Nov 27, 2018
 *      Author: shale
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "menuFunctions.h"

#define SPECIAL_CHARS ",:?- "

void initString(char *str, int MAX_LEN) {
	printf("Please enter string:\n");
	getchar();
	fgets(str, MAX_LEN, stdin);
	str[strcspn(str, "\n")] = '\0';
}

void printString(char *str) {
	puts(str);
	printf("\n");
}

int countWords(char *str) {
	int index = 0, counter = 0, length = 0;
	while (str[index] != '\0') {
		length = searchWordLength(str + index);
		if (length > 0) {
			counter++;
			index += length;
		} else {
			index++;
		}
	}
	return counter;
}

int searchWordLength(char *strToSearch) {
	int counter = 0;
	while (strchr(SPECIAL_CHARS, strToSearch[counter]) == NULL) {
		counter++;
	}
	return counter;
}

void longestInCapital(char *str) {
	int longestStart = 0, longestEnd = 0;
	searchLongestWord(str, &longestStart, &longestEnd);
	upperLongestWord(str, longestStart, longestEnd);
}

void searchLongestWord(char *str, int *longestStart, int *longestEnd) {
	int currentStart = 0, currentEnd = 0;
	while (str[currentStart] != '\0') {
		currentEnd = currentStart + searchWordLength(str + currentStart);
		setLongestaStartAndEnd(currentEnd, currentStart, longestEnd,
				longestStart);
		currentStart = currentEnd + 1;
	}
}

void setLongestaStartAndEnd(int currentEnd, int currentStart, int *longestEnd,
		int *longestStart) {
	if ((currentEnd - currentStart) > (*longestEnd - *longestStart)) {
		*longestEnd = currentEnd;
		*longestStart = currentStart;
	}
}

void upperLongestWord(char *str, int start, int end) {
	for (int i = start; i <= end; i++) {
		str[i] = toupper(str[i]);
	}
}

void revertWords(char *str) {
	int index = 0, length = 0;
	char newSpecial = '*';

	while (str[index] != '\0') {
		length = searchWordLength(str + index);
		if (length > 0) {
			revertOneWord(str, index, index + length - 1);
			index += length;
		} else {
			if (isSpecialChar(str[index])) {
				str[index] = newSpecial;
			}
			index++;
		}
	}
}

int isSpecialChar(char ch) {
	return (strchr(SPECIAL_CHARS, ch) != NULL);
}

void revertOneWord(char *str, int startIndex, int endIndex) {
	for (; startIndex < endIndex; startIndex++, endIndex--) {
		swap(startIndex, endIndex, str);
	}
}

void swap(int index1, int index2, char* str) {
	str[index1] = str[index1] + str[index2];
	str[index2] = str[index1] - str[index2];
	str[index1] = str[index1] - str[index2];
}

void eraseCharsFromString(char *str, const char *symbols) {
	int strIndex = 0;
	int lettersIndex = 0;
	while (str[strIndex] != '\0') {
		if (strchr(symbols, str[strIndex]) == NULL) {
			str[lettersIndex] = str[strIndex];
			lettersIndex++;
		}
		strIndex++;
	}
	str[lettersIndex] = '\0';
}

int isPalindrome(const char *str) {
	const char *begin = str;
	const char *end = &str[strcspn(str, "\n")];
	while (end > begin) {
		while (!isalpha(*end) && end > begin) {
			end--;
		}
		while (!isalpha(*begin) && end > begin) {
			begin++;
		}
		if (toupper(*end) != toupper(*begin)) {
			return 0;
		}
		end--;
		begin++;
	}
	return 1;
}
