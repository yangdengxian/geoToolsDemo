package com.geometry.jts.util;

import org.junit.Test;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;

public class JTSUtilTest {
	private JTSGeometryUtil jtsUtil = new JTSGeometryUtil();
	@Test
	public void createPoint() {
		Point point = jtsUtil.createPoint(117.36027899999999,32.97555699999998);
		System.out.println(point);
	}
	@Test
	public void getPolygonArea() throws Exception {
		String wktText = "MULTIPOLYGON  ((( 117.37725692 32.90486423, 117.38096891 32.90909904, 117.37631611 32.90998804, 117.37725692 32.90486423)),(( 117.37450249 32.90121126, 117.37544391 32.89952797, 117.37781964 32.90069934, 117.37725692 32.90486423, 117.37450249 32.90121126)))";
		System.out.println(jtsUtil.getPolygonArea(wktText));
	}
}
