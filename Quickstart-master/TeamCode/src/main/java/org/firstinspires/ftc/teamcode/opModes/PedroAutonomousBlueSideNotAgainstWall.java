package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.TelemetryManager;
import com.bylazar.telemetry.PanelsTelemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.follower.Follower;
import com.pedropathing.paths.PathChain;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Pedro Pathing Autonomous", group = "Autonomous")
@Configurable
public class PedroAutonomousBlueSideNotAgainstWall extends OpMode {
    private TelemetryManager panelsTelemetry;
    public Follower follower;
    private Paths paths;

    public CRServo left_servo = null;
    public CRServo right_servo = null;
    public DcMotorEx outtake_motor = null;
    private ElapsedTime opTimer = new ElapsedTime();

    public enum State {
        START_DRIVE_1,
        LAUNCH_1,
        DRIVE_TO_RELOAD_1,
        RELOAD_1,
        DRIVE_TO_LAUNCH_2,
        LAUNCH_2,
        DRIVE_TO_RELOAD_2,
        RELOAD_2,
        DRIVE_TO_LAUNCH_3,
        LAUNCH_3,
        IDLE
    }

    private State currentState = State.START_DRIVE_1;

    @Override
    public void init() {
        left_servo = hardwareMap.get(CRServo.class, "Stage1Outtake");
        right_servo = hardwareMap.get(CRServo.class, "Stage1Outtake2");
        outtake_motor = hardwareMap.get(DcMotorEx.class, "OuttakeMotor");
        outtake_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(72, 8, Math.toRadians(90)));

        paths = new Paths(follower);

        panelsTelemetry.debug("Status", "Initialized");
        panelsTelemetry.update(telemetry);
    }

    @Override
    public void loop() {
        follower.update();
        autonomousPathUpdate();

        panelsTelemetry.debug("Current State", currentState);
        panelsTelemetry.debug("X", follower.getPose().getX());
        panelsTelemetry.debug("Y", follower.getPose().getY());
        panelsTelemetry.debug("Heading", follower.getPose().getHeading());
        panelsTelemetry.update(telemetry);
    }

    public void autonomousPathUpdate() {
        switch (currentState) {
            case START_DRIVE_1:
                follower.followPath(paths.gotolaunch1);
                setPathState(State.LAUNCH_1);
                break;

            case LAUNCH_1:
                // Wait until robot finishes driving
                if (!follower.isBusy()) {
                    if (opTimer.seconds() < 5.0) {
                        outtake_motor.setPower(1.0);
                        left_servo.setPower(1.0);
                        right_servo.setPower(-1.0);
                    } else {
                        stopMechanisms();
                        follower.followPath(paths.reloadballs1);
                        setPathState(State.DRIVE_TO_RELOAD_1);
                    }
                } else {
                    opTimer.reset(); // Keep timer at 0 until we arrive
                }
                break;

            case DRIVE_TO_RELOAD_1:
                if (!follower.isBusy()) {
                    setPathState(State.RELOAD_1);
                } else {
                    opTimer.reset();
                }
                break;

            case RELOAD_1:
                if (opTimer.seconds() < 3.0) {
                    stopMechanisms();
                } else {
                    follower.followPath(paths.gotolaunch2);
                    setPathState(State.LAUNCH_2);
                }
                break;

            case LAUNCH_2:
                if (!follower.isBusy()) {
                    if (opTimer.seconds() < 5.0) {
                        outtake_motor.setVelocity(1080);
                        left_servo.setPower(1.0);
                        right_servo.setPower(-1.0);
                    } else {
                        stopMechanisms();
                        follower.followPath(paths.reload2);
                        setPathState(State.DRIVE_TO_RELOAD_2);
                    }
                } else {
                    opTimer.reset();
                }
                break;

            case DRIVE_TO_RELOAD_2:
                if (!follower.isBusy()) {
                    setPathState(State.RELOAD_2);
                } else {
                    opTimer.reset();
                }
                break;

            case RELOAD_2:
                if (opTimer.seconds() < 3.0) {
                    stopMechanisms();
                } else {
                    follower.followPath(paths.gotolaunch3);
                    setPathState(State.LAUNCH_3);
                }
                break;

            case LAUNCH_3:
                if (!follower.isBusy()) {
                    if (opTimer.seconds() < 5.0) {
                        outtake_motor.setVelocity(1080);
                        left_servo.setPower(1.0);
                        right_servo.setPower(-1.0);
                    } else {
                        stopMechanisms();
                        setPathState(State.IDLE);
                    }
                } else {
                    opTimer.reset();
                }
                break;

            case IDLE:
                stopMechanisms();
                break;
        }
    }

    private void stopMechanisms() {
        outtake_motor.setPower(0);
        left_servo.setPower(0);
        right_servo.setPower(0);
    }

    private void setPathState(State state) {
        currentState = state;
        opTimer.reset();
    }

    public static class Paths {
        public PathChain gotolaunch1, reloadballs1, gotolaunch2, reload2, gotolaunch3;

        public Paths(Follower follower) {
            gotolaunch1 = follower.pathBuilder()
                    .addPath(new BezierCurve(new Pose(72, 8), new Pose(60.9, 89.3), new Pose(26.9, 129.7)))
                    .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(140))
                    .build();

            reloadballs1 = follower.pathBuilder()
                    .addPath(new BezierCurve(new Pose(26.9, 129.7), new Pose(82.1, 13.8), new Pose(12.8, 13.0)))
                    .setLinearHeadingInterpolation(Math.toRadians(140), Math.toRadians(17))
                    .build();

            gotolaunch2 = follower.pathBuilder()
                    .addPath(new BezierCurve(new Pose(12.8, 13.0), new Pose(100.9, 30.0), new Pose(26.6, 129.4)))
                    .setLinearHeadingInterpolation(Math.toRadians(17), Math.toRadians(140))
                    .build();

            reload2 = follower.pathBuilder()
                    .addPath(new BezierCurve(new Pose(26.6, 129.4), new Pose(94.8, 12.6), new Pose(12.8, 12.8)))
                    .setLinearHeadingInterpolation(Math.toRadians(140), Math.toRadians(17)) // Corrected heading logic
                    .build();

            gotolaunch3 = follower.pathBuilder()
                    .addPath(new BezierCurve(new Pose(12.8, 12.8), new Pose(104.0, 14.2), new Pose(26.6, 129.2)))
                    .setLinearHeadingInterpolation(Math.toRadians(17), Math.toRadians(140))
                    .build();
        }
    }
}
