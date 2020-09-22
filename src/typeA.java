class TypeA {

    void runATask(Process p){
        boolean b;
        // read from memory and if it is finished, dump it from the queue
        b= p.run();
         if(b)
             memory.memoryCollector();
         memory.clock();


         }






    public static void main(String args[]){


}
