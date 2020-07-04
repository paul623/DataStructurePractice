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
���ڳ���Ϊn��˳���L����дһ��ʱ�临�Ӷ�ΪO��n�����ռ临�Ӷ�ΪO��1�����㷨��
���㷨ɾ�����Ա�������ֵΪx��Ԫ��
���ֽⷨdeleteMassEnd��deleteMassStart
*/
void deleteMassEnd(SqList & list,int x) {
	int k = 0;//��¼������x�ĸ���
	for (int i = 0; i < list.length; i++) {
		if (list.data[i] != x) {
			list.data[k] = list.data[i];
			k++;
		}
	}
	list.length = k;
}
void deleteMassStart(SqList& list, int x) {
	int k = 0,i=0;//��¼����x�ĸ���
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
		cout << endl << "������Ҫɾ����Ԫ��:";
		cin >> x;
		deleteMassStart(list, x);
		if (list.length == 0) {
			cout << endl<<"���Ѿ����Ϳա�����" << endl;
			return 0;
		}
	}
	
	return 0;
}