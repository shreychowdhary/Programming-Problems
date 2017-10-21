#include<iostream>
#include<vector>
using namespace std;

int main() {
	int n;
	vector<int> bags;
	cin >> n;
	int sum = 0;
	for(int i = 0; i < n; i++){
		int tmp;
		cin >> tmp;
		sum += tmp;
		bags.push_back(tmp);
	}
	int count = 0;
	for(int i = 0; i < bags.size(); i++){
		if((sum - bags[i])%2 == 0){
			count++;
		}
	}
	cout<<count<<endl;
	return 0;
}
