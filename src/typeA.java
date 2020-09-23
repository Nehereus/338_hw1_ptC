import java.util.ArrayList;

class TypeA {
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
        boolean b = false;
        rq.sort();
        while (rq.getStatus()) {

            // read the top task from the memory and run it for a slice
            if (!rq.isQueueEmpty()) {
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
                    // important: after the current process is finished, sort the whole queue to find the next task.
                    rq.sort();
                    cpuClock++;
                    switchingTime++;
                }
            } else {
                cpuClock++;
            }
            // a cpu slice end, the arrival time of each task reduce 1.
            rq.clock(cpuClock);
        }
        System.out.println("this is from Type A");
        System.out.println("the average response time is:  " + rp.getAverage(responseTime));
        System.out.println("the average burstCompletionTime time is:  " + rp.getAverage(burstCompletionTime));
        double i = ((double) switchingTime / cpuClock) * 100;
        System.out.println("the %timeSwitching time is:  " + i + "%");
    }

} 