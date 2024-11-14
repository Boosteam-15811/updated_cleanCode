package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class learn
{
    //creating the motor and giving them names
    private final DcMotor FRMotor;
    private final DcMotor FLMotor;
    private final DcMotor BRMotor;
    private final DcMotor BLMotor;

    //creation of the drive class and declaration of the motors
    public learn(DcMotor FR, DcMotor FL, DcMotor BR, DcMotor BL)
    {
        FRMotor = FR;
        FLMotor = FL;
        BRMotor = BR;
        BLMotor = BL;
    }

    public void forwardBackward(double power)
    {
        FRMotor.setPower(power);
        FLMotor.setPower(power);
        BRMotor.setPower(power);
        BLMotor.setPower(power);
    }

    public void rightLeft(double power)
    {
        FRMotor.setPower(-power);
        FLMotor.setPower(power);
        BRMotor.setPower(power);
        BLMotor.setPower(-power);
    }

    public void rotate(double power)
    {
        FRMotor.setPower(-power);
        FLMotor.setPower(power);
        BRMotor.setPower(-power);
        BLMotor.setPower(power);
    }

    public void arcade(double x, double y, double rx)
    {
        FRMotor.setPower(y-x-rx);
        FLMotor.setPower(y+x+rx);
        BRMotor.setPower(y+x-rx);
        BLMotor.setPower(y-x+rx);
    }
}
