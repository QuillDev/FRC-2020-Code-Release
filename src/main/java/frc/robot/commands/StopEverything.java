package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Shooter;

public class StopEverything extends CommandBase{

    private DriveSubsystem drive = RobotContainer.swerveDrive;
    private Shooter shooter = RobotContainer.shooter;

    public StopEverything() {
    }

    @Override
    public void execute() {
        drive.stop();
        shooter.stop();
    }
}