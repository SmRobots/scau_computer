#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

// 采用递归的方式进行遍历
void binary(int n) {
	if (n == 0) {
		return ;
	}
	// 获取余数 
	int a = n % 2;
	binary(n / 2);
	printf("%d", a);
}

int main() {

	int n;
    scanf("%d", &n);
    binary(n);
	return 0;
}



