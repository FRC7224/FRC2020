
package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;
import org.usfirst.frc.team7224.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//Needed for Button Toggle Code
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ShootClosedLoop extends Command {

// Used for Button Toggle Code
private Timer shooterTimer = new Timer();

public ShootClosedLoop() {

    requires(Robot.shoot);

    // RobotConstants.shootertargetspeed
}

// Called just before this Command runs the first time
protected void initialize() {
    Robot.shoot.setupShooter();
    RobotConstants.shooterMode = false;

}

// Called repeatedly when this Command is scheduled to run
protected void execute() {
    // if button 1 is pressed
    SmartDashboard.putBoolean("shoot mode ", RobotConstants.shooterMode);

    if (Robot.oi.joystick1.getRawButton(RobotConstants.kinitShooter)) {

     //   if (shooterTimer.get() == 0) {
     //       if (RobotConstants.shooterMode == false) {
     //           RobotConstants.shooterMode = true;
     //           Robot.shoot.setShootSpeed(RobotConstants.shootertargetspeed);
     //       } else { // If the shooter mode was on then toggle off
     //           Robot.shoot.setShootSpeed(0);
     //           RobotConstants.shooterMode = false;
     //       }
     //
     //       // Start Timer to make sure the toggle happens only once
     //       shooterTimer.start();
     //   }
     Robot.shoot.setShootSpeed(RobotConstants.shootertargetspeed);
     Robot.shoot.setelvSpeed(RobotConstants.kelvspeed);
     Robot.shoot.setturnSpeed(RobotConstants.kturnspeed);
    } else {
        Robot.shoot.setShootSpeed(0);
        Robot.shoot.setelvSpeed(0);
        Robot.shoot.setturnSpeed(0);
    }


   // }

    // If the shooterTimer is greater than value then reset it
    // Note: Tune the value to better timing of when the button is pressed
    // and the next pressed
    // if (shooterTimer.get() >= RobotConstants.shooterTimer_timer) {
    //    shooterTimer.stop();
    //    shooterTimer.reset();
   // }


}

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
