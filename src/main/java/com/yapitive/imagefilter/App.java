package com.mycompagny.insta;

import org.apache.commons.cli.ParseException;

public class App
{
    public static void main(String[] args) throws ParseException
    {
        Logger lg = new Logger();
        Console cmdCon = new Console();
        cmdCon.parse(args,lg);
        lg.closeFile();
    }
}
