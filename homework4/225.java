class MyStack {
    
    Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);             
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> queue1 = new LinkedList<Integer>();      //把queue队列头到尾-1的元素赋值给queue1，再把queue1赋值给queue
        //Queue<String> temp = new LinkedList<String>();
        //while(temp=queue.peek()){
        while(queue.size()>1){
            queue1.add(queue.poll());
            
        }
        /*while(queue1.peek()){
            temp=queue1.poll();
            if(!queue1.peek()){
                queue.add(temp);
            }
        }*/
        queue=queue1;
    }

    // Get the top element.
    public int top() {
        Queue<Integer> queue1 = new LinkedList<Integer>();
        int temp;
        //while(queue.peek()){
        while(queue.size()>1){    
            queue1.add(queue.poll());
        }
        /*
        while(queue1.peek()){
            temp=queue1.poll();
           
        }*/
        temp=queue.poll();
        queue1.add(temp);
        queue=queue1;
        return temp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        //return queue.isempty();
        return queue.isEmpty();
        
    }
}