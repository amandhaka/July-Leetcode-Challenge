/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.
```
Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
```
*/
class Solution {
    public String addBinary(String a, String b) {
        int carry=0;
        int l1=a.length()-1;
        int l2=b.length()-1;
        StringBuilder sb=new StringBuilder();
        while(l1>=0 || l2>=0){
            int sum=carry;
            if(l1>=0){
                sum+=Integer.parseInt(String.valueOf(a.charAt(l1)));
            }
            if(l2>=0) sum+=Integer.parseInt(String.valueOf(b.charAt(l2)));
            sb.append(sum%2);
            carry=sum/2;
            l1--;
            l2--;
        }
        if(carry!=0) sb.append("1");
        return sb.reverse().toString();
    }
}
