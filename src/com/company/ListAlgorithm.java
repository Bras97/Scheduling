package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListAlgorithm {

    public List<Task> parameters;

    private Task findBest()
    {
        int mini = Integer.MAX_VALUE;
        int miniI = 0;
        int miniSpan = Integer.MAX_VALUE;
        for(int i=0; i< parameters.size(); i++)
        {
            if(mini>parameters.get(i).startTime)
            {
                miniSpan = parameters.get(i).startTime + parameters.get(i).duration;
                mini = parameters.get(i).startTime;
                miniI = i;
            }
            else if(mini==parameters.get(i).startTime)
            {
                if (miniSpan > (parameters.get(i).startTime + parameters.get(i).duration))
                {
                    miniSpan = parameters.get(i).startTime + parameters.get(i).duration;
                    miniI = i;
                }
            }
        }
//        for(int i=0; i< parameters.size(); i++)
//        {
//            if(mini>parameters.get(i).startTime)
//            {
//                miniSpan = parameters.get(i).maxDelay - parameters.get(i).startTime;
//                mini = parameters.get(i).startTime;
//                miniI = i;
//            }
//            else if(mini==parameters.get(i).startTime)
//            {
//                if (miniSpan > (parameters.get(i).maxDelay - parameters.get(i).startTime))
//                {
//                    miniSpan = parameters.get(i).maxDelay - parameters.get(i).startTime;
//                    miniI = i;
//                }
//            }
//        }
        return parameters.remove(miniI);
    }
    public List<List<Task>> run(List<Task> parameters)
    {
        this.parameters = parameters;
        int TASKSNUMBER = parameters.size();


        //for(Task param: parameters) param.showInfo();

        List<List<Task>> tasksOnMachines = new ArrayList<>();
        for(int machine=0; machine<4; machine++)
        {
            tasksOnMachines.add(new ArrayList<Task>() );
        }

        int[] machineLoaded = new int[4];
        for(int i=0; i<machineLoaded.length; i++)
            machineLoaded[i] = 0;
        for(int i=0; i<TASKSNUMBER; i++)
        {
            Task task = findBest();
            tasksOnMachines.get(freeMachine(machineLoaded)).add(task);
            machineLoaded[freeMachine(machineLoaded)] = task.startTime + task.duration;

        }

        return tasksOnMachines;
    }

    private int freeMachine(int[] machineLoaded)
    {
        int mini= Integer.MAX_VALUE;
        int newIndex = 0;
        for(int j=0; j<machineLoaded.length; j++)
            if(mini>machineLoaded[j])
            {
                mini=machineLoaded[j];
                newIndex=j;
            }
        return newIndex;
    }
}
