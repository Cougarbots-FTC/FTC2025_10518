package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Gate {

    private static final int DEBOUNCE_THRESHOLD = 30;
    private Gamepad driver1, driver2;
    private Servo left_servo  = null;
    private Servo right_servo  = null;

    private int debounceCounter = 0;
    public Gate(OpMode opMode) {
        driver1 = opMode.gamepad1;
        driver2 = opMode.gamepad2;

        HardwareMap hardwareMap = opMode.hardwareMap;

        left_servo  = hardwareMap.get(Servo.class, "leftHolder");
        right_servo  = hardwareMap.get(Servo.class, "rightHolder");
    }

    public void teleOp() {
        if(driver2.x) {
            if(debounceCounter > DEBOUNCE_THRESHOLD) {
                if(left_servo.getPosition() == 0) {
                    left_servo.setPosition(1);
                    right_servo.setPosition(1);
                } else {
                    left_servo.setPosition(0);
                    left_servo.setPosition(0);
                }
                //open
                debounceCounter = 0;
            } else {
                debounceCounter++;
            }
        }
    }
}
