package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.TelemetryManager;
import com.bylazar.telemetry.PanelsTelemetry;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.follower.Follower;
import com.pedropathing.paths.PathChain;
import com.pedropathing.geometry.Pose;

@Autonomous(name = "Pedro Pathing Autonomous", group = "Autonomous")
@Configurable // Panels
public class PedroAutonomous extends OpMode {
    private TelemetryManager panelsTelemetry; // Panels Telemetry instance
    public Follower follower; // Pedro Pathing follower instance
    private int pathState; // Current autonomous path state (state machine)
    private Paths paths; // Paths defined in the Paths class

    @Override
    public void init() {
        panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(72, 8, Math.toRadians(90)));
        paths = new Paths(follower); // Build paths
        panelsTelemetry.debug("Status", "Initialized");
        panelsTelemetry.update(telemetry);
    }

    @Override
    public void loop() {
        follower.update(); // Update Pedro Pathing
        autonomousPathUpdate(); // Update autonomous state machine
        // Log values to Panels and Driver Station
        panelsTelemetry.debug("Path State", pathState);
        panelsTelemetry.debug("X", follower.getPose().getX());
        panelsTelemetry.debug("Y", follower.getPose().getY());
        panelsTelemetry.debug("Heading", follower.getPose().getHeading());
        panelsTelemetry.update(telemetry);
    }

    public static class Paths {
        public PathChain Path1;
        public PathChain Path2;
        public PathChain Path3;
        public PathChain Path4;

        public Paths(Follower follower) {
            // Path 1 definition added (was missing in original)
            Path1 = follower.pathBuilder()
                    .addPath(
                            new BezierLine(
                                    new Pose(72, 8, Math.toRadians(90)), // Starting Pose from init()
                                    new Pose(52, 10, Math.toRadians(90)) // Example end pose
                            )
                    )
                    .setTangentHeadingInterpolation()
                    .build();

            // Original first Path2 definition, assigned to Path2
            Path2 = follower.pathBuilder().addPath(
                            new BezierCurve(
                                    new Pose(52.074, 7.200),
                                    new Pose(73.865, 70.077),
                                    new Pose(22.084, 125.149)
                            )
                    ).setTangentHeadingInterpolation()
                    .build();

            // Original second Path2 definition, assigned to Path3
            Path3 = follower.pathBuilder().addPath(
                            new BezierCurve(
                                    new Pose(22.084, 125.149),
                                    new Pose(131.433, 55.772),
                                    new Pose(12.586, 7.809)
                            )
                    ).setTangentHeadingInterpolation()
                    .build();

            // Original Path3 definition, assigned to Path4
            Path4 = follower.pathBuilder().addPath(
                            new BezierCurve(
                                    new Pose(12.586, 7.809),
                                    new Pose(96.319, 36.837),
                                    new Pose(22.349, 125.121)
                            )
                    ).setTangentHeadingInterpolation()
                    .build();
        }
    }

    public void autonomousPathUpdate() {
        // Add your state machine Here
        // Access paths with paths.pathName
        // Refer to the Pedro Pathing Docs (Auto Example) for an example state machine
//        switch(pathState) {
//            case DRIVE_STARTPOS_SHOOT_POS:
//        }

    }
}
