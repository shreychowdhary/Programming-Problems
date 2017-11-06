#include<iostream>
#include<utility>
using namespace std;

int main() {
	int a,b;
	cin >> a >> b;
	pair<int,int> p1 = make_pair(a,b);
	cin >> a >> b;
	pair<int,int> p2 = make_pair(a,b);
	cin >> a >> b;
	pair<int,int> p3 = make_pair(a,b);
	cin >> a >> b;
	pair<int,int> p4 = make_pair(a,b);
	
	if(p1.first > p3.first && p2.second > p4.second) {
		cout << "Team 1";
	} else if(p1.first > p4.first && p2.second > p3.second) {
		cout << "Team 1";
	} else if(p2.first > p3.first && p1.second > p4.second) {
		cout << "Team 1";
	} else if(p2.first > p4.first && p1.second > p3.second) {
		cout << "Team 1";
	} else if(p1.first < p3.first && p2.second < p4.second) {
		cout << "Team 2";
	} else if(p1.first < p4.first && p2.second < p3.second) {
		cout << "Team 2";
	} else if(p2.first < p3.first && p1.second < p4.second) {
		cout << "Team 2";
	} else if(p2.first < p4.first && p1.second < p3.second) {
		cout << "Team 2";
	} else {
		cout << "Draw";
	}

	return 0;
}
