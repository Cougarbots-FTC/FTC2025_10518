package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.*;

@TeleOp(name="driver centric teleop")
public class DriverCentricTeleOp extends OpMode {

//    private Intake intake;
//    private Delivery delivery;
    private MecanumDrive mecanumDrive;
    private Intake intake;
    private Outtake outtake;

    @Override

    public void init() {
//        intake = new Intake(this);
//        delivery = new Delivery(this);
        mecanumDrive = new MecanumDrive(this);
        intake = new Intake(this);
        outtake = new Outtake(this);

    }

    @Override
    public void loop() {
        mecanumDrive.teleOp();
        outtake.teleOp();
        intake.teleOp();
    }

}
