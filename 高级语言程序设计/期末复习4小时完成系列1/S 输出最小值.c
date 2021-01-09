#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main() {

	int nums[10];
	for (int i = 0; i < 10; i++) {
		scanf("%d", nums + i);
	}
	int minVal = nums[0];
	for (int i = 1; i < 10; i++) {
		minVal = minVal < nums[i] ? minVal : nums[i];
	}
	printf("%d", minVal);
	
	return 0;
}



