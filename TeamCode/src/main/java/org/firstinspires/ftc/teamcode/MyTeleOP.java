package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.AryanArm;
import org.firstinspires.ftc.teamcode.subsystems.AryanClaw;
import org.firstinspires.ftc.teamcode.subsystems.AryanDrive;
import org.firstinspires.ftc.teamcode.subsystems.AryanLift;

@TeleOp
public class MyTeleOP extends OpMode {
    private AryanDrive drive;
    private AryanArm arm;
    private AryanClaw claw;
    private AryanLift lift;

    @Override
    public void init() {
        drive = new AryanDrive(hardwareMap, telemetry);
        drive.setSpeed(0.5);

        claw = new AryanClaw(hardwareMap, telemetry);

        arm = new AryanArm(hardwareMap, telemetry);

        lift = new AryanLift(hardwareMap, telemetry);
        lift.setSpeed(0.5);
        lift.setManual(false);
    }

    @Override
    public void loop() {
        if (gamepad1.x) {
            drive.setSpeed(1);
        } else if (gamepad1.y) {
            drive.setSpeed(0.5);
        }

        if (gamepad1.dpad_down) {
            claw.goTo(AryanClaw.POS_CLOSE);
        } else if (gamepad1.dpad_up) {
            claw.goTo(AryanClaw.POS_OPEN);
        }

        if(gamepad1.a) {
            arm.setPosition(0);
        } else if (gamepad1.b) {
            arm.setPosition(1000);
        }

        drive.update(gamepad1.left_stick_x, -gamepad1.left_stick_y, -gamepad1.right_stick_x);
    }
}
