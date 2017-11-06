#include<iostream>
using namespace std;

int main() {
	int n;
	int maxOne = 0;
	int maxTwo = 0;
	cin >> n;
	int pOne = 0;
	int pTwo = 0;
	for(int i = 0; i < n; i++) {
		int one, two;
		cin >> one >> two;
		pOne += one;
		pTwo += two;
		if(pOne > pTwo) {
			cout <<pOne-pTwo<<endl;
			if(pOne-pTwo > maxOne) {
				maxOne = pOne-pTwo;
			}
		}
		else if(pTwo > pOne){
			cout<<pTwo-pOne<<endl;
			if(pTwo-pOne > maxTwo) {
				maxTwo = pTwo-pOne;
			}
		}
	}
	if(maxOne > maxTwo) {
		cout << "1 " << maxOne;
	}
	else if(maxTwo > maxOne) {
		cout << "2 " << maxTwo;
	}
	return 0;
}
