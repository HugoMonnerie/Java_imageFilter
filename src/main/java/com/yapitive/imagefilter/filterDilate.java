package com.mycompagny.insta;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.dilate;
import static org.bytedeco.opencv.global.opencv_imgproc.getStructuringElement;

public class filterDilate extends FilterProc {
    public int size;

    public filterDilate(int size) {
        this.size = size;
    }

    @Override
    public Mat proc(Mat img) {
        Mat result = img.clone();
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(img, result, element);
        return result;
    }
}
