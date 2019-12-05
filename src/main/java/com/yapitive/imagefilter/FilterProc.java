package com.yapitive.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;

public abstract class FilterProc
{
    public abstract Mat proc(Mat img);

}
