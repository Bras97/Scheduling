package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAlgorithm {

    public List<List<Task>> run(List<Task> parameters)
    {
        int TASKSNUMBER = parameters.size();

        Collections.sort(parameters, new Comparator<Task>() {
            @Override
            public int compare(Task p1, Task p2) {
                return p1.getStartTime() - p2.getStartTime(); // Ascending
            }
        });

        //for(Task param: parameters) param.showInfo();

        List<List<Task>> tasksOnMachines = new ArrayList<>();
        for(int machine=0; machine<4; machine++)
        {
            List<Task> tasksOnMachine = new ArrayList<>();
            for(int i=machine; i<TASKSNUMBER; i+=4)
            {
                tasksOnMachine.add(parameters.get(i));
            }
            tasksOnMachines.add(tasksOnMachine);
        }
        return tasksOnMachines;
    }
}
