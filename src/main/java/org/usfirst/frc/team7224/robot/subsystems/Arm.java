package org.usfirst.frc.team7224.robot.subsystems;
import org.usfirst.frc.team7224.robot.RobotConstants;
import org.usfirst.frc.team7224.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team7224.robot.commands.*;

public class Arm extends Subsystem {
	private final WPI_TalonSRX arm1 = RobotMap.armTalonSRX7;
	private final WPI_TalonSRX arm2 = RobotMap.armTalonSRX8;
	StringBuilder _sb = new StringBuilder();
	int _loops = 0;

	
	
	  public void armSetup() {
			/* lets grab the 360 degree position of the MagEncoder's absolute position */
			int absolutePosition = arm1.getSelectedSensorPosition(RobotConstants.kTimeoutMs_a) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
	        /* use the low level API to set the quad encoder signal */
	        arm1.setSelectedSensorPosition(absolutePosition, RobotConstants.kPIDLoopIdx_a, RobotConstants.kTimeoutMs_a);
	        
	        /* choose the sensor and sensor direction */
	        arm1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotConstants.kPIDLoopIdx_a, RobotConstants.kTimeoutMs_a);
					// setup second motor				
			/* Configure the Remote Talon's selected sensor as a remote sensor for the second Talon */
			arm2.follow(arm1);
			arm2.setInverted(true);

		
			
			
	       	/* Configure output and sensor direction */
		    arm1.setInverted(false);
		    arm1.setSensorPhase(true);
		    //arm2.setInverted(true);
		    //arm2.setSensorPhase(true);
	        
	        /* set the peak and nominal output */
	        arm1.configNominalOutputForward(RobotConstants.kStopSpeed_a, RobotConstants.kTimeoutMs_a);
	        arm1.configNominalOutputReverse(RobotConstants.kStopSpeed_a, RobotConstants.kTimeoutMs_a);
	        arm1.configPeakOutputForward(RobotConstants.kMaxSpeed_a, RobotConstants.kTimeoutMs_a);
			arm1.configPeakOutputReverse(-RobotConstants.kMaxSpeed_a, RobotConstants.kTimeoutMs_a);
			

	        /* set the allowable closed-loop error,
	         * Closed-Loop output will be neutral within this range.
	         * 
	         * 
	         */
	        arm1.configAllowableClosedloopError( RobotConstants.kPIDLoopIdx_a,RobotConstants.kallowableCloseLoopError_a, RobotConstants.kTimeoutMs_a); /* always servo */
	        /* set closed loop gains in slot0 */
	        arm1.config_kF(RobotConstants.kPIDLoopIdx_a,RobotConstants.kArmPIDF_a, RobotConstants.kTimeoutMs_a);
	        arm1.config_kP(RobotConstants.kPIDLoopIdx_a, RobotConstants.kArmPIDP_a, RobotConstants.kTimeoutMs_a);
	        arm1.config_kI(RobotConstants.kPIDLoopIdx_a, RobotConstants.kArmPIDI_a, RobotConstants.kTimeoutMs_a);
			arm1.config_kD(RobotConstants.kPIDLoopIdx_a, RobotConstants.kArmPIDD_a, RobotConstants.kTimeoutMs_a);

	 


            }

	  
	   public void armPosReset () {
		   arm1.setSelectedSensorPosition(0, 0, 10);
	
	       RobotConstants.targetPositionRotations_a= RobotConstants.kArm_Zero_HT_a;
	 //      SmartDashboard.putNumber("Reseting", RobotConstants.targetPositionRotations_a);
	   }

	  @Override
	    public void initDefaultCommand() {
			// Set the default command for a subsystem here.
			setDefaultCommand(new ArmClosedLoop());
	    }

	    @Override
	    public void periodic() {

	        /* if Talon is in position closed-loop, print some more info */
	        if( arm1.getControlMode() == ControlMode.Position) {
	        	/* append more signals to print when in speed mode. */
	        	_sb.append("\terrNative:");
	        	_sb.append(arm1.getClosedLoopError(0));
	        	_sb.append("\ttrg:");
	        	_sb.append(RobotConstants.targetPositionRotations_a);
	        	
	        }
	        /* print every ten loops, printing too much too fast is generally bad for performance */ 
	        if(++_loops >= 100) {
	        	_loops = 0;
	        	System.out.println(_sb.toString());
	        }
	        _sb.setLength(0);

	    }
	    public void armControl() {
			arm1.set(ControlMode.Position, RobotConstants.targetPositionRotations_a); 
	
	    }
	}
