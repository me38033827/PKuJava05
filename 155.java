Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
? push(x) -- Push element x onto stack. 
? pop() -- Removes the element on top of the stack. 
? top() -- Get the top element. 
? getMin() -- Retrieve the minimum element in the stack. 


class MinStack {
    private Stack<Integer> s=new Stack<Integer>();;
    private Stack<Integer> min_s=new Stack<Integer>();;
    public void push(int x) {
        s.push(x);
        if(min_s.empty()||x<min_s.peek())
          min_s.push(x);
        else
          min_s.push(min_s.peek());
    }

    public void pop() {
        s.pop();
        min_s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min_s.peek();
    }
}
