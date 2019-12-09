package com.company;

import java.util.List;

public class DelayCounter
{
    public int run(List<List<Task>> machines)
    {
        int currentTime = 0;
        int delay = 0;
        for (int i = 0; i < 4; i++) {
            currentTime = machines.get(i).get(0).startTime;
            for (Task task: machines.get(i))
                try {
                    //System.out.println(currentTime + " " + machines[i][j].number + " [" + machines[i][j].duration + ", " + machines[i][j].maxDelay + "] ");
                    //System.out.print(task.number + " ");
                    if (currentTime < task.startTime)
                        currentTime = task.startTime;
                    currentTime += task.duration;

                    if (currentTime > task.maxDelay)
                        delay += currentTime - task.maxDelay;
                } catch (Exception e) {
                }

            //System.out.println();
        }
        //System.out.println(delay);

        return delay;
    }
}
