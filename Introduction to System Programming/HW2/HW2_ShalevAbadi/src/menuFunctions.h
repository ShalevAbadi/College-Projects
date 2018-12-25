/*
 * menuFunctions.h
 *
 *  Created on: Nov 27, 2018
 *      Author: shale
 */

#ifndef MENUFUNCTIONS_H_
#define MENUFUNCTIONS_H_

void initString(char *str, int MAX_LEN);
void printString(char *str);
int countWords(char *str);
int searchWordLength(char *strToSearch);
void longestInCapital(char *str);
void setLongestaStartAndEnd(int currentEnd, int currentStart, int *longestEnd,
		int *longestStart);
void upperLongestWord(char *str, int start, int end);
void searchLongestWord(char *str, int *longestStart, int *longestEnd);
void revertWords(char *str);
int isSpecialChar(char ch);
void revertOneWord(char *str, int startIndex, int endIndex);
void swap(int index1, int index2, char* str);
void eraseCharsFromString(char *str, const char *symbols);
int isPalindrome(const char *str);

#endif /* MENUFUNCTIONS_H_ */
