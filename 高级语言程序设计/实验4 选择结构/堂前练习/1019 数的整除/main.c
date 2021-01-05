#include <stdio.h>

int main() {
	
	int a, b, c, d, e;
	scanf("%d%d%d%d%d", &a, &b, &c, &d, &e);
	if (a % 27 == 0) {
		printf("YES\n");
	} else {
		printf("NO\n");
	}
	if (b % 27 == 0) {
		printf("YES\n");
	} else {
		printf("NO\n");
	}
	if (c % 27 == 0) {
		printf("YES\n");
	} else {
		printf("NO\n");
	}
	if (d % 27 == 0) {
		printf("YES\n");
	} else {
		printf("NO\n");
	}
	if (e % 27 == 0) {
		printf("YES\n");
	} else {
		printf("NO\n");
	}
	
//	int nums[5];
//	for (int i = 0; i < 5; i++) {
//		scanf("%d", nums + i);
//	} 
//	for (int i = 0; i < 5; i++) {
//		if (nums[i] % 27 == 0) {
//			printf("YES\n");
//		} else {
//			printf("NO\n");
//		}
//	}
	
	return 0;
}
