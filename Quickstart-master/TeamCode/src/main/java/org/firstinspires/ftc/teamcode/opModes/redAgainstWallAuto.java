package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Gate;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.PIDOuttake;

@Autonomous(name="redAgainstWallAuto", group="Autonomous")
public class redAgainstWallAuto extends LinearOpMode {



    @Override
    public void runOpMode() {
        waitForStart();
        MecanumDrive mecanumDrive = new MecanumDrive(this);
        PIDOuttake outtake = new PIDOuttake(this);
        Gate gate = new Gate(this);

        if (opModeIsActive()) {
//            outtake.outtake.setVelocity(1200);
            outtake.turnOnOuttake(1350);
            sleep(500);
            gate.right_servo.setPower(1);//1
            gate.left_servo.setPower(-1);//-1
            sleep(5000);
//            outtake.outtake.setVelocity(0);
            outtake.turnOffOuttake(); 
            mecanumDrive.back_left.setPower(0.25);
            mecanumDrive.back_right.setPower(0.25);
            mecanumDrive.front_right.setPower(0.25);
            mecanumDrive.front_left.setPower(0.25);
            sleep(3000);
            mecanumDrive.back_left.setPower(-0.5);
            mecanumDrive.back_right.setPower(0.5); //positive
            mecanumDrive.front_right.setPower(-0.5);
            mecanumDrive.front_left.setPower(0.5);//positive
            sleep(1000);
            mecanumDrive.back_left.setPower(0);
            mecanumDrive.back_right.setPower(0);
            mecanumDrive.front_right.setPower(0);
            mecanumDrive.front_left.setPower(0);

        }
    }


}
