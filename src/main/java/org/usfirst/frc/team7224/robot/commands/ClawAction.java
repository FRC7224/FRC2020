package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;


import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ClawAction extends Command {

	private Timer closeTimer = new Timer();



	public ClawAction() {

		requires(Robot.claw);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotConstants.clawOpenState = false;

		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		

		
	    // ****************************** Pan  *******************************************
		
	if (Robot.oi.joystick1.getRawButton(RobotConstants.kclawbutton)) {
				Robot.claw.Pan_down();
	         } else { //  toggle off
				Robot.claw.Pan_up();
			 }	
			
					 

	  // ****************************** Claw out  *******************************************		 
	if (Robot.oi.joystick1.getRawButton(RobotConstants.kclawgraboutbutton)) {
			 Robot.claw.Claw_in();
	      } else { //  toggle off
			 Robot.claw.Claw_out();
		  }
		
	  // ****************************** Claw on  *******************************************		 
	  if (Robot.oi.joystick1.getRawButton(RobotConstants.kclawgrabonbutton)) {
	  Robot.claw.Claw_on();
	  	SmartDashboard.putNumber("claw on", RobotConstants.kclawgrabonbutton);
      } else { //  toggle off
	  Robot.claw.Claw_off();
      }
		  
		
		
		
	/*	if (Robot.oi.joystick1.getRawButton(RobotConstants.kclawbutton)) {
			if (closeTimer.get() == 0) {
				if (RobotConstants.clawOpenState == false) {
					Robot.claw.openClaw();

				} else { //  toggle off
					Robot.claw.closeClaw();
					
				} // end sate check
			} // end timer
				// Start Timer to make sure the toggle happens only once
			closeTimer.start();
		} // End joystick check

		if (closeTimer.get() >= RobotConstants.kclawcloseTimer_timer) {
			closeTimer.stop();
			closeTimer.reset();
		}
*/
	
//	SmartDashboard.putBoolean("claw end", RobotConstants.clawOpenState);

	
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
