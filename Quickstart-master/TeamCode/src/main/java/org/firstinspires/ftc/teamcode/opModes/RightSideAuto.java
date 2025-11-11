package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

@Autonomous(name="Right Side Auto", group="Autonomous")
public class RightSideAuto extends LinearOpMode {

    MecanumDrive mecanumDrive = new MecanumDrive(this);

    @Override
    public void runOpMode() {
        waitForStart();

        if (opModeIsActive()) {
            mecanumDrive.auto(1000);
        }
    }


}
