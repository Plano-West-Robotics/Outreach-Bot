package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
public class MainOp extends OpMode {

    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;


    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
    }

    @Override
    public void loop() {
        double powerY = -gamepad1.left_stick_y;
        double powerX = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        double flPower = (powerY + powerX + turn);
        double frPower = (powerY - powerX - turn);
        double blPower = (powerY - powerX + turn);
        double brPower = (powerY + powerX - turn);

        double scale = Math.max(1, (Math.abs(powerY) + Math.abs(turn) + Math.abs(powerX))); // shortcut for max(abs([fl, fr, bl, br]))
        flPower /= scale;
        frPower /= scale;
        blPower /= scale;
        brPower /= scale;

        fl.setPower(flPower);
        fr.setPower(frPower);
        bl.setPower(blPower);
        br.setPower(brPower);
    }
}
