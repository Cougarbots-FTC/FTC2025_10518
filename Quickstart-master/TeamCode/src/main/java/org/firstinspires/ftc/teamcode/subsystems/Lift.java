package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {

    private Gamepad driver1, driver2;
    public DcMotor liftMotor = null;

    public Lift(OpMode opmode) {
        driver1 = opmode.gamepad1;
        driver2 = opmode.gamepad2;

        HardwareMap hardwareMap = opmode.hardwareMap;

        //change when finish configuration for new motor
//        liftMotor = hardwareMap.get(DcMotor.class, "");

    }

    public void teleOp() {
        if(driver2.right_trigger > 0.1) {
            liftMotor.setPower(1);
        } else {
            liftMotor.setPower(0);
        }
    }
}
