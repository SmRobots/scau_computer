#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
	
	int nums[10];
	for (int i = 0; i < 10; i++) {
		scanf("%d", nums + i);
	}
	int flag;
	for (int i = 0; i < 10; i++) {
		flag = 1;
		for (int j = 0; j < i; j++) {
			if (nums[j] == nums[i]) {
				flag = 0;
			}
		}
		if (flag) {
			printf("%d\n", nums[i]);
		}
	}
	
	return 0;
}
