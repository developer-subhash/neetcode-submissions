class MinStack {
    List<Integer> list;
    List<Integer> min; // min[i] minimum of stack when list[i] element come 
    int currMin;
    int size;
    public MinStack() {
        list = new ArrayList<>();
        min = new ArrayList<>();
        currMin = Integer.MAX_VALUE;
        size = 0;
    }
    
    public void push(int val) {
        min.add(currMin);
        currMin = Math.min(currMin, val);
        list.add(val);
        size++;
    }
    
    public void pop() {
        currMin = min.get(size-1);
        min.remove(size-1);
        list.remove(size-1);
        size--;
    }
    
    public int top() {
        return list.get(size-1);
    }
    
    public int getMin() {
        return currMin;
    }
}