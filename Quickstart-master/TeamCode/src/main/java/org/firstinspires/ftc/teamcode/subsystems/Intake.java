package org.firstinspires.ftc.teamcode.subsystems;

public class Intake {
    private final Gamepad driver1, driver2;
    private DcMotor intake_motor  = null;
    public intake(OpMode opmode) {
        driver1 = opMode.gamepad1;
        driver2 = opMode.gamepad2;

        HardwareMap hardwareMap = opMode.hardwareMap;

        intake_motor  = hardwareMap.get(DcMotor.class, "Intake");
    }

    public void teleOp() {
        if(gamepad1.a) {
            intake_motor.setPower(1);
        } else {
            intake_motor.setPower(0);
        }
    }
}
