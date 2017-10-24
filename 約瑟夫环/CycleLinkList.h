#ifndef _CycleLinkList_
#define _CycleLinkList_

//���
struct LNode{
	ElemType data;
	LNode *next;
	LNode *prior;
};
struct CycleLinkList{
	struct LNode *head;
	struct LNode *tail;
};
//��ʼ��
void InitList(CycleLinkList &L){
	L.head=L.tail=NULL;
}
//�ж��Ƿ�Ϊ�ձ�
bool ListEmpty(CycleLinkList &L){
	return !L.head;
}
//�ͷŽ��
void ClearList(CycleLinkList &L){
	if(L.head){
		LNode *p=L.head,*q;
		while(p!=L.tail){
			q=p->next;
			delete p;
			p=q;
		}
		delete L.tail;
		L.head=L.tail=NULL;
	}
}
//���ٱ�
void DestroyList(CycleLinkList L){
	ClearList(L);
}
//�󳤶�
int ListLength(CycleLinkList L){
	if(!L.head)
		return 0;
	int k=1;
	LNode *p=L.head;
	while(p!=L.tail){
		p=p->next;
		k++;
	}
	return k;
}
//ȡ��i��ֵ
bool GetElem(CycleLinkList L,ElemType &e,int i){
	if(i<1||!L.head)
		return false;
	LNode *p=L.head;
	if(i==1)
		e=p->data;
	else
	{
		p=p->next;
		int k=2;
		while(p!=L.head&&k<i)
		{
			p=p->next;
			k++;
		}
		if(p==L.head)
			return false;
		e=p->data;
	}
	return true;
}
//����
bool ListInsert(CycleLinkList &L,int i,ElemType e){
	LNode *p,*s;
	if(i<1)
		return false;
	if(i==1){
		s=new LNode;
		s->data=e;
		if(!L.head)
			L.head=L.tail=s;
		else{
			s->next=L.head;
			s->prior=L.head;
			L.head->next=s;
			L.head->prior=s;
			L.head=s;
		}
		L.tail->next=L.head;
		L.head->prior=L.tail;
	}
	else{
		p=L.head;
		int j=1;
		while(p!=L.tail&&j<i-1){
			p=p->next;
			j++;
		}
		if(p==L.head)
			return false;
		else{
			s=new LNode;
			s->data=e;
			s->next=p->next;
			p->next->prior=s;
			s->prior=p;
			p->next=s;
		}
	}
	return true;
}
//��β����
void ListAppend(CycleLinkList &L,ElemType e){
	struct LNode *s;
	s=new LNode;
	s->data=e;
	s->next=L.tail->next;
	s->prior=L.tail;
	L.tail->next=s;
	L.tail=s;
	L.head->prior=L.tail;
}
//ɾ����i��
bool ListDelete(CycleLinkList &L,int i,ElemType &e)
{
	LNode *p,*s;
	if(i<1||!L.head)
		return false;
	if(i==1){
		s=L.head;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		e=s->data;
		if(L.head==L.tail)
			L.head=L.tail=NULL;
		else
			L.head=L.tail->next=L.head->next;
		    L.head->prior=L.tail;
		delete s;
	}
	else{
		p=L.head;
		int j=1;
		while(p!=L.tail&&j<i-1){
			p=p->next;
			j++;
		}
		if(p==L.tail)
			return false;
		else{
			s=p->next;
			p->next=s->next;
			e=s->data;
			if(L.tail==s)
				L.tail=p;
			delete s;
		}
	}
	return true;
}
//����
int LocateElem(CycleLinkList &L,ElemType &e,
			   bool (*Compare)(ElemType &e1,ElemType &e2))
{
	if(!L.head)
		return 0;
	int k=1;
	LNode *p=L.head;
	while(p!=L.tail&&!Compare(p->data,e)){
		k++;
		p=p->next;
	}
	if(p!=L.tail)
		return k;
	else if(Compare(p->data,e))
		return k+1;
	else
		return 0;
}
//����
void ListTraverse(CycleLinkList &L,void(*Visit)(ElemType &e)){
	LNode *p=L.head;
	if(p){
		while(p!=L.tail){
			Visit(p->data);
			p=p->next;
		}
		Visit(p->data);
	}
}


#endif