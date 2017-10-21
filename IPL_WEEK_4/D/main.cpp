#include<iostream>
#include<string>
using namespace std;
int main() {
	int n; 
	cin >> n;
	char x = '?';
	char o = '?';
	for(int i = 0; i< n; i++){
		string s;
		cin >> s;
		for(int j = 0; j <n; j++){
			char c = s[j];
			if(i==j||i == n-j-1){
				if(x == '?'){
					x = c;
				}
				else if(x != c) {
					cout <<"NO"<<endl;
					return 0;
				}
			}
			else {
				if(o == '?'){
					o = c;
				}
				else if(o != c){
					cout<<"NO"<<endl;
					return 0;
				}
			}
		}
	}
	if(x == o){
		cout<<"NO"<<endl;
		return 0;
	}
	cout<<"YES"<<endl;
	return 0;
}
