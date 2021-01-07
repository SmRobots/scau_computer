#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	int nums[3][4];
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 4; j++) {
			//scanf("%d", *(nums + i) + j);
      scanf("%d", &nums[i][j]);
		}
	} 
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 3; j++) {
			printf("%d ", nums[j][i]);
		}
		printf("\n");
	}
	
	
	return 0;
}



