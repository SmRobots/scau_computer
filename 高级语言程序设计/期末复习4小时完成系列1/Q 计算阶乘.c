#include <stdio.h>
#include <stdlib.h>
#include <math.h>

long long f(int n) {
	if (n == 1) {
		return 1;
	}
	return n * f(n - 1);
}

int main() {

	int n;
	scanf("%d", &n);
	printf("%ld", f(n));
	return 0;
}



