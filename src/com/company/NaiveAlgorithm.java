package com.company;

import java.util.ArrayList;
import java.util.List;

public class NaiveAlgorithm
{
    public List<List<Task>> run(List<Task> parameters)
    {
        int tasksNumberPerMachine = (int) Math.ceil(Double.valueOf(parameters.size()) / 4);
        //Task[][] machines = new Task[4][tasksNumberPerMachine];
        List<List<Task>> tasksOnMachines = new ArrayList<>();

        int machineNumber = 0;
        int row = 0;

        for(int i=0; i<4; i++)
            tasksOnMachines.add(new ArrayList<Task>());

        for (Task task : parameters) {
            if (row > (tasksNumberPerMachine - 1)) {
                row = 0;
                machineNumber++;
            }
            tasksOnMachines.get(machineNumber).add(task);
            row++;
        }
        return tasksOnMachines;
    }

}
