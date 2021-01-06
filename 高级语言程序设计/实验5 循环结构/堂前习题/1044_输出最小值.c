#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	int nums[10];
	for (int i = 0; i < 10; i++) {
		scanf("%d", nums + i);
	}
	int min = nums[0];	// 假设第一个值为最小值
	for (int i = 1; i < 10; i++) {
		if (min > nums[i]) {
			min = nums[i];
		}
	} 
	printf("%d", min);
	return 0;
}
