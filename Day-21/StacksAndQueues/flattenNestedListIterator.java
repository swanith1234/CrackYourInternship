

public class NestedIterator implements Iterator<Integer> {
  private Stack<NestedInteger> stack;

  public NestedIterator(List<NestedInteger> nestedList) {
      stack = new Stack<>();
      // Push all elements of the nested list onto the stack in reverse order
      prepareStack(nestedList);
  }

  @Override
  public Integer next() {
      if (hasNext()) {
          return stack.pop().getInteger();
      }
      return null; // or throw exception
  }

  @Override
  public boolean hasNext() {
      while (!stack.isEmpty()) {
          NestedInteger top = stack.peek();
          if (top.isInteger()) {
              return true;
          }
          // If it's a list, pop it and push its elements in reverse order
          stack.pop();
          prepareStack(top.getList());
      }
      return false;
  }

  private void prepareStack(List<NestedInteger> nestedList) {
      for (int i = nestedList.size() - 1; i >= 0; i--) {
          stack.push(nestedList.get(i));
      }
  }
}

/**
* Your NestedIterator object will be instantiated and called as such:
* NestedIterator i = new NestedIterator(nestedList);
* while (i.hasNext()) v[f()] = i.next();
*/
