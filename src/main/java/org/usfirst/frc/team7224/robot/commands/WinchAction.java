

package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;






 
public class WinchAction extends Command {


    public WinchAction() {
    	 requires(Robot.winch);

   }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
  		
    	 Robot.winch.setupWinch();
     }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	      if (Robot.oi.joystick1.getRawButton(RobotConstants.kWinchButtonA) && Robot.oi.joystick1.getRawButton(RobotConstants.kWinchButtonB)) {
    	    	  RobotConstants.WinchState = true;
    	    	  double winchspeed = Robot.chassis.deadZone(Robot.oi.joystick1.getZ()); // forward
    	    	  if (winchspeed >= RobotConstants.kmaxWinchSpeed)  // limit max speed
    	    		  winchspeed = RobotConstants.kmaxWinchSpeed;
    	    	  if (winchspeed <= RobotConstants.kminWinchSpeed)  // prevent reverse
    	    		  winchspeed = RobotConstants.kminWinchSpeed;
    	    	  Robot.winch.setWinchSpeed(winchspeed);
    //	    	  SmartDashboard.putNumber("winchspeed", winchspeed);
    	      	  }
    	    	   else {	  
    	    	  RobotConstants.WinchState = false;
    	    	  Robot.winch.setWinchSpeed(RobotConstants.kminWinchSpeed);
                   }

     // Move hook              
           double hookspeed = Robot.chassis.deadZone(Robot.oi.joystick1.getZ()); 
           Robot.winch.setHookSpeed(hookspeed*.1);
                                
    	 //     SmartDashboard.putBoolean("winch state", RobotConstants.WinchState);
 	     }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
