package com.mycompagny.insta;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;

public class Console {

    public void parse(String[] args,Logger lg)
    {
        lg.readFile();
        System.out.println("\nHello world !");
        Options options = new Options();
        options.addOption("input", true, "doc input");
        options.addOption("output", true, "doc output");
        options.addOption("filters", true, "list filters");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String input = cmd.getOptionValue("input");
        System.out.println(input);
        File inputdir = new File(input);
        for (File f : inputdir.listFiles()) {
            System.out.println(f);
            Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());
            String filtersArg = cmd.getOptionValue("filters"); // blur:3|grayscale
            System.out.println(filtersArg);
            String[] split = filtersArg.split("\\|");
            for (String s : split) {
                String[] split2 = s.split("\\:"); // blur, 3
                String a = "";
                if (split2.length == 2) {
                    a = split2[1];
                }
                // s = blur:3
                // s = grayscale
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
        }
    }
}
