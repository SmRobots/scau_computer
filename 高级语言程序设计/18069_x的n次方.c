#include <stdio.h>
#include <string.h>
#include <math.h>

int F(int x, int n) {
	if(n == 1) return x;
	else return n % 2 == 0 ? F(x, n / 2) * F(x, n / 2) : F(x, n / 2) * F(x, n / 2) * x;
}


int main() {

	int x, n;
	scanf("%d%d", &x, &n);
	printf("%d", F(x, n));
	return 0;
}
