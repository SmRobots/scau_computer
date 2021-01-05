#include <stdio.h>

int main() {
	
	int x;
	scanf("%d", &x);
	if (x > 0) {
		printf("positive\n");
	} else {
		printf("negative\n");
	}
	if (x % 2 == 0) {
		printf("even\n");
	} else {
		printf("odd");
	}
	
	return 0;
}
