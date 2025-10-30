package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * This is an example minimal implementation of the mecanum drivetrain
 * for demonstration purposes.  Not tested and not guaranteed to be bug free.
 *
 * @author Brandon Gong
 */
@TeleOp(name="Mecanum Drive Example", group="Iterative Opmode")
public class MecanumDrive {

    private DcMotor front_left  = null;
    private DcMotor front_right = null;
    private DcMotor back_left   = null;
    private DcMotor back_right  = null;

    private final Gamepad driver1, driver2;

    public MecanumDrive(OpMode opMode) {

        driver1 = opMode.gamepad1;
        driver2 = opMode.gamepad2;

        HardwareMap hardwareMap = opMode.hardwareMap;
        // Name strings must match up with the config on the Robot Controller
        // app.
        front_left   = hardwareMap.get(DcMotor.class, "FrontLeft");
        front_right  = hardwareMap.get(DcMotor.class, "FrontRight");
        back_left    = hardwareMap.get(DcMotor.class, "BackLeft");
        back_right   = hardwareMap.get(DcMotor.class, "BackRight");

        front_left.setDirection(DcMotor.Direction.REVERSE);
        front_right.setDirection(DcMotor.Direction.FORWARD);

    }

    public void teleOp() {

    //initialize gamepad or whatever late

        double speed;

        if(driver1.right_bumper) {
            speed = 0.5;
        } else {
            speed = 1;
        }

        // You may need to multiply some of these by -1 to invert direction of
        // the motor.  This is not an issue with the calculations themselves.
        double vertical = driver1.left_stick_y;
        double horizontal = driver1.left_stick_x * 1.1; //  Multiply by 1.1 to negate imperfect strafing
        double pivot = driver1.right_stick_x;

        //Obtains values for each motor through the positions through values
        //from  left joystick which has up/down(vertical) and left/right values(horizontal), and right joystick which has left/right values(pivot)
        double denominator = Math.max(Math.abs(vertical) + Math.abs(horizontal) + Math.abs(pivot), 1);
        double rightFrontPower = (vertical + horizontal + pivot) / denominator * speed;
        double rightBackPower = (vertical - horizontal + pivot) / denominator * speed;
        double LeftFrontPower = (vertical - horizontal - pivot) / denominator * speed;
        double LeftBackPower = (vertical + horizontal - pivot) / denominator * speed;

        front_left.setPower(LeftFrontPower);
        front_right.setPower(rightFrontPower);
        back_left.setPower(LeftBackPower);
        back_right.setPower(rightBackPower);
    }
}
