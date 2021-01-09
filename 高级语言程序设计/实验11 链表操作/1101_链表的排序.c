#include <stdio.h>
#include <malloc.h>
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

struct student *insert(struct student *head, struct student *stud) {
	struct student *p0,*p1,*p2;
	p1=head;
	p0=stud;
	if(head==NULL) {
		head=p0;
	} else {
		while( (p0->num > p1->num) && (p1->next!=NULL) ) {
			p2=p1;
			p1=p1->next;
		}
		if( p0->num <= p1->num ) {
			if( head==p1 ) head=p0;
			else p2->next=p0;
			p0->next=p1;
		} else {
			p1->next=p0;
		}
	}
	return(head);
}

struct student *del(struct student *head,long num) {
	struct student *p1,*p2;
	p1=head;
	while(p1!=NULL) {
		if(p1->num == num) {
			if(p1 == head) head=p1->next;
			else p2->next=p1->next;
			free(p1);
			break;
		}
		p2=p1;
		p1=p1->next;
	}
	return(head);
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

struct student *sort(struct student *head) {
	if (head == NULL) {
		return NULL;
	} 
	if (head->next == NULL) {
		return head;
	}
	
	struct student *p = head;
	struct student *tmep, *q, *minNode;
	struct student *newHead = (struct student *)malloc(LEN);
	newHead->next = NULL;
	while (p) {
		q = p;
		long minVal = q->num;
		minNode = q;
		while (q) {
			if (minVal > q->num) {
				minVal = q->num;
				minNode = q;
			}
			q = q->next;
		}
		struct student *newNode = (struct student *)malloc(LEN);
		newNode->num = minNode->num;
		newNode->score = minNode->score;
		newNode->next = NULL; 
		newHead->next = insert(newHead->next, newNode);
		p = del(p, minNode->num);
	}
	return newHead->next;
	
}

int main() {

	struct student *head,*stu;
    int n;
    scanf("%d",&n);
    head=create(n);
    print(head);
    head=sort(head);
    print(head);

	return 0;
}



