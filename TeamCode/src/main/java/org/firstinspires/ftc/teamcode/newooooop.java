package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class newooooop extends OpMode {

    private DcMotor fLeft = null;
    private DcMotor fRight = null;
    private DcMotor bLeft = null;
    private DcMotor bRight = null;


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
    }

    /**
     *
     */
    @Override
    public void loop() {

    }
}
