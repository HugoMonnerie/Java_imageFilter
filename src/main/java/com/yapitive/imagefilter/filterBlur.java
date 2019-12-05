package com.yapitive.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class filterBlur extends FilterProc {
    public int size;
    public filterBlur(int size)
    {
        this.size = size;
    }

    @Override
    public Mat proc(Mat img) {
        Mat result = img.clone();
        GaussianBlur(img, result, new Size(size, size), 0);
        return result;
    }
}
