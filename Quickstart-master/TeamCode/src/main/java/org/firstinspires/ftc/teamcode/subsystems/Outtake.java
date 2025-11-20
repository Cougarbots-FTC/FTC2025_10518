package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.opMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Outtake {
    private final Gamepad driver1, driver2;
    private DcMotorEx outtake_motor  = null;
    public Outtake(OpMode opmode) {
        driver1 = opmode.gamepad1;
        driver2 = opmode.gamepad2;

        HardwareMap hardwareMap = opmode.hardwareMap;

        outtake_motor  = hardwareMap.get(DcMotor.class, "Outtake");
    }

    public void teleOp() {
        
        outtake_motor.setPower(driver2.right_stick_y);
    }
}
