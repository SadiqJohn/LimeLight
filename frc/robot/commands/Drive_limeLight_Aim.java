// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class Drive_limeLight_Aim extends Command {

    private double kpAim = 0.035;
    private double m_moveValue;
    private double m_rotateValue;
    
    public Drive_limeLight_Aim() {
      // Use requires() here to declare subsystem dependencies
      // eg. requires(chassis);
      requires(Robot.driveTrain);
    }
  
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
  
      double tx = Robot.driveTrain.gLimeLight().getdegRotationToTarget();
      boolean targetFound = Robot.driveTrain.gLimeLight().getIsTargetFound();
  
      if(targetFound){
        m_moveValue = 0;
        m_rotateValue = tx * kpAim;
      }else{
        m_moveValue = 0;
        m_rotateValue = 0;
      }
  
      Robot.driveTrain.My_DriveArchade(m_moveValue, m_rotateValue);
      
    }
  
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      return false;
    }
  
    // Called once after isFinished returns true
    @Override
    protected void end() {
      Robot.driveTrain.My_DriveArchade(0,0);
    }
  
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
      end();
    }
  }