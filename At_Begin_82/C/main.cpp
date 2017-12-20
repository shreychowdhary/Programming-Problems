#include<iostream>
#include<vector>
#include<map>
using namespace std;

int main() {
	map<int,int> nums; 
	int n;
	cin >> n;
	for(int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		if(nums.count(tmp) == 0) {
			nums[tmp] = 0;
		}
		nums[tmp]++;
	}
	int sum = 0;
	for(map<int,int>::iterator it = nums.begin(); it != nums.end(); ++it) {
		if(it->second > 0) {
			if(it->second - it->first > 0) {
				sum += it->second - it->first;
			} else if(it->second - it->first < 0) {
				sum += it->second;
			}
		}
	}
	cout << sum;
}

