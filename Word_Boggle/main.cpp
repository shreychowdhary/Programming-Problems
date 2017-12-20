#include<iostream>
#include<string>

using namespace std;

struct TrieNode {
	TrieNode *children[26];

	bool isEndWord;
};

bool search(TrieNode *curNode, string key) {
	if (key.length() == 0) {
		return curNode->isEndWord;
	}
	
	int index = key[0] - 'a';
	
	if(curNode->children[index] != NULL) {
		return search(curNode->children[index], key.substr(1));
	}
	return false;
}

void insert(TrieNode *curNode, string key) {
	if(key.length() == 0) {
		return;
	}

	int index = key[0] - 'a';
	
	if (curNode->children[index] == NULL) {
		curNode->children[index] = new TrieNode;
	}

	if (key.length() == 1) {
		curNode->children[index]->isEndWord = true;
		return;
	} else {
		insert(curNode->children[index],key.substr(1));
	}
}

void freeMemory(TrieNode *curNode) {
	for(int i = 0; i < 26; i++) {
		if(curNode->children[i] != NULL) {
			freeMemory(curNode->children[i]);
		}
	}
	delete curNode;
}

int main() {
	TrieNode *root = new TrieNode;
	int numWords;
	cin >> numWords;
	for(int i = 0; i < numWords; i++) {
		string tmp;
		cin >> tmp;
		insert(root, tmp);
	}

	int numSearches;
	cin >> numSearches;
	for(int i = 0; i < numSearches; i++) {
		string tmp;
		cin >> tmp;
		cout << (search(root,tmp) == 1 ? "True" : "False") << endl;
	}
	freeMemory(root); root = NULL;
	return 0; 
}
