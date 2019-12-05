package com.yapitive.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;

/**
 * Structure of all of the filters classes.
 */
public abstract class FilterProc
{
    public abstract Mat proc(Mat img);

}
