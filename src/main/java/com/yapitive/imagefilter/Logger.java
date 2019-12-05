package com.yapitive.imagefilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Logger
{
    private FileWriter myWriter;
<<<<<<< HEAD
    private File f;

=======
    File f;
    public Logger()
    {

    }
>>>>>>> master
    public void writeFile(String message)
    {
        try {
            myWriter = new FileWriter("log.log",true);
            myWriter.write(message + "\n");
            myWriter.close();
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String readFile()
    {
        try {
            String data ="";
            f = new File("log.log");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine())
            {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            return data;
        } catch (FileNotFoundException e)
        {
            System.out.println("Can't read the folder.");
            e.printStackTrace();
        }
        return null;
    }

    public void removeAll()
    {
        try {
            myWriter = new FileWriter("log.log");
            myWriter.write("");
            myWriter.close();
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void closeFile()
    {
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



    /*public void readFile()
    {
        try {
            f = new File("log.log");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Can't read the folder.");
            e.printStackTrace();
        }
    }*/