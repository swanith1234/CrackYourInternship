//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    // Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            
            // If the character is a digit, push it onto the stack.
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                // Pop the top two elements for the operation.
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                switch (ch) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        
        // The final result will be the only element left in the stack.
        return stack.pop();
    }
}
