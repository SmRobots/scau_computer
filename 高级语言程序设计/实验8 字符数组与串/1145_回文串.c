#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main() {

	char str[81];
	gets(str);
	int len = strlen(str);	// 计算字符串的长度 
	// 0与len-1比较，1与len-2比较,2与len-3比较 
	for (int i = 0; i < len / 2; i++) {
		if (str[i] != str[len - i - 1]) {
			printf("N");
			return 0;
		}
	}
	printf("Y");
	
	return 0;
}



