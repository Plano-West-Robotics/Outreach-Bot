package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.subsystems.AryanArm;
import org.firstinspires.ftc.teamcode.subsystems.AryanDrive;

@TeleOp(name = "Tank Drive")
public class TankTeleOp extends OpMode {
    //private AryanArm arm;
    private AryanDrive drive;
    double leftPower;
    double rightPower;

    public void init() {
        drive = new AryanDrive(hardwareMap, telemetry);
        //arm = new AryanArm(hardwareMap, telemetry);
    }

    public void loop() {
        leftPower = -gamepad1.left_stick_y;
        rightPower = -gamepad1.right_stick_y;

        drive.setDrivePowers(leftPower, rightPower, leftPower, rightPower);

        if (gamepad1.cross) {
            // arbitrary
            //arm.setPosition(200);
        }
        if (gamepad1.circle) {
            //arm.setPosition(0);
        }
    }
}
