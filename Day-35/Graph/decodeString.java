
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Building the multiplier (k)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current multiplier and current string onto their stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset the current string and multiplier
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop from stacks and build the string
                StringBuilder decodedString = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // Build the current string
                currentString.append(ch);
            }
        }
        
        return currentString.toString();
    }
}
