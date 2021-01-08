#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

// 按照题目的定义来写就行了
int F(int x) {
	if (x < 3) {
		return x;
	}
	if (x >= 3 && x % 3 == 0) {
		return F(x / 3) * 2;
	}
	if (x >= 3 && x % 3 == 1) {
		return F((x - 1) / 3) + 1;
	}
	if (x >= 3 && x % 3 == 2) {
		return F((x - 2) / 3) + 2;
	}
} 

int main() {

	int x;
	scanf("%d", &x);
	printf("%d", F(x));
	
	return 0;
}



