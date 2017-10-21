#include<iostream>
#include<string>
#include<cstdio>
using namespace std;
int main(){
	int n;
	cin >> n;
	for(int i = 0; i < n; i++){
		string str;
		cin >> str;
		if(str.length() <= 10){
			cout<<str<<endl;
		}
		else{
			int size = str.length()-2;
			printf("%c%u%c\n",str[0],size,str[str.length()-1]);
		}
	}
	return 0;
}
