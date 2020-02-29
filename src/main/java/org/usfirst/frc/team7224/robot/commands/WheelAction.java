package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;


import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class WheelAction extends Command {





	public WheelAction() {

		requires(Robot.wheel);

	}

	// Called just before this Command runs the first time
	protected void initialize() {


		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		double wheelspeed = Robot.chassis.deadZone(Robot.oi.joystick1.getZ()); 
		Robot.wheel.setWheelSpeed(wheelspeed*.1);
	
	} // end exectute

	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
