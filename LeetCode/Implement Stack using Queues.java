class MyStack {

    public Queue<Integer> q1 = new LinkedList<Integer>();
    public Queue<Integer> q2 = new LinkedList<Integer>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        Queue<Integer> q_new = (q1.isEmpty()) ? q1 : q2;
        Queue<Integer> q_stack = (q1.isEmpty()) ? q2 : q1;
        
        q_new.add(x);

        while(!q_stack.isEmpty()){
            q_new.add(q_stack.poll());
        }
    }
    
    public int pop() {
        Queue<Integer> stack = (q1.isEmpty()) ? q2 : q1;
        return stack.remove(); 
    }
    
    public int top() {
        Queue<Integer> stack = (q1.isEmpty()) ? q2 : q1;
        return stack.peek(); 
    }
    
    public boolean empty() {
        Queue<Integer> stack = (q1.isEmpty()) ? q2 : q1;
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
