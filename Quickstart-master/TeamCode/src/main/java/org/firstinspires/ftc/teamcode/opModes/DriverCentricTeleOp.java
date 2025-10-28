package org.firstinspires.ftc.teamcode.opModes;

@TeleOp(name="driver centric teleop");

public class DriverCentricTeleOp extends opMode{

//    private Intake intake;
//    private Delivery delivery;
    private MecanumDrive MecanumDriveTest;

    @Override

    public void init() {
        intake = new Intake(this);
        delivery = new Delivery(this);
        mecanumDrive = new MecanumDrive(this);

    }

    @Override
    public void loop() {
        mecanumDrive.mecanumDrive();
//        delivery.teleOp();
//        intake.teleOp();
    }

}
