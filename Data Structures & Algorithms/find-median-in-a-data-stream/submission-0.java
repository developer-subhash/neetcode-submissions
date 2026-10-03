class MedianFinder {
    PriorityQueue<Integer> mn; // min heap
    PriorityQueue<Integer> mx; // max heap
    int total;

    public MedianFinder() {
        mn = new PriorityQueue<>();
        mx = new PriorityQueue<>(Collections.reverseOrder());
        total = 0;
    }
    
    public void addNum(int num) {
        // always try to keep both same size of mx heap as 1 greater than mn in case of total odd
        if(total < 2){
            mx.add(num);
        } else {
            if(num > mn.peek()){
                mn.add(num); // case 1
            }else {
                mx.add(num);
            }
        }

        // case 1
        while(mx.size() < mn.size()){
            mx.add(mn.peek());
            mn.poll();
        }

        while(mx.size() - mn.size() > 1){
            mn.add(mx.peek());
            mx.poll();
        }
        total++;
    }
    
    public double findMedian() {
        if(total == 0)return 0;
        if(total%2 == 1){
            return mx.peek();
        } else {
            return (mn.peek() + mx.peek())/2.0;
        }
    }
}