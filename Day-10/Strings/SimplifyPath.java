
class Solution {
  public String simplifyPath(String path) {
      Stack<String> stack = new Stack<>();
      String[] components = path.split("/");

      for (String component : components) {
          if (component.equals("") || component.equals(".")) {
              continue;
          } else if (component.equals("..")) {
              if (!stack.isEmpty()) {
                  stack.pop();
              }
          } else {
              stack.push(component);
          }
      }

      StringBuilder result = new StringBuilder();
      for (String dir : stack) {
          result.append("/");
          result.append(dir);
      }

      return result.length() > 0 ? result.toString() : "/";
  }
}