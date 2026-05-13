import java.util.Stack;

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {

        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue
    public void push(int x) {

        s1.push(x);
    }

    // Dequeue
    public int pop() {

        if (s2.isEmpty()) {

            while (!s1.isEmpty()) {

                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    // Front element
    public int peek() {

        if (s2.isEmpty()) {

            while (!s1.isEmpty()) {

                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    // Check empty
    public boolean empty() {

        return s1.isEmpty() && s2.isEmpty();
    }
}