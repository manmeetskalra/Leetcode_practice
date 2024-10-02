class Node {
    
    int val;
    int min;
    Node next;
    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

class MinStack {

    Node stack;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack==null){
            stack = new Node(val,val,null);
        } else{
            stack = new Node(val,Math.min(val,stack.min),stack);
        }
    }
    
    public void pop() {
        stack = stack.next;
    }
    
    public int top() {
        return stack.val;
    }
    
    public int getMin() {
        return stack.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */