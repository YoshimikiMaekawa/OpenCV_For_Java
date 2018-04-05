//ここでは、絶対パスで指定した画像を二値化していきます。

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Image2Bin{
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
		
		//変数設定
		int w; //width
		int h; //height
		Mat img=new Mat(); //original image
		Mat grayImg = new Mat(); //gray image
		Mat binImg = new Mat(); //binary image	
		double[] data=new double[1]; //data of gray image
		
		//画像読み込み
		img=Imgcodecs.imread("please, input path of your image.");
		w=img.width();
		h=img.height();
		
		if(w==0 || h==0) {
			System.out.println("path may have some mistakes");
		}else {
			Imgproc.cvtColor(img, grayImg, Imgproc.COLOR_RGB2GRAY);
		}
		
		//二値化
		Imgproc.threshold(grayImg, binImg, 128, 255, Imgproc.THRESH_BINARY);
		
		//三値化
		for(int i=0; i<w; i++) {
			for(int j=0;j<h;j++) {
				data=grayImg.get(j, i);
				if(0<=data[0] && data[0]<85) {
					grayImg.put(j, i, 0);
				}else if(85<=data[0] && data[0]<170) {
					grayImg.put(j, i, 127);
				}else if(170<=data[0] && data[0]<=255) {
					grayImg.put(j, i, 255);
				}
			}
		}
		
		//保存
		Imgcodecs.imwrite("please, input path to save binImg.", binImg);
		Imgcodecs.imwrite("please, input path to save triImg", grayImg);
	}
}
