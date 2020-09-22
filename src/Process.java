
public class Process implements Comparable<Process> {
    private int id, priority, arrivalTime, burstTime;

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

    @Override
    public int compareTo(Process o) {
        return this.getPriority() - o.getPriority();
    }
    public boolean run(){
        setBurstTime(this.getBurstTime()-1);
        if(this.getBurstTime()==0){
            return true;
        }
        return false;
    }
    public void clock(){
        setArrivalTime(this.getArrivalTime()-1);
    }

}
