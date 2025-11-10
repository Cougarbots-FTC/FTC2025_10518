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
        if(gamepad1.b) {
            outtake_motor.setPower(1);
        } else {
            outtake_motor.setPower(0);
        }
    }
}
