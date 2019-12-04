import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
​
import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class filterBlur {

    public Mat filterBlur(Mat image) {
        int size = 3;
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }
​
}
