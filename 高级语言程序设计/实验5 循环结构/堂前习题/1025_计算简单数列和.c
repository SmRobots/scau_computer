#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	int n;
	scanf("%d", &n);
	int a1 = 1;
	int d = 2;
	long long sum = a1 * n + n * (n - 1) / 2 * d;
	printf("%ld", sum);
	
	return 0;
}
