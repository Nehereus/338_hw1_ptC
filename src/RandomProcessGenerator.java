import java.util.ArrayList;

public class RandomProcessGenerator {


    public ArrayList<Process> random() {
        ArrayList<Process> temp = new ArrayList<Process>();
        for (int i = 0; i < 50; i++) {
            Process rp = new Process(i, 0, 0, 0);
            rp.setArrivalTime((int) (Math.random() * 50));
            rp.setBurstTime((int) (Math.random() * 100));
            rp.setPriority((int) (Math.random() * 2));
            System.out.println("ID is:" + rp.getId() + "," + "Priority is:" + rp.getPriority() + "," + "BurstTime is:" + rp.getBurstTime() + "," + "Arrival Time is:" + rp.getArrivalTime());
            temp.add(rp);
        }

        return temp;

    }

    public double getAverage(ArrayList<Integer> input) {
        int temp = 0;
        for (int i = 0; i < 50; i++) {
            temp = temp + input.get(i);
        }
        return temp / 50;
    }
}

