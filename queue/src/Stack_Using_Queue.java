import java.util.Queue;
import java.util.LinkedList;

public class Stack_Using_Queue {
    static class Stack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public Stack() {
            q1 =new LinkedList<>();
            q2 =new LinkedList<>();
        }

        public int getSize() {

            return q1.size();
        }

        public boolean isEmpty() {

            return q1.size()==0;
        }

        public void push(int element) {

            if(q1.isEmpty()) {
                q1.add(element);
            }
            else {
                while(!q1.isEmpty()) {
                    q2.add(q1.poll());
                }
                q1.add(element);

                while(!q2.isEmpty()) {
                    q1.add(q2.poll());
                }
            }
        }

        public int pop() {
            if(q1.isEmpty())
                return -1;
            return q1.poll();
        }

        public int top() {
            if(q1.isEmpty())
                return -1;
            return q1.peek();
        }
    }

    public static void main(String[] Args) {

    }
}


