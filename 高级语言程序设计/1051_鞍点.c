#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
	
	int nums[3][4];
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 4; j++) {
			scanf("%d", &nums[i][j]);
		}
	}
	int flag;
	for (int i = 0; i < 3; i++) {
		flag = 1;
		int rowMax = nums[i][0];
		int maxIndex = 0;
		for (int j = 1; j < 4; j++) {
			if (rowMax < nums[i][j]) {
				rowMax = nums[i][j];
				maxIndex = j;
			}
		}
		for (int k = 0; k < 3; k++) {
			if (nums[k][maxIndex] < rowMax) {
				flag = 0;
				break;
			}
		}
		if (flag) {
			printf("%d", rowMax);
			return 0;
		}
		
	}
	printf("NO");
	return 0;
}
