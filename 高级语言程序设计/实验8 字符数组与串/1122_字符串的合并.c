#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main() {

	char s[100]="";
    char a[30];
    char b[30];
    // 输入3个字符串 
	gets(s);
	gets(a);
	gets(b);
	// 调用strcat合并两个字符串 
	strcat(s, a);
	strcat(s, b);            
    printf("%s", s);
	
	return 0;
}



