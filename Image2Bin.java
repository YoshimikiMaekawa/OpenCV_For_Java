//ここでは、絶対パスで指定した画像を二値化していきます。

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Image2Bin{

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		int w; //width
		int h; //height
		Mat img=new Mat(); //original image
		Mat grayImg = new Mat(); //gray image
		Mat binImg = new Mat(); //binary image
		
		//read image
		img=Imgcodecs.imread("please, input image's path here.");
		w=img.width();
		h=img.height();
		
		if(w==0 || h==0) {
			System.out.println("path may have some mistakes");
		}else {
			Imgproc.cvtColor(img, grayImg, Imgproc.COLOR_RGB2GRAY);
			Imgproc.threshold(grayImg, binImg, 200, 255, Imgproc.THRESH_BINARY);
			Imgcodecs.imwrite("please, input save name including path.", binImg);
		}
		
	}

}
