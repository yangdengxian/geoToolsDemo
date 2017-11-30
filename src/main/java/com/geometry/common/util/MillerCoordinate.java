package com.geometry.common.util;
/**
 * 米勒投影转换
 * @author ydx
 *
 */
public class MillerCoordinate {
	public static double[] MillierConvertion(double lon, double lat) {
		double L = 6378137 * Math.PI * 2;// 地球周长
		double W = L;// 平面展开后，x轴等于周长
		double H = L / 2;// y轴约等于周长一半
		double mill = 2.3;// 米勒投影中的一个常数，范围大约在正负2.3之间
		double x = lon * Math.PI / 180;// 将经度从度数转换为弧度
		double y = lat * Math.PI / 180;// 将纬度从度数转换为弧度
		y = 1.25 * Math.log(Math.tan(0.25 * Math.PI + 0.4 * y));// 米勒投影的转换
		// 弧度转为实际距离
		x = (W / 2) + (W / (2 * Math.PI)) * x;
		y = (H / 2) - (H / (2 * mill)) * y;
		double[] result = new double[2];
		result[0] = x;
		result[1] = y;
		return result;
	}
}