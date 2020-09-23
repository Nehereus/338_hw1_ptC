import java.util.ArrayList;

class TypeB {
    static RandomProcessGenerator rp = new RandomProcessGenerator();
    static ReadyQueue rq = new ReadyQueue(rp.random());
    static int cpuClock = 0;
    static int runningTime;
    static int switchingTime;
    static ArrayList<Integer> responseTime = new ArrayList<Integer>();
    static ArrayList<Integer> burstCompletionTime = new ArrayList<Integer>();

    static boolean runATask(Process p) {

        boolean b;
        // read from memory and if it is finished, dump it from the queue
        b = p.run();
        return b;
    }


    public static void main(String[] args) {
        //every round is a simulation for a cpu slice
        boolean b;
        rq.sort();

        while (rq.getStatus()) {
            if (!rq.isQueueEmpty()) {
                // read the top task from the memory and run it for a slice
                b = runATask(rq.getFirst());
                cpuClock++;
                runningTime++;
                if (rq.getFirst().getStartTime() == 0)
                    rq.getFirst().setStartTime(cpuClock);
                if (b) {

                    responseTime.add(rq.getFirst().getStartTime() - rq.getFirst().getArrivalClock());
                    burstCompletionTime.add(cpuClock - rq.getFirst().getArrivalClock());
                    // dump the finished process from the memory
                    rq.memoryCollector();

                }
            }
            // a cpu slice end, the arrival time of each task reduce 1.
            rq.clock(cpuClock);
            // for typeB, the only difference from A is that the queue is sorted every time slice even though the current task has not been finished yet.
            boolean c = rq.sort();
            if (c) {
                cpuClock++;
                switchingTime++;
            }
        }
        System.out.println("this is from type B");
        System.out.println("the average response time is:  " + rp.getAverage(responseTime));
        System.out.println("the average burstCompletionTime time is:  " + rp.getAverage(burstCompletionTime));
        double i = (double) (switchingTime / cpuClock) * 100;
        System.out.println("the %timeSwitching time is:  " + i);
    }
}