package org.usfirst.frc.team7224.robot.commands;


import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousCmdArmReset extends Command {

	double timetorun;
	Timer timer;
	
	public AutonomousCmdArmReset(double time) {
		timetorun = time;
		timer = new Timer();
	}

	@Override
	protected void initialize() {
		timer.start();
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("wait timer", timer.get() );

	}

	@Override
	protected boolean isFinished() {
		if (timer.get() >= timetorun) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void end() {
		timer.stop();
		SmartDashboard.putNumber("Arm Speed", RobotConstants.kMaxSpeed_a );
		Robot.arm.armSetup();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
