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
	cout<<"位置："<<e.location<<"密码："<<e.password<<endl;
}
//出列
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
		cout<<endl<<"第"<<k-n+1<<"个出列的位序是"<<s->data.location;
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
	cout<<"约瑟夫环"<<endl<<endl;
	cout<<"请输入人数:";
	cin>>n;
	cout<<endl<<"请输入第一个人密码";
	cin>>e.password;
	e.location=1;
	ListInsert(L,1,e);
	for(int i=2;i<=n;i++){
		cout<<"请输入第"<<i<<"人密码:";
		cin>>e.password;
		e.location=i;
		ListAppend(L,e);
	}
	cout<<endl<<"当前链表中数据元素依次为："<<endl<<endl;
    ListTraverse(L,Print);
	cout<<endl<<"请输入初始密码:";
	cin>>m;
	Ysfring(L,n,m);
	cout<<endl<<endl;
	system("pause");
	return 0;
}

