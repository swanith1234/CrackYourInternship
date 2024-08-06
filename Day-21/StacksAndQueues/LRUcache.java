class LRUCache {
  private class Node {
      int key, value;
      Node prev, next;
      Node(int key, int value) {
          this.key = key;
          this.value = value;
      }
  }
  
  private int capacity;
  private HashMap<Integer, Node> cache;
  private Node head, tail;

  public LRUCache(int capacity) {
      this.capacity = capacity;
      this.cache = new HashMap<>();
      this.head = new Node(0, 0); // Dummy head
      this.tail = new Node(0, 0); // Dummy tail
      head.next = tail;
      tail.prev = head;
  }
  
  public int get(int key) {
      if (cache.containsKey(key)) {
          Node node = cache.get(key);
          remove(node);
          insertToHead(node);
          return node.value;
      }
      return -1;
  }
  
  public void put(int key, int value) {
      if (cache.containsKey(key)) {
          Node node = cache.get(key);
          node.value = value;
          remove(node);
          insertToHead(node);
      } else {
          if (cache.size() == capacity) {
              cache.remove(tail.prev.key);
              remove(tail.prev);
          }
          Node node = new Node(key, value);
          cache.put(key, node);
          insertToHead(node);
      }
  }

  private void remove(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
  }

  private void insertToHead(Node node) {
      node.next = head.next;
      node.next.prev = node;
      head.next = node;
      node.prev = head;
  }
}
