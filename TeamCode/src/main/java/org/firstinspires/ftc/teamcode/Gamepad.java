package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.AryanDrive;

@TeleOp
public class Gamepad extends OpMode {
    private AryanDrive drive;

    @Override
    public void init() {
        drive = new AryanDrive(this);
    }

    @Override
    public void loop() {
        drive.drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, -gamepad1.right_stick_x);
    }
}
