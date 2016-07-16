/**
 * Created by Vatsal Gosaliya on 15-Jul-16.
 *
 * PROBLEM: Check if the given string contains a balanced pattern of parantheses.
 */

import java.util.Stack;
class BalancedParantheses {

    public boolean solution(String a){
        int size = a.length();
        int check = 0;
        Stack s = new Stack();

        for(int i=0;i<size;i++){
            if(a.charAt(i)!='(' && a.charAt(i)!=')') check = -1;
            if(a.charAt(i)=='(') s.push(a.charAt(i));
            else{
                if(!s.empty()) s.pop();
                else return false;
            }
        }
        if(check==-1) return false;
        else{
            if(s.empty()) return true;
            else return false;
        }

    }
    public static void main(String[] args) {
        String a = "((()))";
        boolean result = new BalancedParantheses().solution(a);
        System.out.println(result);

    }

}