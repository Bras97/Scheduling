package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InstancesCreator {

    private static final Random random = new Random();

    public void create() throws IOException
    {

        int maxPj=7;
        for(int tasksNumber=50; tasksNumber<=500; tasksNumber+=50)
        {

            String file = tasksNumber + "\n";
            int rj[] = new int[tasksNumber];
            int pj[] = new int[tasksNumber];
            int dj[] = new int[tasksNumber];

            int averagePj= (int) Math.ceil(Double.valueOf(maxPj)/2);

            for (int i=0; i<tasksNumber; i++)
            {
                rj[i] = random.nextInt(tasksNumber*averagePj/4);
                pj[i] = random.nextInt(maxPj)+1;
                dj[i] = rj[i]+pj[i]+ random.nextInt(4);
            }

            int sum=0;
            for (int i=0; i<tasksNumber; i++)
            {
                file += pj[i] + " " + rj[i] + " " + dj[i] + "\n";
                //System.out.println(pj[i] + " " + rj[i] + " " + dj[i]);
                sum+= pj[i];
            }
            System.out.println("Suma: " + sum/4);



            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/data/in132349_"+tasksNumber+".txt"));

            fileWriter.write(file);
            fileWriter.close();

        }
    }
}
