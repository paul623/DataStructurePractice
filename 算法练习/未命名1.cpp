#include<iostream>
#include<iomanip>
using namespace std;

int getMaxAndMinAndAver(int grades[],int totalNum){
	int max=grades[0];
	int min=grades[0];
	int sum=0;
	for(int i=0;i<totalNum;i++){
		if(max<grades[i]){
			max=grades[i];
		}
		if(min>grades[i]){
			min=grades[i];
		}
		sum=sum+grades[i];
	}
	cout<<totalNum<<endl;
	cout<<max<<endl;
	cout<<min<<endl;
	double aver=(1.0*sum)/(totalNum);
	cout<<setiosflags(ios::fixed)<<setprecision(1)<<aver<<endl;
} 
int main(){
	int num;
	cin>>num;
	int cinNum;
	for(int i=0;i<num;i++){
		int totalNum=0;
		int *grades=new int[100];
		while(true){
			cin>>cinNum;
			if(cinNum==-1){
				getMaxAndMinAndAver(grades,totalNum);
				break;
			}else{
				grades[totalNum]=cinNum;
				totalNum++;
			}
		}
	}
	return 0;
} 

   

