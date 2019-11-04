package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader
{
    public List<Task> load(int n, String path) throws IOException
    {
        List<Task> parameters = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            String[] data = new String[3];
            int row = 0;
            while (line != null) {
                //System.out.println(line);
                data = line.split(" ");
                Task task = new Task();
                task.duration = Integer.parseInt(data[0]);
                task.startTime = Integer.parseInt(data[1]);
                task.maxDelay = Integer.parseInt(data[2]);
                task.number = row+1;
                row++;
                parameters.add(task);

                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parameters;
    }
}
