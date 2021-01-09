#include <stdio.h>

int main() {

	int x;
	scanf("%d", &x);
	if (x < 0) {
		printf("negative\n");
	} else {
		printf("positive\n");
	}
	if (x % 2 == 0) {
		printf("even");
	} else {
		printf("odd");
	}

	return 0;
}



