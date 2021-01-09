#include <stdio.h>

int main() {
  // 这道题不用我们判断是否空指针错误
	FILE *fp = fopen("answer.txt", "w");
	char ch;
	while ((ch = getchar()) != EOF) {
		fputc(ch, fp);
		if (ch == 'b') {
			char _y = getchar();
			fputc(_y, fp);
			char _e = getchar();
			fputc(_e, fp);
			if (_y == 'y' && _e == 'e') {
				break;
			}
		}
		
	}
	fclose(fp);
	// 处理后面可能的输入 
	if (ch != EOF) {
		while ((ch = getchar()) != EOF);
	} 

}
