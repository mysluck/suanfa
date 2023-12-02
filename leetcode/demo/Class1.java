package demo;

public class Class1 {
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println( stack.poll());
        System.out.println( stack.poll());
        System.out.println( stack.poll());
        System.out.println( stack.poll());
        System.out.println( stack.poll());

    }
}
