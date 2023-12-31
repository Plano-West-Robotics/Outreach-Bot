package org.firstinspires.ftc.teamcode.vision;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;


public class PurplePixelDetection extends OpenCvPipeline {
    Telemetry telemetry;
    Mat mat = new Mat();

    public enum Location {
        Left,
        Center,
        Right
    }
    private Location location;
    static final Rect LEFT_ROI = new Rect(
            new Point(60, 35),
            new Point(120, 75));
    static final Rect RIGHT_ROI = new Rect(
            new Point(140, 35),
            new Point(200, 75));
    static double PERCENT_COLOR_THRESHOLD = 0.4;

    public PurplePixelDetection(Telemetry t) {telemetry = t;}

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(117.6, 43.9, 75.1);
        Scalar highHSV = new Scalar(158.7, 119.0, 213.9);

        Core.inRange(mat, lowHSV, highHSV, mat);

        Mat left = mat.submat(LEFT_ROI);
        Mat right = mat.submat(RIGHT_ROI);

        double leftValue = Core.sumElems(left).val[0] / LEFT_ROI.area() / 255;
        double rightValue = Core.sumElems(right).val[0] / RIGHT_ROI.area() / 255;

        left.release();
        right.release();

        boolean stoneLeft = leftValue > PERCENT_COLOR_THRESHOLD;
        boolean stoneRight = rightValue > PERCENT_COLOR_THRESHOLD;

        if (stoneLeft && stoneRight) {
            location = Location.Center;
        }
        else if (stoneLeft) {
            location = Location.Left;
        }
        else {
            location = Location.Right;
        }
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

        Scalar colorStone = new Scalar(255, 0, 0);
        Scalar colorSkystone = new Scalar(0, 255, 0);

        Imgproc.rectangle(mat, LEFT_ROI, location == Location.Left? colorSkystone:colorStone);
        Imgproc.rectangle(mat, RIGHT_ROI, location == Location.Right? colorSkystone:colorStone);

        return mat;
    }
    public Location getLocation() {
        return location;
    }

}
