package com.yapitive.imagefilter;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Logger
{
    private FileWriter myWriter;
    private File f;

    public void writeFile(String message) throws ImagefiltersException {
        try {
            myWriter = new FileWriter("log.log",true);
            myWriter.write(message + "\n");
            myWriter.close();
        } catch (IOException e)
        {
            throw new ImagefiltersException("An error occurred.", e);
        }
    }

    public void readFile() throws ImagefiltersException {
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
            throw new ImagefiltersException("Can't read the folder.", e);
        }
    }

    public void removeAll() throws ImagefiltersException {
        try {
            myWriter = new FileWriter("log.log");
            myWriter.write("");
            myWriter.close();
        } catch (IOException e)
        {
            throw new ImagefiltersException("I don't delete a text in a file", e);
        }
    }

    public void closeFile() throws ImagefiltersException {
        try {
            myWriter.close();
        } catch (IOException e) {
            throw new ImagefiltersException("I don't close a file", e);
        }
    }
}
