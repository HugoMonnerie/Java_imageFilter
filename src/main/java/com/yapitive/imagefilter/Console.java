package com.yapitive.imagefilter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.util.ArrayList;
import java.util.List;

public class Console {

    public void initFilters(String[] args)
    {
        Options options = new Options();
        options.addOption("input", true, "doc input");
        options.addOption("output", true, "doc output");
        options.addOption("filters",true,"list filters");

        FilterProc gray = new filterGrayscale();
        FilterProc blur = new filterBlur();
        FilterProc dilate = new filterDilate();

        List<FilterProc> filtersList = new ArrayList<>();
    }

    public void parseFilters()
    {

    }
}
