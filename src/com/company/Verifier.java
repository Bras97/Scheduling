package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Verifier
{
    public void mode1(String inputPath, String outputPath) throws IOException
    {
        int TASKSNUMBER=50;
        DataLoader loader = new DataLoader();
//        Task[] parameters = loader.load(TASKSNUMBER, inputPath);
//
//        ListAlgorithm listAlgorithm = new ListAlgorithm();
//
//        long start = System.nanoTime();
//        Task[][] machines = listAlgorithm.run(TASKSNUMBER, parameters);
//        long end = System.nanoTime();
//        System.out.println("ListAlgorithm takes " + (end - start)/1000 + "us");
//        int delay = listAlgorithm.countDelay(TASKSNUMBER, machines);
//
//
//        DataSaver dataSaver = new DataSaver();
//        dataSaver.save(TASKSNUMBER, "results/TESTout132349_" + TASKSNUMBER + ".txt", machines, delay);

        compareTwoFiles("results/TESTout132349_" + TASKSNUMBER + ".txt", outputPath);
    }

    public void mode2()
    {

    }

    public static void compareTwoFiles(String inputPath, String outputPath) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new FileReader(inputPath));

        BufferedReader reader2 = new BufferedReader(new FileReader(outputPath));

        String line1 = reader1.readLine();

        String line2 = reader2.readLine();

        boolean areEqual = true;

        int lineNum = 1;

        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;

                break;
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;

                break;
            }

            line1 = reader1.readLine();

            line2 = reader2.readLine();

            lineNum++;
        }

        if(areEqual)
        {
            System.out.println("Two files have same content.");
        }
        else
        {
            System.out.println("Two files have different content. They differ at line "+lineNum);

            System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
        }

        reader1.close();

        reader2.close();
    }
}
