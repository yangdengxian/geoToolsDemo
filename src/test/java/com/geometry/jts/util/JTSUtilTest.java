package com.geometry.jts.util;

import org.junit.Test;

import com.geometry.common.util.TransformProject;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;

public class JTSUtilTest {
	private JTSGeometryUtil jtsUtil = new JTSGeometryUtil();
	@Test
	public void createPoint() {
		Point point = jtsUtil.createPoint(32.97555699999998,117.36027899999999);
		System.out.println(point);
	}
	@Test
	public void getPolygonArea() throws Exception {
		String wktText = "MULTIPOLYGON  ((( 117.37725692 32.90486423, 117.38096891 32.90909904, 117.37631611 32.90998804, 117.37725692 32.90486423)),(( 117.37450249 32.90121126, 117.37544391 32.89952797, 117.37781964 32.90069934, 117.37725692 32.90486423, 117.37450249 32.90121126)))";
		System.out.println(jtsUtil.getPolygonArea(wktText));
<<<<<<< HEAD
	}
	
	@Test
	public void transLonLatToXY() {
		TransformProject trans = new TransformProject();
    	Point pointTarget = null;
    	try {
    		pointTarget = trans.projectTransform(117.37725692, 32.90486423, "EPSG:4326", "EPSG:" + trans.getSRIDUTM(117.37725692));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(pointTarget);
=======
>>>>>>> a91da3dbd52c184f4a4bed32826673f2acaf6cde
	}
}
