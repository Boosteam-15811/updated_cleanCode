package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class DriveClass
{
    //creating the motor and giving them names
    private final DcMotor FRMotor;
    private final DcMotor FLMotor;
    private final DcMotor BRMotor;
    private final DcMotor BLMotor;

    //creation of the drive class and declaration of the motors
    public DriveClass(DcMotor FR, DcMotor FL, DcMotor BR, DcMotor BL)
    {
        FRMotor = FR;
        FLMotor = FL;
        BRMotor = BR;
        BLMotor = BL;
    }

    //driving function that allows arcade drive - calculation for 360 degrees of drone driving
    public void arcade(double y, double x,double rx)
    {
        FRMotor.setPower(y - x - rx);
        FLMotor.setPower(y + x + rx);
        BRMotor.setPower(y + x - rx);
        BLMotor.setPower(y - x + rx);
    }

    public void fieldArcade(double x, double y, double rx, IMU imu)
    {
        double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;

        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;

        FLMotor.setPower(frontLeftPower);
        BLMotor.setPower(backLeftPower);
        FRMotor.setPower(frontRightPower);
        BRMotor.setPower(backRightPower);
    }

    //driving function that moves forward or backward based on the given power
    public void drive(double power)
    {
        FRMotor.setPower(power);
        FLMotor.setPower(power);
        BRMotor.setPower(power);
        BLMotor.setPower(power);
    }

    //driving function that turns right or left based on the given power
    public void turn(double power)
    {
        FRMotor.setPower(-power);
        FLMotor.setPower(power);
        BRMotor.setPower(-power);
        BLMotor.setPower(power);
    }

    //driving function that moves right or left based on the given power
    public void slide(double power)
    {
        FRMotor.setPower(-power);
        FLMotor.setPower(power);
        BRMotor.setPower(power);
        BLMotor.setPower(-power);
    }
}
