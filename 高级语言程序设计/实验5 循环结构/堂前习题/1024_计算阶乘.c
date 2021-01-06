#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	int n;
	scanf("%d", &n);
	long long sum = 1;
	if (n < 0) {
		printf("0");
		return 0;
	}
	for (int i = n; i >= 1; i--) {
		sum *= i;
	}
	printf("%ld", sum);
	return 0;
}
