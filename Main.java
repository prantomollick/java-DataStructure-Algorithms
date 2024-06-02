import datastructure.queue.ArrayQueue;

public class Main {
    

    public static void main(String[] args ) {
    
        ArrayQueue<Integer> arrObj = new ArrayQueue<>(5);

        arrObj.offer(1);
        arrObj.offer(2);
        arrObj.offer(3);
        arrObj.offer(4);
        arrObj.offer(5);
        // arrObj.offer(6);
        // arrObj.offer(7);

        System.out.println(arrObj.poll());
        System.out.println(arrObj.poll());
        System.out.println(arrObj.poll());
        System.out.println(arrObj.poll());
        System.out.println(arrObj.poll());
        arrObj.offer(5);
        System.out.println(arrObj.poll());


    }

}

