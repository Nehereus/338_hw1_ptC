class TypeA {
    static ReadyQueue rq;

    static boolean runATask(Process p) {
        boolean b;
        // read from memory and if it is finished, dump it from the queue
        b = p.run();
        return b;
    }


    public static void main(String[] args) {
        boolean b;
        rq.sort();
        while (rq.getStatus()) {
            b = runATask(rq.getFirst());
            if (b) {
                rq.memoryCollector();
            }
            rq.clock();
            rq.sort();
        }
    }
}