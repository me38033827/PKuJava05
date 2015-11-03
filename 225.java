
Implement the following operations of a stack using queues. 
? push(x) -- Push element x onto stack. 
? pop() -- Removes the element on top of the stack. 
? top() -- Get the top element. 
? empty() -- Return whether the stack is empty. 
Notes:
 ?You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 ?Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 ?You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 

Update (2015-06-11):
 The class name of the Java function had been updated to MyStack instead of Stack.
 
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and all test cases.



Subscribe to see which companies asked this question





class MyStack {
    // Push element x onto stack.
    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(!q1.isEmpty()){
              int elem=q1.poll();
              if(q1.size()==0) break;
              q2.offer(elem);
        }//end while
        while(!q2.isEmpty()){
              q1.offer(q2.poll());
        }//end while
    }

    // Get the top element.
    public int top() {
        int elem=0;
        while(!q1.isEmpty()){
            elem=q1.poll();
            q2.offer(elem);
        }//end while
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }//end while
        return elem;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty()&&q2.isEmpty();
        
    }
}