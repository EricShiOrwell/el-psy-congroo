#include<iostream>
using namespace std;

struct ElemType{
	int location;
	int password;
};

#include"CycleLinkList.h"

bool Equal(ElemType &a,ElemType &b){
	if(a.location==b.location&&a.password==b.password)
		return true;
	else 
		return false;
}
void Print(ElemType &e){
	cout<<"λ�ã�"<<e.location<<"���룺"<<e.password<<endl;
}
//����
void Ysfring(CycleLinkList &L,int n,int m){
	struct LNode *current=L.tail,*s;
	ElemType e;
	int k=n;
	while(n>0){
		m=m%n;
		if(m==0)
			m=n;
		for(int j=1;j<m;j++)
			current=current->next;
		s=current->next;
		current->next=s->next;
		cout<<endl<<"��"<<k-n+1<<"�����е�λ����"<<s->data.location;
		m=s->data.password;
		delete s;
		n--;
	}
	L.head=L.tail=NULL;
}
int main(){
	CycleLinkList L;
	InitList(L);
	int n,m;
	ElemType e;
	cout<<"Լɪ��"<<endl<<endl;
	cout<<"����������:";
	cin>>n;
	cout<<endl<<"�������һ��������";
	cin>>e.password;
	e.location=1;
	ListInsert(L,1,e);
	for(int i=2;i<=n;i++){
		cout<<"�������"<<i<<"������:";
		cin>>e.password;
		e.location=i;
		ListAppend(L,e);
	}
	cout<<endl<<"��ǰ����������Ԫ������Ϊ��"<<endl<<endl;
    ListTraverse(L,Print);
	cout<<endl<<"�������ʼ����:";
	cin>>m;
	Ysfring(L,n,m);
	cout<<endl<<endl;
	system("pause");
	return 0;
}

