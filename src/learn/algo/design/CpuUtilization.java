package learn.algo.design;

/**
 * @author Varma Penmetsa
 */

/*
# Want to output a "Scale up" event if more than 75% of CPUs are >= 0.90 util
# Want to output a "Scale down" event if fewer than 25% of CPUs are >= 0.90 util
# Otherwise do nothing
*/

class CpuUtilization {

    static Double[][] cpu_util = {
            {0.91, 0.99, 0.2, 0.8, 0.91, 0.91, 0.93},   // 10:00
            {0.1, 0.0, 0.1, 0.3, 0.91, 0.8, 0.95, 0.4}, // 10:30
            {0.3, 0.1, 0.5, 0.0},                       // 11:00
    };


    public void util(Float[][] cpu_util){
        for(Float[] cpu : cpu_util){
            System.out.println(cpuUtilization(cpu));
        }

    }

    public String cpuUtilization(Float[] input){
        if(input.length == 0){
            return "Plz check";
        }

        int size = input.length;
        int moreThan90 = 0;

        for(Float useage : input){
            if(useage >= 0.90f){
                moreThan90++;
            }
        }

        // Find AVG
        float avg = (float) moreThan90/size * 100;
        if(avg > 75){
            return "Scale up";
        }else if(avg < 25){
            return "Scale down";
        }else{
            return "Do nothing";
        }

    }


    public static void main(String[] args) {

        Float[][] cpu_util = {
                {0.91f, 0.99f, 0.2f, 0.8f, 0.91f, 0.91f, 0.93f},   // 10:00
                {0.1f, 0.0f, 0.1f, 0.3f, 0.91f, 0.8f, 0.95f, 0.4f}, // 10:30
                {0.3f, 0.1f, 0.5f, 0.0f},                       // 11:00
        };

        CpuUtilization sol = new CpuUtilization();
        sol.util(cpu_util);

    }

}

