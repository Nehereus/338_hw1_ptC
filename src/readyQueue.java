import java.util.ArrayList;
import java.util.Collections;

class ReadyQueue {

    protected ArrayList<Process> queue;
    protected ArrayList<Process> preQueue;

    // Important:  a simulation object to a readyQueue, where the queue means the queue of process which has been ready to be processed
// the  prequeue is queue of tasks which has not been ready yet( burst time>0)
// when a task will be processed, it will be placed at the queue(0);
    public ReadyQueue(ArrayList<Process> queue) {
        this.preQueue = queue;
        sort();
    }

    // this method will sort the queue and prequeue according to their priority, the smaller the priority parameter, the smaller the index number.
    // also, it will automatically move those "ready" task in prequeue to queue.
    void sort() {
        Collections.sort(preQueue);
        for (int i = 0; i < preQueue.size(); i++) {
            if (preQueue.get(i).getArrivalTime() <= 0) {
                queue.add(preQueue.get(i));
                preQueue.remove(i);
            }
        }
        Collections.sort(queue);

    }

    // see Process_clock()
    void clock() {
        for (int i = 0; i < preQueue.size(); i++) {
            queue.get(i).clock();
        }
    }

    // return the first element ( the one was//wil be processed  by cpu
    Process getFirst() {
        return queue.get(0);
    }

    void memoryCollector() {
        queue.remove(0);
    }

    // show if the whole ready queue has been emptied
    boolean getStatus() {

        return (queue.get(0) == null) && (preQueue.get(0) == null);

    }


}

