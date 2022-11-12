class MedianFinder {

    private final PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> min = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        min.offer(num);
        max.offer(min.poll());

        if (min.size() < max.size()) {
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        }
        return min.peek();
    }
}

