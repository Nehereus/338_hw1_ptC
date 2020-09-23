
public class Process implements Comparable<Process> {
    private int arrivalClock;
    private int id;
    private int priority;
    private int arrivalTime;
    private int burstTime;
    private int startTime;
    // this task is a simulation of a single process which contains id, priority number(0,1) where 0 is higher priority
    public Process(int id, int priority, int arrivalTime, int burstTime) {
        this.id = id;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.arrivalClock = 0;
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

    // after the cpu run for a unit time(a time slice), the arrival time of each task will minus 1
    public boolean clock() {
        setArrivalTime(this.getArrivalTime() - 1);
        return this.getArrivalTime() == 0;
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
    public boolean run() {
        setBurstTime(this.getBurstTime() - 1);
        return this.getBurstTime() == 0;
    }

    public int getArrivalClock() {
        return arrivalClock;
    }

    public void setArrivalClock(int arrivalClock) {
        this.arrivalClock = arrivalClock;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}
