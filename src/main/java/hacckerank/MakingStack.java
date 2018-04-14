package hacckerank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MakingStack {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class MyQueue<T>{

        Stack inbox = new Stack<T>();
        Stack outbox = new Stack<T>();

        public void enqueue(T integer){
            inbox.push(integer);
        }

        public T dequeue(){
            if(outbox.isEmpty()) {
                reverseInbox2();
            }

            if(outbox.isEmpty()) {
                return null;
            }

            return (T)outbox.pop();
        }

        public T peek(){
            if(outbox.isEmpty()) {
                reverseInbox2();
            }

            if(outbox.isEmpty()) {
                return null;
            }

            return (T) outbox.peek();
        }

        public Stack reverseInbox1(){

            outbox = new Stack<T>(){{
                addAll(inbox);
            }};
            outbox.sort(Collections.reverseOrder());
            inbox.empty();

            return outbox;

        }

        public void reverseInbox2(){

            outbox = new Stack<T>();
            while(!inbox.isEmpty())
                outbox.add(inbox.pop());
        }
    }
}
