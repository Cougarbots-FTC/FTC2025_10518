package org.firstinspires.ftc.teamcode.subsystems;

public class Outtake {
    private final Gamepad driver1, driver2;
    private DcMotor outtake_motor  = null;
    public outtake(OpMode opmode) {
        driver1 = opMode.gamepad1;
        driver2 = opMode.gamepad2;

        HardwareMap hardwareMap = opMode.hardwareMap;

        outtake_motor  = hardwareMap.get(DcMotor.class, "Outtake");
    }

    public void teleOp() {
        outtake_motor.setPower(driver1.rightTrigger);
    }
}
