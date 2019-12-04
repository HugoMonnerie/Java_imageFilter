package com.mycompagny.insta;

import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class filterGrayscale extends FilterProc {

    @Override
    public Mat proc(Mat img) {
        Mat result = new Mat(img.rows(), img.cols(), CvType.CV_8UC3);
        cvtColor(img, result, Imgproc.COLOR_RGB2GRAY);
        return result;
    }
}
