package org.firstinspires.ftc.teamcode.subsystems;

//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class Intake {
    private final Gamepad driver1, driver2;
    public DcMotor intake_motor  = null;
    public Intake(OpMode opmode) {
        driver1 = opmode.gamepad1;
        driver2 = opmode.gamepad2;

        HardwareMap hardwareMap = opmode.hardwareMap;

        intake_motor  = hardwareMap.get(DcMotor.class, "IntakeMotor");
//        intake_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void teleOp(OpMode opmode) {
        if(driver2.right_trigger > 0.1) {
//            intake_motor.setVelocity(1350);
                intake_motor.setPower(-0.35);
        } else {
            intake_motor.setPower(0);
//            intake_motor.setVelocity(0);
        }
//        opmode.telemetry.addData("Intake Velocity: ", intake_motor.getVelocity());
//        opmode.telemetry.addData("Intake Voltage: ", intake_motor.getCurrent(CurrentUnit.AMPS));

    }
}
