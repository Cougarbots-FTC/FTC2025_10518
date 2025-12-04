package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.*;

@TeleOp(name="driver centric teleop")
public class DriverCentricTeleOp extends OpMode {

//    private Intake intake;
//    private Delivery delivery;
    private MecanumDrive mecanumDrive;
    private Outtake intake;
    private Gate gate;

    @Override

    public void init() {
//        intake = new Intake(this);
//        delivery = new Delivery(this);
        mecanumDrive = new MecanumDrive(this);
        intake = new Outtake(this);
        gate = new Gate(this);

    }

    @Override
    public void loop() {
        mecanumDrive.teleOp();
        intake.teleOp();
        gate.teleOp();
    }

}
