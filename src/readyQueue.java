import java.util.ArrayList;
import java.util.Collections;

class ReadyQueue {

        protected ArrayList<Process> queue;
        protected ArrayList<Process> preQueue;

        public ReadyQueue( ArrayList<Process> queue){
            this.preQueue=queue;
            sort();
        }
        void sort(){
            Collections.sort(preQueue);
            for(int i=0;i< preQueue.size();i++){
                if(preQueue.get(i).getArrivalTime()==0){
                    queue.add(preQueue.get(i));
                    preQueue.remove(i);
                }
            }
            Collections.sort(queue);

        }

    void clock() {
        for (int i = 0; i < preQueue.size(); i++) {
            queue.get(i).clock();
        }
    }

    Process getFirst() {
        return queue.get(0);
    }

    void memoryCollector() {
        queue.remove(0);
    }

    boolean getStatus() {

        return (queue.get(0) == null) && (preQueue.get(0) == null);

    }


}

