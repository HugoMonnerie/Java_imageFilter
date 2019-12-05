package com.yapitive.imagefilter;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;

public class Console {

    /**
     * Defines the application's options, convert Options to String to make it usable and then defines a separator for the options and another one for the arguments of these options. Applies filters while there are still given filters not applied to the image.
     * @param args List of the options that our application require to run.
     * @param log Make our Logger usable.
     * @throws ImagefiltersException
     */
    public void parse(String[] args,Logger log) throws ImagefiltersException {
        log.removeAll();

        Options options = new Options();
        options.addOption("input", true, "doc input");
        options.addOption("output", true, "doc output");
        options.addOption("filters", true, "list filters");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            throw new ImagefiltersException("I don't known", e);
        }

        String input = cmd.getOptionValue("input");
        File inputdir = new File(input);

        for (File f : inputdir.listFiles()) {

            log.writeFile("\033[1;32mApplying filters to \033[1;35m"+f.toString());

            Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());

            String filtersArg = cmd.getOptionValue("filters"); // blur:3|grayscale
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

            File outputdir = new File(output);
            outputdir.mkdirs();

            File outputFile = new File(outputdir, f.getName()); // output/Unknown.jpg

            opencv_imgcodecs.imwrite(outputFile.getAbsolutePath(), image);

            log.writeFile("\033[1;32mSaved filtered image to : \033[1;35m"+outputFile+"\033[0m"+"\n-------------------------------------------");

        }
        log.readFile();
    }
}
