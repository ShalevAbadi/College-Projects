/*
 * pictureManipulationPrintMenu.c
 *
 *  Created on: Nov 10, 2018
 *      Author: shale
 */
#include <stdio.h>
#include "pictureManipulationPrintMenu.h"

void pictureManipulationPrintMenu() {
	char menu[] =
			"Please choose one of the following options\n1 - 90 degree clockwise\n2 - 90 degree counter clockwise\n3 - Flip Horizontal\n4 - Flip Vertical\n-1 - Quit\n";
	printf("%s", menu);
}
