#include<iostream>
using namespace std;
struct SqList {
	int* data;
	int length;
	int MaxSize;
	SqList(int max) {
		MaxSize = max;
		data = new int[MaxSize];
		length = 0;
	}
};
void initList(SqList &list) {
	list.length = list.MaxSize;
	int max = list.length;
	list.data = new int[list.length];
	for (int i = 0; i < max; i++) {
		list.data[i] = rand() % 8;
	}
}
void print(SqList list) {
	for (int i = 0; i < list.length; i++) {
		cout << list.data[i] << "\t ";
	}
}
/*
对于长度为n的顺序表L，编写一个时间复杂度为O（n）、空间复杂度为O（1）的算法，
该算法删除线性表中所有值为x的元素
两种解法deleteMassEnd，deleteMassStart
*/
void deleteMassEnd(SqList & list,int x) {
	int k = 0;//记录不等于x的个数
	for (int i = 0; i < list.length; i++) {
		if (list.data[i] != x) {
			list.data[k] = list.data[i];
			k++;
		}
	}
	list.length = k;
}
void deleteMassStart(SqList& list, int x) {
	int k = 0,i=0;//记录等于x的个数
	while (i < list.length) {
		if (list.data[i] == x) {
			k++;
		}
		else {
			list.data[i - k] = list.data[i];
		}
		i++;
	}
	list.length = list.length-k;
}

int main() {
	int x=0;
	SqList list =SqList(10) ;
	cout << "Hello!" << endl;
	initList(list);
	while (x != -1) {
		cout << endl;
		print(list);
		cout << endl << "请输入要删除的元素:";
		cin >> x;
		deleteMassStart(list, x);
		if (list.length == 0) {
			cout << endl<<"我已经被掏空。。。" << endl;
			return 0;
		}
	}
	
	return 0;
}