package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;

public class Aim extends CommandBase{
    private DriveSubsystem drive;
    private boolean isAligned = false;
    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");    

    public Aim() {

    }

    @Override
    public void execute() {
        NetworkTableEntry txEntry = table.getEntry("tx");

        double horizontalOffset = txEntry.getDouble(999);
        double zone = .2;

        //if the offest is more than the zone
        if(horizontalOffset > zone) {
            //strafe left
            Robot.m_robotContainer.swerveDrive.drive(0, 0, -.201, true);

        } else if (horizontalOffset < -zone) {
            Robot.m_robotContainer.swerveDrive.drive(0, 0, -.201, true);
        } else {
            isAligned = true;
            Robot.m_robotContainer.swerveDrive.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return isAligned;
    }
}