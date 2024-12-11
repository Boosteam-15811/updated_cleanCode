package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class encodersClass
{
    // Declare motor objects for the robot
    private static DcMotor FRMotor; // Front-right motor
    private static DcMotor FLMotor; // Front-left motor
    private static DcMotor BRMotor; // Back-right motor
    private static DcMotor BLMotor; // Back-left motor

    // Initialize the motors and set their default configurations
    public static void init(HardwareMap hardwareMap)
    {
        // Link motors to their hardware configurations
        FRMotor = hardwareMap.dcMotor.get("FRMotor");
        FLMotor = hardwareMap.dcMotor.get("FLMotor");
        BRMotor = hardwareMap.dcMotor.get("BRMotor");
        BLMotor = hardwareMap.dcMotor.get("BLMotor");

        // Reverse the direction of the left-side motors
        FLMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BLMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set all motors to brake when power is zero
        FRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    // Convert inches to encoder counts for the motors
    public static int inchesToCount(int inchesToDrive, int countsPerWheelRotation, double wheelRadius)
    {
        double circumfrence = wheelRadius * 2 * Math.PI; // Calculate wheel circumference
        double rotations = inchesToDrive / circumfrence; // Calculate wheel rotations needed
        double countsToDrive = rotations * countsPerWheelRotation; // Calculate encoder counts
        return (int) countsToDrive; // Return encoder counts as an integer
    }

    // Reset all motor encoders to zero
    public void Ereset()
    {
        FRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    // Set motors to run to a specific position
    public void Erun()
    {
        FRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    // Set motors to run using encoders
    public void Euse()
    {
        FRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    // Set individual powers for each motor
    public void setPower(double FRpower, double FLpower, double BRpower, double BLpower)
    {
        FRMotor.setPower(Math.abs(FRpower));
        FLMotor.setPower(Math.abs(FLpower));
        BRMotor.setPower(Math.abs(BRpower));
        BLMotor.setPower(Math.abs(BLpower));
    }

    // Set the same power for all motors
    public void setPower(double power)
    {
        FRMotor.setPower(Math.abs(power));
        FLMotor.setPower(Math.abs(power));
        BRMotor.setPower(Math.abs(power));
        BLMotor.setPower(Math.abs(power));
    }

    // Stop all motors by setting their power to zero
    public void stop()
    {
        FRMotor.setPower(0);
        FLMotor.setPower(0);
        BRMotor.setPower(0);
        BLMotor.setPower(0);
    }

    // Move diagonally in the positive direction
    public void EdiagonalPositive(double cm, double speed)
    {
        Ereset(); // Reset encoders
        Euse(); // Enable encoder mode
        int inch = (int) (cm * 2.54); // Convert cm to inches

        // Set target positions for diagonal motors
        FLMotor.setTargetPosition(FLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
        BRMotor.setTargetPosition(BRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));

        Erun(); // Set motors to run to position
        setPower(0, speed, speed, 0); // Set power for diagonal movement

        // Wait for motors to reach their target positions
        boolean isRunning = true;
        while (isRunning)
        {
            isRunning = FLMotor.isBusy() && BRMotor.isBusy();
        }
        stop(); // Stop motors
        Euse(); // Switch back to encoder mode
    }

    // Move diagonally in the negative direction
    public void EdiagonalNegative(double cm, double speed)
    {
        Ereset(); // Reset encoders
        Euse(); // Enable encoder mode
        int inch = (int) (cm * 2.54); // Convert cm to inches

        // Set target positions for diagonal motors
        FRMotor.setTargetPosition(FRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
        BLMotor.setTargetPosition(BLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));

        Erun(); // Set motors to run to position
        setPower(speed, 0, 0, speed); // Set power for diagonal movement

        // Wait for motors to reach their target positions
        boolean isRunning = true;
        while (isRunning)
        {
            isRunning = FRMotor.isBusy() && BLMotor.isBusy();
        }
        stop(); // Stop motors
        Euse(); // Switch back to encoder mode
    }

    // Move the robot like a drone (strafe movement)
    public void Edrone(double cm, double speed)
    {
        Ereset(); // Reset encoders
        Euse(); // Enable encoder mode
        int inch = (int) (cm * 2.54); // Convert cm to inches

        // Set target positions for strafe movement
        FRMotor.setTargetPosition(FRMotor.getCurrentPosition() - inchesToCount(inch, 384, 5.2));
        FLMotor.setTargetPosition(FLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
        BRMotor.setTargetPosition(BRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
        BLMotor.setTargetPosition(BLMotor.getCurrentPosition() - inchesToCount(inch, 384, 5.2));

        Erun(); // Set motors to run to position
        setPower(speed); // Set motor speed

        // Wait for motors to reach their target positions
        boolean isRunning = true;
        while (isRunning) {
            isRunning = FRMotor.isBusy() && FLMotor.isBusy() && BRMotor.isBusy() && BLMotor.isBusy();
        }
        stop(); // Stop motors
        Euse(); // Switch back to encoder mode
    }

    // Rotate the robot in place
    public void Erotate(double cm, double speed)
    {
        Ereset(); // Reset encoders
        Euse(); // Enable encoder mode
        int inch = (int) (cm * 2.54); // Convert cm to inches

        // Set target positions for rotation
        FRMotor.setTargetPosition(FRMotor.getCurrentPosition() - inchesToCount(inch, 384, 5.2));
        FLMotor.setTargetPosition(FLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
        BRMotor.setTargetPosition(BRMotor.getCurrentPosition() - inchesToCount(inch, 384, 5.2));
        BLMotor.setTargetPosition(BLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));

        Erun(); // Set motors to run to position
        setPower(speed); // Set motor speed

        // Wait for motors to reach their target positions
        boolean isRunning = true;
        while (isRunning)
        {
            isRunning = FRMotor.isBusy() && FLMotor.isBusy() && BRMotor.isBusy() && BLMotor.isBusy();
        }
        stop(); // Stop motors
        Euse(); // Switch back to encoder mode
    }

    // Move the robot forward or backward
    public void EDrive(double cm, double speed)
    {
        Ereset(); // Reset encoders
        Euse(); // Enable encoder mode
        int inch = (int) (cm * 2.54); // Convert cm to inches

        // Set target positions for all motors
        FRMotor.setTargetPosition(FRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
        FLMotor.setTargetPosition(FLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
        BRMotor.setTargetPosition(BRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
        BLMotor.setTargetPosition(BLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));

        Erun(); // Set motors to run to position
        setPower(speed); // Set motor speed

        // Wait for motors to reach their target positions
        boolean isRunning = true;
        while (isRunning)
        {
            isRunning = FRMotor.isBusy() && FLMotor.isBusy() && BRMotor.isBusy() && BLMotor.isBusy();
        }
        stop(); // Stop motors
        Euse(); // Switch back to encoder mode
    }
}
