package com.yapitive.imagefilter;

public class App {
    public static void main(String[] args) throws ImagefiltersException {
        Console console = new Console();
        Logger log = new Logger();
        console.parse(args,log);
    }
}
