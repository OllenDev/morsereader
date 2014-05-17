package com.teamramrod.secretdecoder;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import com.teamramrod.secertdecoder.R;
import com.teamramrod.secretdecoder.morsetranslator.Frame;
import com.teamramrod.secretdecoder.morsetranslator.Tanslator;

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

	private Mat grayMat;
	private Mat tempMat;
	private Mat blackMat;
	private Scalar blackSum;
	private Mat zoomCorner;
	private Mat zoomWindow;
	private Size grayMatSize;

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
		grayMat = new Mat();
		tempMat = new Mat();
		zoomCorner = new Mat();
		zoomWindow = new Mat();
		// mZoom = new Mat();
		//blackMat = new Mat(new Size(512, 288), 0, new Scalar(0));
		//blackSum = Core.sumElems(blackMat);
		StartSubmats();
	}

	private void StartSubmats() {
		if (grayMat.empty())
			return;

		grayMatSize = grayMat.size();
		System.out.println("GrayMatSize: " + grayMatSize.width + "x" + grayMatSize.height);
		int rows = (int) grayMatSize.height;
		int cols = (int) grayMatSize.width;

//		int left = cols / 8;
//		int top = rows / 8;
//
//		int width = cols * 3 / 4;
//		int height = rows * 3 / 4;

		if (zoomCorner == null) {
			zoomCorner = grayMat.submat(0, rows / 2 - rows / 10, 0, cols / 2 - cols / 10);
		} else if(zoomCorner.size().height == 0 || zoomCorner.size().width == 0){
			zoomCorner = grayMat.submat(0, rows / 2 - rows / 10, 0, cols / 2 - cols / 10);
		}
				
		if (zoomWindow == null) {
			//zoomWindow = grayMat.submat(0, rows / 2 - rows / 10, 0, cols / 2 - cols / 10);
			zoomWindow = grayMat.submat(rows / 2 - 9 * rows / 100, rows / 2 + 9 * rows / 100, cols / 2 - 9 * cols / 100, cols / 2 + 9 * cols / 100);
		} else if(zoomWindow.size().height == 0 || zoomWindow.size().width == 0){
			//zoomWindow = grayMat.submat(0, rows / 2 - rows / 10, 0, cols / 2 - cols / 10);
			zoomWindow = grayMat.submat(rows / 2 - 9 * rows / 100, rows / 2 + 9 * rows / 100, cols / 2 - 9 * cols / 100, cols / 2 + 9 * cols / 100);
		}
		
		blackMat = new Mat(zoomCorner.size(), zoomCorner.type(), Scalar.all(0));
		blackSum = Core.sumElems(blackMat);
	}

	@Override
	public void onCameraViewStopped() {
		// TODO Auto-generated method stub
		if (grayMat != null)
			grayMat.release();
		if (tempMat != null)
			tempMat.release();
		if(zoomCorner != null)
			zoomCorner.release();
		if(zoomWindow != null)
			zoomWindow.release();
		if(blackMat != null)
			blackMat.release();
	}
	
	Tanslator t;

	@Override
	public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
		grayMat = inputFrame.gray();
		int cols = grayMat.cols();
		int rows = grayMat.rows();
		
		if(grayMatSize == null)  {
			StartSubmats();
			return grayMat;
		}
		
		double matWidth = grayMatSize.width;
		double matHeight = grayMatSize.height;
		
		if ((zoomCorner == null) || (zoomWindow == null) || (grayMat.cols() != matWidth) || (grayMat.rows() != matHeight)) {
            StartSubmats();
            return grayMat;
		}
		
		System.out.println("ZoomWindow: " + zoomWindow.size().width + "x" + zoomWindow.size().height);
		System.out.println("ZoomCorner: " + zoomCorner.size().width + "x" + zoomCorner.size().height);
        
        Imgproc.resize(zoomWindow, zoomCorner, zoomCorner.size());
        
        Imgproc.GaussianBlur(zoomCorner, tempMat, new Size(5, 5), 0.0);
		Imgproc.threshold(tempMat, tempMat, 220, 255, 0);

        Size wsize = zoomWindow.size();
        Core.rectangle(zoomWindow, new Point(1, 1), new Point(wsize.width - 2, wsize.height - 2), new Scalar(255, 0, 0, 255), 2);
		
		//System.out.println("frame size: " + tempMat.rows() + "x" + tempMat.cols());// + " | type: " + tempMat.type());
		Scalar dimSum = Core.sumElems(tempMat);
		System.out.println("black sum: " + blackSum.val[0] + ", "
				+ blackSum.val[1] + ", " + blackSum.val[2] + " | " + "dimSum: "
				+ dimSum.val[0] + ", " + dimSum.val[1] + ", " + dimSum.val[2]);
		boolean match = blackSum.val[0] == dimSum.val[0] && blackSum.val[1] == dimSum.val[1] && blackSum.val[2] == dimSum.val[2];
		System.out.println("what's the word: " + match);
		
		
		if(t == null) {
			t = new Tanslator();	
		}
		
		t.addFrame(new Frame(!match));
		String stuff = t.getMessage();
		
		if(stuff != null) {
			t = null;
		}
		
		return grayMat;
	}

	private void displayViewModeToUser() {
		Toast.makeText(this, "Starting...", Toast.LENGTH_SHORT).show();
	}
}
