package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Gate;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;

@Autonomous(name="notAgainstWall auto", group="Autonomous")
public class notAgainstWallAuto extends LinearOpMode {

    MecanumDrive mecanumDrive = new MecanumDrive(this);
    Outtake outtake = new Outtake(this);
    Gate gate = new Gate(this);

    @Override
    public void runOpMode() {
        waitForStart();

        if (opModeIsActive()) {
            mecanumDrive.front_left.setPower(1);
            mecanumDrive.front_right.setPower(1);
            mecanumDrive.back_left.setPower(1);
            mecanumDrive.back_right.setPower(1);
            sleep(1500);
            mecanumDrive.front_left.setPower(0);
            mecanumDrive.front_right.setPower(0);
            mecanumDrive.back_left.setPower(0);
            mecanumDrive.back_right.setPower(0);
            outtake.outtake_motor.setVelocity(1080);
            sleep(3000);
            gate.right_servo.setPower(1);
            gate.left_servo.setPower(1);

        }
    }


}
