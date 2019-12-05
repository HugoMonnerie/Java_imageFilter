package com.mycompagny.insta;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;

public class App {
    public static void main(String[] args) throws ParseException
    {
        Logger log = new Logger();

        log.removeAll();

        System.out.println("\nHello world !");


        Options options = new Options();
        options.addOption("input", true, "doc input");
        options.addOption("output", true, "doc output");
        options.addOption("filters", true, "list filters");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        String input = cmd.getOptionValue("input");
        System.out.println(input);
        File inputdir = new File(input);

        for (File f : inputdir.listFiles()) {
<<<<<<< f535a93eaa7be62973e2624a1fef09aa2c786fc1
            System.out.println(f);
=======

            log.writeFile("\033[1;32mApplying filters to \033[1;35m"+f.toString());

>>>>>>> implement log
            Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());

            String filtersArg = cmd.getOptionValue("filters"); // blur:3|grayscale
            System.out.println(filtersArg);
            String[] split = filtersArg.split("\\|");
            for (String s : split) {
                String[] split2 = s.split("\\:"); // blur, 3
                String a = "";
                if(split2.length == 2)
                {
                    a = split2[1];
                }
                // s = blur:3
                // s = grayscale

                log.writeFile("\033[1;32mApplying \033[1;35m"+s);

                switch (split2[0]) {
                    case "blur":
                        FilterProc blur = new filterBlur(Integer.parseInt(a));
                        image = blur.proc(image);
                        break;
                    case "grayscale":
                        FilterProc gray = new filterGrayscale();
                        image = gray.proc(image);
                        break;
                    case "dilate":
                        FilterProc dilate = new filterDilate(Integer.parseInt(a));
                        image = dilate.proc(image);
                        break;
                }
            }
            String output = cmd.getOptionValue("output");
            System.out.println(output);

            File outputdir = new File(output);
            outputdir.mkdirs();

            File outputFile = new File(outputdir, f.getName()); // output/Unknown.jpg

            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);
<<<<<<< f535a93eaa7be62973e2624a1fef09aa2c786fc1
=======

            log.writeFile("\033[1;32mSaved filtered image to : \033[1;35m"+outputFile+"\033[0m"+"\n-------------------------------------------");


            //Affichage
            /*System.out.println("\033[1;32mDoc input = \033[1;35m"+input);
            System.out.println("\033[1;32mDoc output = \033[1;35m"+output);
            System.out.println("\033[1;32mOriginal image = \033[1;35m"+f);
            System.out.println("\033[1;32mApplied filter = \033[1;35m"+filtersArg);
            System.out.println("\033[1;32mNew image = \033[1;35m"+outputFile+"\033[0m");*/


>>>>>>> implement log
        }
        log.readFile();
    }
}
