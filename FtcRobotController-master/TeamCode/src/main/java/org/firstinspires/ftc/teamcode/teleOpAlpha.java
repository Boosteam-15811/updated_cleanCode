package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

@TeleOp
public class teleOpAlpha extends LinearOpMode
{
    private DcMotor FRMotor;
    private DcMotor FLMotor;
    private DcMotor BRMotor;
    private DcMotor BLMotor;

    @Override
    public void runOpMode() throws InterruptedException
    {
        FRMotor = hardwareMap.dcMotor.get("FRMotor");
        FLMotor = hardwareMap.dcMotor.get("FLMotor");
        BRMotor = hardwareMap.dcMotor.get("BRMotor");
        BLMotor = hardwareMap.dcMotor.get("BLMotor");

        FLMotor.setDirection(DcMotor.Direction.REVERSE);
        BLMotor.setDirection(DcMotor.Direction.REVERSE);

        FRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BRMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BLMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        DriveClass driveClass = new DriveClass(FRMotor, FLMotor, BRMotor, BLMotor);

        IMU imu = hardwareMap.get(IMU.class, "imu");

        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.LEFT));

        imu.initialize(parameters);

        waitForStart();
        while(opModeIsActive())
        {
            if (gamepad1.options)
            {
                imu.resetYaw();
            }
            if(gamepad1.right_trigger > 0)
            {
                driveClass.drive(gamepad1.right_trigger*0.75);
            }
            else if(gamepad1.left_trigger > 0)
            {
                driveClass.drive(-gamepad1.left_trigger*0.75);
            }
            else
            {
                driveClass.fieldArcade(gamepad1.left_stick_x*0.75, -gamepad1.left_stick_y*0.75, gamepad1.right_stick_x*0.75, imu);
            }
        }
    }
}
