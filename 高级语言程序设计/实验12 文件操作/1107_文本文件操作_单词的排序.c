#include <stdio.h>
#include <string.h>

int main() {

	FILE *fp;
	char w[10000][10], a[10], temp[10];
	int n = 0;
	if ((fp = fopen("case1.in", "r")) == NULL) {
		return 1;
	}
	while ((fgets(w[n], 10, fp)) != NULL) {
		n++;
	}
	fclose(fp);
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n - i - 1; j++) {
			if (strcmp(w[j], w[j + 1]) > 0) {
				strcpy(temp, w[j]);
				strcpy(w[j], w[j + 1]);
				strcpy(w[j + 1], temp);
			}
		}
	}
	if ((fp = fopen("answer.txt", "w")) == NULL) {
		return 1;
	}
	for (int i = 0; i < n; i++){
		fputs(w[i], fp);
	}
	
	fclose(fp);
  
  // 注意这里不要写return 语句才能通过。。。

}



