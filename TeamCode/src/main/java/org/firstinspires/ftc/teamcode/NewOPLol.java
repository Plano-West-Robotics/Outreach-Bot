package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.NewSubLol;


@TeleOp(name="Vincent's OP", group="Iterative Opmode")
public class NewOPLol extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();
    private NewSubLol sub;

    /**
     *
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");
        sub = new NewSubLol(this);
    }

    /**
     *  Gracious Professionalism is needed
     */
    @Override
    public void loop() {
        // Setup a variable for each drive wheel to save power level for telemetry
        double leftPower;
        double rightPower;

        double y = -gamepad1.left_stick_y;
        double x  =  gamepad1.right_stick_x;

        sub.drive(x, y, -x);
    }
}
