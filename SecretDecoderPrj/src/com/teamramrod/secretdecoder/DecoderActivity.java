package com.teamramrod.secretdecoder;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import com.teamramrod.secertdecoder.R;

import android.R.bool;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Toast;

public class DecoderActivity extends Activity implements CvCameraViewListener2,
		GestureDetector.OnGestureListener {
	private static final String TAG = "DecoderActivity";
	private static int REQUEST_CODE = 23;

	public static void call(Activity activity) {
		activity.startActivityForResult(new Intent(activity,
				DecoderActivity.class), REQUEST_CODE);
	}

	public DecoderActivity() {
		Log.i(TAG, "new " + this.getClass());
	}

	private Mat mGray;
	private Mat mTemp;
	private Mat blackMat;
	private Scalar blackSum;

	private CameraBridgeViewBase mOpenCvCameraView;
	private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
		@Override
		public void onManagerConnected(int status) {
			switch (status) {
			case LoaderCallbackInterface.SUCCESS: {
				Log.i(TAG, "OpenCV loaded successfully");
				mOpenCvCameraView.enableView();
			}
				break;
			default: {
				super.onManagerConnected(status);
			}
				break;
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "called onCreate");
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		setContentView(R.layout.activity_main);

		mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.image_manipulations_activity_surface_view);
		mOpenCvCameraView.enableFpsMeter();
		mOpenCvCameraView.setCvCameraViewListener(this);

		new GestureDetector(this, this);

		// viewMode = VIEW_MODE_ZOOM;
		displayViewModeToUser();
	}

	@Override
	public void onPause() {
		super.onPause();
		if (mOpenCvCameraView != null)
			mOpenCvCameraView.disableView();
	}

	@Override
	public void onResume() {
		super.onResume();
		OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_3, this,
				mLoaderCallback);
	}

	public void onDestroy() {
		super.onDestroy();
		if (mOpenCvCameraView != null)
			mOpenCvCameraView.disableView();
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCameraViewStarted(int width, int height) {
		mGray = new Mat();
		mTemp = new Mat();
		// mZoom = new Mat();
		blackMat = new Mat(new Size(512, 288), 0, new Scalar(0));
		blackSum = Core.sumElems(blackMat);
	}

	@Override
	public void onCameraViewStopped() {
		// TODO Auto-generated method stub
		if (mGray != null)
			mGray.release();
		if (mTemp != null)
			mTemp.release();
		// if(mZoom != null)
		// mZoom.release();
	}

	@Override
	public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
		mGray = inputFrame.gray();
		Imgproc.GaussianBlur(mGray, mTemp, new Size(5, 5), 0.0);
		Imgproc.threshold(mTemp, mTemp, 200, 255, 0);

		System.out.println("frame size: " + mTemp.rows() + "x" + mTemp.cols() + " | type: " + mTemp.type());
		Scalar dimSum = Core.sumElems(mTemp);
		System.out.println("black sum: " + blackSum.val[0] + ", " + blackSum.val[1] + ", " + blackSum.val[2] + " | " + "dimSum: "
				+ dimSum.val[0] + ", " + dimSum.val[1] + ", " + dimSum.val[2]);
		boolean match = blackSum.val[0] == dimSum.val[0]
				&& blackSum.val[1] == dimSum.val[1]
				&& blackSum.val[2] == dimSum.val[2];
		System.out.println("what's the word: " + match);
		return mTemp;
	}

	private void displayViewModeToUser() {
		Toast.makeText(this, "Car 23", Toast.LENGTH_SHORT).show();
	}
}
