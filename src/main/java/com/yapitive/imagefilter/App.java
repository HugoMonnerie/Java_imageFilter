package com.yapitive.imagefilter;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {

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
            System.out.println(f);
            Mat image = opencv_imgcodecs.imread(f.getAbsolutePath());

            String filtersArg = cmd.getOptionValue("filters");
            System.out.println(filtersArg);
            String[] split = filtersArg.split("\\|");

            for (String s : split) {
                switch (s) {
                    case "blur":
                        FilterProc blur = new filterBlur();
                        image = blur.proc(image);
                        break;
                    case "grayscale":
                        FilterProc gray = new filterGrayscale();
                        image = gray.proc(image);
                        break;
                    case "dilate":
                        FilterProc dilate = new filterDilate();
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
