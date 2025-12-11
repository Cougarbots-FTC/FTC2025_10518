package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Gate;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;

@Autonomous(name="againstWallAuto", group="Autonomous")
public class againstWallAuto extends LinearOpMode {

    MecanumDrive mecanumDrive = new MecanumDrive(this);
    Outtake outtake = new Outtake(this);
    Gate gate = new Gate(this);

    @Override
    public void runOpMode() {
        waitForStart();

        if (opModeIsActive()) {
            outtake.outtake_motor.setVelocity(1080);
            sleep(3000);
            gate.right_servo.setPower(1);
            gate.left_servo.setPower(1);

        }
    }


}
