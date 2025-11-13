package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.opMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Outtake {
    private final Gamepad driver1, driver2;
    private DcMotor outtake_motor  = null;
    public Outtake(OpMode opmode) {
        driver1 = opMode.gamepad1;
        driver2 = opMode.gamepad2;

        HardwareMap hardwareMap = opMode.hardwareMap;

        outtake_motor  = hardwareMap.get(DcMotor.class, "Outtake");
    }

    public void teleOp() {
        outtake_motor.setPower(driver1.right_trigger);
    }
}
