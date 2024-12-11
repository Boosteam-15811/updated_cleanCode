//package org.firstinspires.ftc.teamcode;
//
//import android.view.FrameMetrics;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//public class yoavitikunim
//{
//
//    private static DcMotor FRMotor;
//    private static DcMotor FLMotor;
//    private static DcMotor BRMotor;
//    private static DcMotor BLMotor;
//
//    public static void init(HardwareMap hardwareMap)
//    {
//        FRMotor = hardwareMap.dcMotor.get("FRMotor");
//        FLMotor = hardwareMap.dcMotor.get("FLMotor");
//        BRMotor = hardwareMap.dcMotor.get("BRMotor");
//        BLMotor = hardwareMap.dcMotor.get("BLMotor");
//
//        FLMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        BLMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//
//        FRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        FLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        BRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        BLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//    }
//
//    public static int inchesToCount(int inchesToDrive, int countsPerWheelRotation, double wheelRadius)
//    {
//        double circumfrence = wheelRadius * 2 * Math.PI;
//        double rotations = inchesToDrive / circumfrence;
//        double countsToDrive = rotations * countsPerWheelRotation;
//        return (int) countsToDrive;
//    }
//
//    public void Ereset()
//    {
//        FRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        BRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        BLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//    }
//
//    public void Erun()
//    {
//        FRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        FLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        BRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        BLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//    }
//    public void Euse()
//    {
//        FRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        BRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        BLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//    }
//
//    public void setPower(double FRpower, double FLpower, double BRpower, double BLpower)
//    {
//        FRMotor.setPower(Math.abs(FRpower));
//        FLMotor.setPower(Math.abs(FLpower));
//        BRMotor.setPower(Math.abs(BRpower));
//        BLMotor.setPower(Math.abs(BLpower));
//    }
//    public void setPower(double power)
//    {
//        FRMotor.setPower(Math.abs(power));
//        FLMotor.setPower(Math.abs(power));
//        BRMotor.setPower(Math.abs(power));
//        BLMotor.setPower(Math.abs(power));
//    }
//    public void stop()
//    {
//        FRMotor.setPower(0);
//        FLMotor.setPower(0);
//        BRMotor.setPower(0);
//        BLMotor.setPower(0);
//    }
//    public void EdiagonalPositive(double cm, double speed)
//    {
//        Ereset();
//        Euse();
//        int inch = (int) (cm * 2.54);
//
//        FLMotor.setTargetPosition(FLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        BRMotor.setTargetPosition(BRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//
//        Erun();
//        setPower(0, speed, speed, 0);
//        boolean isRunning = true;
//        while (isRunning)
//        {
//            isRunning = isRunning && FLMotor.isBusy();
//            isRunning = isRunning && BRMotor.isBusy();
//        }
//        stop();
//        Euse();
//    }
//
//    public void EdiagonalNegative(double cm, double speed)
//    {
//        Ereset();
//        Euse();
//        int inch = (int) (cm * 2.54);
//
//        FRMotor.setTargetPosition(FRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        BLMotor.setTargetPosition(BLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//
//        Erun();
//        setPower(speed, 0, 0, speed);
//        boolean isRunning = true;
//        while (isRunning)
//        {
//            isRunning = isRunning && FRMotor.isBusy();
//            isRunning = isRunning && BLMotor.isBusy();
//        }
//        stop();
//        Euse();
//    }
//    public void Edrone(double cm, double speed)
//    {
//        Ereset();
//        Euse();
//        int inch = (int) (cm * 2.54);
//
//        FRMotor.setTargetPosition(FRMotor.getCurrentPosition() - inchesToCount(inch, 384, 5.2));
//        FLMotor.setTargetPosition(FLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        BRMotor.setTargetPosition(BRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        BLMotor.setTargetPosition(BLMotor.getCurrentPosition() - inchesToCount(inch, 384, 5.2));
//
//        Erun();
//        setPower(speed);
//        boolean isRunning = true;
//        while (isRunning) {
//            isRunning = isRunning && FRMotor.isBusy();
//            isRunning = isRunning && FLMotor.isBusy();
//            isRunning = isRunning && BRMotor.isBusy();
//            isRunning = isRunning && BLMotor.isBusy();
//        }
//        stop();
//        Euse();
//    }
//    public void Erotate(double cm, double speed)
//    {
//        Ereset();
//        Euse();
//        int inch = (int)(cm * 2.54);
//
//        FRMotor.setTargetPosition(FRMotor.getCurrentPosition() - inchesToCount(inch, 384, 5.2));
//        FLMotor.setTargetPosition(FLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        BRMotor.setTargetPosition(BRMotor.getCurrentPosition() - inchesToCount(inch, 384, 5.2));
//        BLMotor.setTargetPosition(BLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//
//        Erun();
//        setPower(speed);
//        boolean isRunning = true;
//        while(isRunning)
//        {
//            isRunning = isRunning && FRMotor.isBusy();
//            isRunning = isRunning && FLMotor.isBusy();
//            isRunning = isRunning && BRMotor.isBusy();
//            isRunning = isRunning && BLMotor.isBusy();
//        }
//        stop();
//        Euse();
//    }
//
//    public void EDrive(double cm, double speed)
//    {
//        Ereset(); //reset encoders
//        Euse(); //run with encoders
//        int inch = (int)(cm * 2.54); //cm -> inch
//
//        //set target position
//        FRMotor.setTargetPosition(FRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        FLMotor.setTargetPosition(FLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        BRMotor.setTargetPosition(BRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        BLMotor.setTargetPosition(BLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//
//        Erun();//run to position
//        setPower(speed);//set speed
//
//        //run loop
//        boolean isRunning = true;
//        while(isRunning)
//        {
//            isRunning = isRunning && FRMotor.isBusy();
//            isRunning = isRunning && FLMotor.isBusy();
//            isRunning = isRunning && BRMotor.isBusy();
//            isRunning = isRunning && BLMotor.isBusy();
//        }
//
//        stop();//set power to 0
//        Euse();//set back to run using the encoders
//    }
//
//    public void EAccelerate(double cm)
//    {
//        Ereset(); //reset encoders
//        Euse(); //run with encoders
//        int inch = (int)(cm * 2.54);
//        double kp=0.3;
//        roadpercentage perc;
//        double power=0;
//        double road=(FRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        FRMotor.setTargetPosition(FRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        FLMotor.setTargetPosition(FLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        BRMotor.setTargetPosition(BRMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        BLMotor.setTargetPosition(BLMotor.getCurrentPosition() + inchesToCount(inch, 384, 5.2));
//        Erun();
//        while (FRMotor.getCurrentPosition()<inchesToCount(inch, 384, 5.2))
//        {
//            double error = inchesToCount(inch, 384, 5.2) - FRMotor.getCurrentPosition();
//
//            if(FRMotor.getCurrentPosition()<road/3)
//            {
//                perc = roadpercentage.START;
//            }
//            else if (FRMotor.getCurrentPosition()<road/(2.0/3))
//            {
//                perc = roadpercentage.MID;
//            }
//            else
//            {
//                perc = roadpercentage.FINISH;
//            }
//
//            switch (perc)
//            {
//                case START:
//                {
//                    power = 1/(error*kp);
//                }
//                case FINISH:
//                {
//                    power = error*kp;
//                }
//            }
//            setPower(power);
//        }
//    }
//}
