class Node{
        int key, val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
}

// class LinkedList {
//     Node head, tail;

//     LinkedList(){
//         head = null;
//         tail = null;
//     }
// }

class LRUCache {
    int capacity;
    int count;
    Node head, tail;
    Map<Integer, Node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = null; tail = null;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        // put in front
        putFront(node, false);

        // return val
        return node.val;
    }

    private void putFront(Node node, boolean isNew){
        if(!isNew){
            
            if(node.key == head.key){
                return;
            }else if(node.key == tail.key){
                if(node.prev != null)
                    node.prev.next = null;
                tail = node.prev;
                node.prev = null;
            } else {
                if(node.prev != null)
                    node.prev.next = node.next;
                if(node.next != null)
                    node.next.prev = node.prev;
            }
        }

        head.prev = node;
        node.next = head;
        head = node;

        // System.out.println(head.key + "   " + tail.key + "/n");
    }
    
    public void put(int key, int value) {
        // check if key already exist
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            // put front
            putFront(node, false);
            return;
        }
        if(count == 0){
            count++;
            Node node = new Node(key, value);
            head = node;
            tail = node;
            map.put(key, node);
            return;
        } else if(count == capacity){
            // remove least used
            map.remove(tail.key);
            Node temp = tail.prev;

            if(temp == null) {
                Node node = new Node(key, value);
                map.put(key, node);
                head = node;
                tail = node;
                return;
            }// single node case
        
            
            temp.next = null;
            tail.prev = null;
            tail = temp;

            // put in front
            Node node = new Node(key, value);
            map.put(key, node);
            putFront(node, true);
        } else {
            count++;
            // put in front
            Node node = new Node(key, value);
            map.put(key, node);
            putFront(node, true);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */