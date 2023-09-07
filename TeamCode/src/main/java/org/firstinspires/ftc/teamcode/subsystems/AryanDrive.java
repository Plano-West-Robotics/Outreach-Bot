package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


/*
public Drive(HardwareMap hardwareMap, Telemetry telemetry);
* public void update(double x, double rx, double y);
* */

public class AryanDrive {

    // Null by default
    private final DcMotor frontLeft;
    private final DcMotor frontRight;
    private final DcMotor backLeft;
    private final DcMotor backRight;
    private final Telemetry telemetry;

    public AryanDrive(OpMode opMode) {
        this(opMode.hardwareMap, opMode.telemetry);
    }

    public AryanDrive(HardwareMap hardwareMap, Telemetry telemetry) {

        // Instantiates motors
        frontLeft = hardwareMap.get(DcMotor.class,"FLmotor");
        frontRight = hardwareMap.get(DcMotor.class, "FRmotor");
        backLeft = hardwareMap.get(DcMotor.class, "BLmotor");
        backRight = hardwareMap.get(DcMotor.class, "BRmotor");

        // Sets direction for motors -- forward is default
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);

        // Set mode is good practice -- RUN_WITHOUT_ENCODER is default
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Assigns telemetry
        this.telemetry = telemetry;
    }

    public void drive(double x, double y, double t) {
        double flPower = y + x - t;
        double frPower = y - x + t;
        double blPower = y - x - t;
        double brPower = y + x + t;

        frontLeft.setPower(flPower);
        frontRight.setPower(frPower);
        backLeft.setPower(blPower);
        backRight.setPower(brPower);
    }

    public void stop() {
        drive(0, 0, 0);
    }
}