package extra;

public class 死锁 {

    public static void main(String[]args){
        Object o1=new Object();
        Object o2=new Object();
        new Thread(()->{
            synchronized (o1){
                System.out.println("t1 lock o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("t1 lock o2");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (o2){
                System.out.println("t2 lock o2");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (o1){
                    System.out.println("t2 lock o1");
                }
            }
        }).start();

    }
    //模版模式

}
