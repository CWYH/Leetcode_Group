# String

### Easy
#### 459. Repeated Substring Pattern
聪明人的想法：
```C++
    bool repeatedSubstringPattern(string s) {
		string str = s + s;
		string tmpstr = str.substr(1, str.size() - 2);
		return tmpstr.find(s) != string::npos;
	}
```
