#include <stdio.h>
#include <string.h>
#include <math.h>
#include "malloc.h"
#define LEN sizeof(struct DATA)

struct DATA {
	long num;
	struct DATA *next;
};

struct DATA *create(int n) {
	struct DATA *head=NULL,*p1=NULL,*p2=NULL;
	int i;
	for(i=1; i<=n; i++) {
		p1=(struct DATA *)malloc(LEN);
		scanf("%ld",&p1->num);
		p1->next=NULL;
		if(i==1) head=p1;
		else p2->next=p1;
		p2=p1;
	}
	return(head);
}

struct DATA *merge(struct DATA *head, struct DATA *head2) {
	if (head == NULL) {
		head = head2;
	}
	if (head2 == NULL) {
		return head;
	}
	struct DATA *p = head;
	while (p->next != NULL) {
		p = p->next;
	}
	p->next = head2;
	return head;
}

struct DATA *insert(struct DATA *head, struct DATA *d) {
	if (head == NULL) {
		return d;
	}
	struct DATA *q = head, *p;
	while (q->num < d->num && q->next != NULL) {
		p = q;
		q = q->next;
	}
	if (q->num >= d->num) {
		if (head == q) {
			head = d;
		} else {
			p->next = d;
		}
		d->next = q;
	} else {
		q->next = d;
	}
	return head;
}

struct DATA *sort(struct DATA *head) {
	struct DATA *newHead = NULL;
	if (head == NULL) {
		return NULL;
	}
	struct DATA *q = head;
	while (q) {
		struct DATA *newNode = (struct DATA *)malloc(LEN);
		newNode->next = NULL;
		newNode->num = q->num;
		newHead = insert(newHead, newNode);
		q = q->next;
	}
	head = newHead;
	return head;
}

void print(struct DATA *head) {
	struct DATA *p;
	p=head;
	while(p!=NULL) {
		printf("%ld",p->num);
		p=p->next;
		printf("\n");
	}
}


int main() {

	struct DATA *head, *head2;
	int n;
	long del_num;
	scanf("%d",&n);
	head=create(n);
	scanf("%d",&n);
	head2=create(n);
	head = merge(head, head2);
	head = sort(head);
	print(head);
	return 0;
}
