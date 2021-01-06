#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	char str[256] = {'\0'};
	gets(str);
	int count = 0, i = 0;
  // 先第一个字符是否为空格，如果不是先加1
	if (str[0] != ' ') {
		count++;
		i++;
	}
	for (; str[i] != '\0'; i++) {
  // 前面一个字符为空格，后面一个字符不是空格，则可以看成是一个单词
		if (str[i] != ' ' && str[i - 1] == ' ') {
			count++;
		}
	}
	
	printf("%d", count);
		
	return 0;
}



