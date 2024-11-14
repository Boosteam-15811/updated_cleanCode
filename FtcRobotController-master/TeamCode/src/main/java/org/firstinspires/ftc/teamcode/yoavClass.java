package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class yoavClass
{

    private final DcMotor FRmotor;
    private final DcMotor FLmotor;
    private final DcMotor BRmotor;
    private final DcMotor BLmotor;

    public yoavClass(DcMotor FR, DcMotor FL, DcMotor BR, DcMotor BL)
    {
        FRmotor = FR;
        FLmotor = FL;
        BRmotor = BR;
        BLmotor = BL;
    }

    
}