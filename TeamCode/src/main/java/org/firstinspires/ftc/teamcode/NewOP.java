package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class NewOP extends OpMode {

    private DcMotor fLeft = null;
    private DcMotor fRight = null;
    private DcMotor bLeft = null;
    private DcMotor bRight = null;

    private ElapsedTime runtime = new ElapsedTime();

    /**
     *
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        fLeft = hardwareMap.get(DcMotor.class, "front_left");
        fRight = hardwareMap.get(DcMotor.class, "front_right");
        bLeft = hardwareMap.get(DcMotor.class, "back_left");
        bRight = hardwareMap.get(DcMotor.class, "back_right");

        fLeft.setDirection(DcMotor.Direction.REVERSE);
        bLeft.setDirection(DcMotor.Direction.REVERSE);

        fRight.setDirection(DcMotor.Direction.FORWARD);
        bLeft.setDirection(DcMotor.Direction.FORWARD);
    }

    /**
     *
     */
    @Override
    public void loop() {
// Setup a variable for each drive wheel to save power level for telemetry
        double leftPower;
        double rightPower;
        
        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

        // Send calculated power to wheels
        fLeft.setPower(leftPower);
        bLeft.setPower(leftPower);

        fRight.setPower(rightPower);
        bRight.setPower(rightPower);

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
    }
}
