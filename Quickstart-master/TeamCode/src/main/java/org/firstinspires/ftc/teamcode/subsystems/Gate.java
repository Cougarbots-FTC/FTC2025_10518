package org.firstinspires.ftc.teamcode.subsystems;

public class Gate {

    private static final DEBOUNCE_THRESHOLD = 30;
    private final Gamepad driver1, driver2;
    private Servo left_servo  = null;
    private Servo right_servo  = null;

    private int debounceCounter = 0;
    public gate(OpMode opmode) {
        driver1 = opMode.gamepad1;
        driver2 = opMode.gamepad2;

        HardwareMap hardwareMap = opMode.hardwareMap;

        left_servo  = hardwareMap.get(DcMotor.class, "leftHolder");
        right_servo  = hardwareMap.get(DcMotor.class, "rightHolder");
    }

    public void teleOp() {
        if(driver1.x) {
            if(debounceCounter > DEBOUNCE_THRESHOLD) {
                if(left_servo.getPosition() == 0) {
                    left_servo.setPosition(1)
                    right_servo.setPosition(1)
                } else {
                    left_servo.setPosition(0)
                    left_servo.setPosition(0)
                }
                //open
                debounceCounter = 0;
            } else {
                debounceCounter++;
            }
        }
    }
}
