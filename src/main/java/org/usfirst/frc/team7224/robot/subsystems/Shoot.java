package org.usfirst.frc.team7224.robot.subsystems;
import org.usfirst.frc.team7224.robot.RobotConstants;
import org.usfirst.frc.team7224.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team7224.robot.commands.*;

public class Shoot extends Subsystem {
	
     //private final CANTalon shootMotor1 = RobotMap.shooterCANTalon_1;
	 private final WPI_TalonSRX shooterMotor1 = RobotMap.shootTalonSRX10;
	 private final WPI_TalonSRX shooterMotor2 = RobotMap.shootTalonSRX11;
	 private final WPI_TalonSRX elvMotor = RobotMap.elvTalonSRX9;
     


     // Put methods for controlling this subsystem
     // here. Call these from Commands.
 
     public void initDefaultCommand() {
         // Set the default command for a subsystem here.
         setDefaultCommand(new ShootClosedLoop());
     }
 
     /**
      * sets up shooter with PID
      */
     public void setupShooter() {

		shooterMotor1.configFactoryDefault();
		shooterMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,30);

				/* Config the peak and nominal outputs */
		shooterMotor1.configNominalOutputForward(0, RobotConstants.kTimeoutMs);
		shooterMotor1.configNominalOutputReverse(0, RobotConstants.kTimeoutMs);
		shooterMotor1.configPeakOutputForward(1, RobotConstants.kTimeoutMs);
		shooterMotor1.configPeakOutputReverse(-1, RobotConstants.kTimeoutMs);
		
		
				/* Config the Velocity closed loop gains in slot0 */
		shooterMotor1.config_kF(RobotConstants.kPIDLoopIdx, RobotConstants.kshoot1F, RobotConstants.kTimeoutMs);
		shooterMotor1.config_kP(RobotConstants.kPIDLoopIdx, RobotConstants.kshoot1P, RobotConstants.kTimeoutMs);
		shooterMotor1.config_kI(RobotConstants.kPIDLoopIdx, RobotConstants.kshoot1I, RobotConstants.kTimeoutMs);
		shooterMotor1.config_kD(RobotConstants.kPIDLoopIdx, RobotConstants.kshoot1D, RobotConstants.kTimeoutMs);
		
		shooterMotor2.configFactoryDefault();
		shooterMotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,0,30);

				/* Config the peak and nominal outputs */
		shooterMotor2.configNominalOutputForward(0, RobotConstants.kTimeoutMs);
		shooterMotor2.configNominalOutputReverse(0, RobotConstants.kTimeoutMs);
		shooterMotor2.configPeakOutputForward(1, RobotConstants.kTimeoutMs);
		shooterMotor2.configPeakOutputReverse(-1, RobotConstants.kTimeoutMs);
		
		
				/* Config the Velocity closed loop gains in slot0 */
		shooterMotor2.config_kF(RobotConstants.kPIDLoopIdx, RobotConstants.kshoot2F, RobotConstants.kTimeoutMs);
		shooterMotor2.config_kP(RobotConstants.kPIDLoopIdx, RobotConstants.kshoot2P, RobotConstants.kTimeoutMs);
		shooterMotor2.config_kI(RobotConstants.kPIDLoopIdx, RobotConstants.kshoot2I, RobotConstants.kTimeoutMs);
		shooterMotor2.config_kD(RobotConstants.kPIDLoopIdx, RobotConstants.kshoot2D, RobotConstants.kTimeoutMs);
		




        /* shooterMotor1.setFeedbackDevice(FeedbackDevice.CTRE_MagEncoder_Relative);
         shooterMotor1.changeControlMode(TalonControlMode.Speed);
         shooterMotor1.reverseSensor(true);
         shooterMotor1.reverseOutput(false);
         shooterMotor1.setProfile(0);
         shooterMotor1.setPID(
                 RobotConstants.shooterPIDKp,
                 RobotConstants.shooterPIDKi,
                 RobotConstants.shooterPIDKd,
                 RobotConstants.shooterPIDKf,
                 RobotConstants.shooterPIDIZone,
                 RobotConstants.shooterPIDRampRate,
				 0);
	*/			 
     }
 
     /**
      * sets the shooter speed
      */
     public void setShootSpeed(double speed) {
         //shootMotor1.set(speed);
		 shooterMotor1.set(speed);
		 shooterMotor2.set(speed);
		 elvMotor.set(ControlMode.PercentOutput, RobotConstants.kelvspeed);
      }
 
 
     }
 