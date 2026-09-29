public class Inter_Thread_Communication {
    static class SharedData {
        private int value; private boolean available = false;
        synchronized void produce(int value) {
            while (available) {
                try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); return; }
            }
            this.value=value; available=true;
            System.out.println("Producer produced: " + value);
            notify();
        }
        synchronized void consume() {
            while (!available) {
                try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); return; }
            }
            System.out.println("Consumer consumed: " + value);
            available=false; notify();
        }
    }
    static class Producer extends Thread {
        private SharedData data; Producer(SharedData data) { this.data=data; }
        @Override public void run() { for (int i=1;i<=5;i++) data.produce(i); }
    }
    static class Consumer extends Thread {
        private SharedData data; Consumer(SharedData data) { this.data=data; }
        @Override public void run() { for (int i=1;i<=5;i++) data.consume(); }
    }
    public static void main(String[] args) {
        System.out.println("=== INTER-THREAD COMMUNICATION ===");
        SharedData data = new SharedData();
        Thread producer = new Producer(data); Thread consumer = new Consumer(data);
        producer.start(); consumer.start();
        try { producer.join(); consumer.join(); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); System.out.println("Main thread interrupted."); }
        System.out.println("Inter-thread communication completed.");
    }
}