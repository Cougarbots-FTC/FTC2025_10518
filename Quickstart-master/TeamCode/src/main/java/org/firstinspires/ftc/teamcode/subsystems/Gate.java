package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.hardware.Servo;

public class Gate {

    private static final int DEBOUNCE_THRESHOLD = 30;
    private Gamepad driver1, driver2;
    private CRServo left_servo  = null;
    private CRServo right_servo  = null;

//    private int debounceCounter = 0;
    public Gate(OpMode opMode) {
        driver1 = opMode.gamepad1;
        driver2 = opMode.gamepad2;

        HardwareMap hardwareMap = opMode.hardwareMap;

        left_servo  = hardwareMap.get(CRServo.class, "Stage1Outtake");
        right_servo  = hardwareMap.get(CRServo.class, "Stage1Outtake2");
    }

    public void teleOp() {
        left_servo.setPower(driver2.left_stick_y);
        right_servo.setPower(driver2.left_stick_y * -1);
//        if(driver2.x) {
//            if(debounceCounter > DEBOUNCE_THRESHOLD) {
//                if (left_servo.getPosition() == 0) {
//                    left_servo.setPosition(1);
//                    right_servo.setPosition(0);
//                } else {
//                    left_servo.setPosition(0);
//                    right_servo.setPosition(1);
//                }
//                //open
//                debounceCounter = 0;
//            }
//        } else {
//                debounceCounter++;
//
//        }
    }
}
