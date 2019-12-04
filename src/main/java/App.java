public class App {
    public static void main(String[] args)
    {
        System.out.println("\nHello world !");
        execution();
    }

    private static void execution()
    {
        Logger log = new Logger();
        log.writeFile("aled");
        log.closeFile();
        log.writeFile("ah");
    }
}
