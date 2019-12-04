package com.yapitive.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class filterProcBlur extends FilterProc {

    @Override
    public Mat proc(Mat img) {
        Mat result = img.clone();
        int size = 3;
        GaussianBlur(img, result, new Size(size, size), 0);
        return result;
    }
}
