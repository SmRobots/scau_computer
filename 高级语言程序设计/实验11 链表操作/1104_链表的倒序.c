#include <stdio.h>
#define LEN sizeof(struct student)

struct student {
	long num;
	int score;
	struct student *next;
};

struct student *create(int n) {
	struct student *head=NULL,*p1=NULL,*p2=NULL;
	int i;
	for(i=1; i<=n; i++) {
		p1=(struct student *)malloc(LEN);
		scanf("%ld",&p1->num);
		scanf("%d",&p1->score);
		p1->next=NULL;
		if(i==1) head=p1;
		else p2->next=p1;
		p2=p1;
	}
	return(head);
}

struct student *reverse(struct student *head) {
	struct student *newHead = (struct student *)malloc(LEN);
	newHead->next = NULL;
	if (head == NULL) {
		return NULL;
	}
	struct student *p = head;
	while (p) {
		// 创建一个新节点进行头插入法插入新的链表中 
		struct student *newNode = (struct student *)malloc(LEN);
		newNode->num = p->num;
		newNode->score = p->score;
		newNode->next = newHead->next;
		newHead->next = newNode;
		p = p->next;
	}
	// 返回新链表的下一个元素才是原有链表中的元素 
	return newHead->next; 
}


void print(struct student *head) {
	struct student *p;
	p=head;
	while(p!=NULL) {
		printf("%8ld%8d",p->num,p->score);
		p=p->next;
		printf("\n");
	}
}

int main() {

	struct student *head,*stu;
	int n;
	scanf("%d",&n);
	head=create(n);
	print(head);
	head=reverse(head);
	print(head);

	return 0;
}



