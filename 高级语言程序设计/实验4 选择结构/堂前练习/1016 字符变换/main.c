#include <stdio.h>

int main() {
	
	char ch1 = getchar();
	char ch2 = getchar();
	char ch3 = getchar();
	char ch4 = getchar();
	char ch5 = getchar();
	
  // 大写字母和小写字母的ASCII码的值差32
	if (ch1 >= 'A' && ch1 <= 'Z') {
		putchar(ch1 + 32);
	} else {
		putchar(ch1);
	}
	
	if (ch2 >= 'A' && ch2 <= 'Z') {
		putchar(ch2 + 32);
	} else {
		putchar(ch2);
	}
	
	if (ch3 >= 'A' && ch3 <= 'Z') {
		putchar(ch3 + 32);
	} else {
		putchar(ch3);
	}
	
	if (ch4 >= 'A' && ch4 <= 'Z') {
		putchar(ch4 + 32);
	} else {
		putchar(ch4);
	}
	
	if (ch5 >= 'A' && ch5 <= 'Z') {
		putchar(ch5 + 32);
	} else {
		putchar(ch5);
	}


//	char chs[5];
//	for (int i = 0; i < 5; i++) {
//		scanf("%c", &chs[i]);
//	}
//	for (int i = 0; i < 5; i++) {
//		if (chs[i] >= 'A' && chs[i] <= 'Z') {
//			chs[i] += 32; 
//		}
//	}
//	printf("%s", chs);
	
	
	return 0;
}
