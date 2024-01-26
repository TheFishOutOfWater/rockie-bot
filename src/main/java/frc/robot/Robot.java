// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  private Talon m_lmoter1 = new Talon(0);
  private Talon m_lmoter2 = new Talon(1);
  private Talon m_rmoter1 = new Talon(2);
  private Talon m_rmoter2 = new Talon(3);

  private Talon m_climbmoter1 = new Talon(6);
  private Talon m_climbmoter2 = new Talon(7);
  private Talon m_ampmoter1 = new Talon(8);
  private Talon m_ampmoter2 = new Talon(8);
  private Talon m_spmoter1 = new Talon(9);
  private Talon m_spmoter2 = new Talon(10);

  private MotorControllerGroup m_lmotor = new MotorControllerGroup(m_lmoter1, m_lmoter2);
  private MotorControllerGroup m_rmotor = new MotorControllerGroup(m_rmoter1, m_rmoter2);

  private DifferentialDrive diffDrive = new DifferentialDrive(m_lmotor, m_rmotor);

  private XboxController driver = new XboxController(0);

  private boolean speakermode = (false);
  private int station;
  

  @Override
  public void robotInit() {
    if(driver.getRightBumper()){
      speakermode = true;
    }else if(driver.getRightBumper()){
      speakermode = false;
    }
    //for(int i=1;driver.getLeftBumper()==true;i++){}
    while(driver.getLeftBumper()==true){
      int i=0;
      if(driver.getLeftBumper()==false){
        i++;
        if(i==1){
          station = 1;
        }else if(i==2){
          station = 2;
        }else if(i==3){
          station = 3;
        }else if(i==4){
          station = 4;
        }else if(i>4){
          i=1;
        }
      }

    }

  }
  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {

  }
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    
    if(speakermode){
      //speaker code goes here
      diffDrive.arcadeDrive(driver.getRawAxis(4)*.7, driver.getRawAxis(1)*.7);

    }else{
      //amp code goes here
      diffDrive.arcadeDrive(driver.getRawAxis(4)*.7, driver.getRawAxis(1)*.7);
    }
    if(driver.getRawButton(4)){
      //climber code goes here
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
