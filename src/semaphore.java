public class semaphore {
    private int totalspots;

    public semaphore(int totalspots) {
        this.totalspots = totalspots;
    }

    public synchronized void acquire() throws InterruptedException {
        while (totalspots <= 0) {
            wait(); // Wait until a permit becomes available
        }
        totalspots--;
    }

    public synchronized void release() {
        totalspots++;
        notify(); // Notify one waiting thread
    }

    public synchronized int getPermits() {
        return totalspots;
    }
}