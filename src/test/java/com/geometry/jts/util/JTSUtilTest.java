package com.geometry.jts.util;

import org.junit.Test;

import com.vividsolutions.jts.geom.Point;

public class JTSUtilTest {
	private JTSGeometryUtil jtsUtil = new JTSGeometryUtil();
	@Test
	public void createPoint() {
		Point point = jtsUtil.createPoint(117.36027899999999,32.97555699999998);
		System.out.println(point);
		return;
	}
}
