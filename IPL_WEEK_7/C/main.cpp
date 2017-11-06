#include<iostream>
#include<string>
#include<algorithm>
#include<cmath>
using namespace std;

int main() {
	int n;
	cin >> n;
	string org, fin;
	cin >> org >> fin;
	int count = 0;
	for(int i = 0; i < n; i++){
		int a = org[i]-'0';
		int b = fin[i]-'0';
		count += min(abs(a-b),10-abs(a-b));
	}
	cout << count;
	return 0;
}
