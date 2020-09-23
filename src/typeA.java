class TypeA {
    static ReadyQueue rq;

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
            // read the top task from the memory and run it for a slice
            b = runATask(rq.getFirst());
            if (b) {
                // dump the finished process from the memory
                rq.memoryCollector();
                // important: after the current process is finished, sort the whole queue to find the next task.
                rq.sort();
            }
            // a cpu slice end, the arrival time of each task reduce 1.
            rq.clock();
        }
    }
}