
public class Process implements Comparable<Process> {
    private int id, priority, arrivalTime, burstTime;
// this task is a simulation of a single process which contains id, priority number(0,1) where 0 is higher priority
    public Process(int id, int priority, int arrivalTime, int burstTime) {
        this.id = id;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    //used to compare the priority of different variable.
    @Override
    public int compareTo(Process o) {
        return this.getPriority() - o.getPriority();
    }

    // // after the cpu run for a unit time(a time slice), the burst time of the running process will
    public boolean run(){
        setBurstTime(this.getBurstTime()-1);
        return this.getBurstTime() == 0;
    }

    // after the cpu run for a unit time(a time slice), the arrival time of each task will minus 1
    public void clock(){
        setArrivalTime(this.getArrivalTime()-1);
    }

}
