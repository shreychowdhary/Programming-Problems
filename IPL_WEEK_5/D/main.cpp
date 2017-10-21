#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int n, m;
	vector<int> puzzles;
	cin >> n >> m;
	for(int i = 0; i < m; i++) {
		int tmp;
		cin >> tmp;
		puzzles.push_back(tmp);
	}
	sort(puzzles.begin(),puzzles.end());
	int min = 10000;
	for(int i = 0; i <= puzzles.size()-n; i++){
		//cout<<puzzles[i]<<endl;
		if(puzzles[i+n-1]-puzzles[i] < min) {
			min = puzzles[i+n-1]-puzzles[i];
		}
	}
	cout << min <<endl;
	return 0;
}
