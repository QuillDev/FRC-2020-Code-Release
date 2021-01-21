package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Shoot extends CommandBase {

    private double startTime;
    private double endTime;

    public Shoot() {
        startTime = Timer.getMatchTime();
        endTime = startTime + 5;
    }

    @Override
    public void execute() {
        Robot.m_robotContainer.shooter.shoot();
    }
}