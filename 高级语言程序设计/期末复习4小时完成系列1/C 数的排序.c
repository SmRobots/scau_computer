#include <stdio.h>

int main() {

	int nums[3];
	int temp;
	scanf("%d,%d,%d", nums + 0, nums + 1, nums + 2);
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2 - i; j++) {
			if (nums[j] > nums[j + 1]) {
				temp = nums[j];
				nums[j] = nums[j + 1];
				nums[j + 1] = temp;
			}
		}
	}
	printf("%d,%d,%d", nums[0], nums[1], nums[2]);

	return 0;
}



