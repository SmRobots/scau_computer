#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {

	double d, p, r;
	scanf("%lf%lf%lf", &d, &p, &r);
	if (d == 0) { // 没有待还款
		printf("0.0");
		return 0;
	}
	if (p == 0) { // 每月还款金额为0
		printf("God");
		return 0;
	}
	if (p - d * r <= 0.00001) {
		printf("God");
		return 0;
	}
	if (r <= 0.00001) {
		printf("God");
		return 0;
	}
	double m = log(p / (p - d * r)) / log(1 + r);
	printf("%.1lf", m);
	return 0;
}



