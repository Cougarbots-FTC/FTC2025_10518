package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.opMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private final Gamepad driver1, driver2;
    private DcMotor intake_motor  = null;
    public Intake(OpMode opmode) {
        driver1 = opMode.gamepad1;
        driver2 = opMode.gamepad2;

        HardwareMap hardwareMap = opMode.hardwareMap;

        intake_motor  = hardwareMap.get(DcMotor.class, "Intake");
    }

    public void teleOp() {
        intake_motor.setPower(driver1.left_trigger);
    }
}
