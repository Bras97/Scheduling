package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataSaver
{
    public void save(String path, List<List<Task>> machines, int delay) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        writer.write(Integer.toString(delay) + "\n");

        for (int i = 0; i < 4; i++) {
            for (Task task: machines.get(i))
                try {
                    writer.append(task.number + " ");
                } catch (Exception e) {
                }
                writer.append("\n");
        }

        writer.close();
    }
}
