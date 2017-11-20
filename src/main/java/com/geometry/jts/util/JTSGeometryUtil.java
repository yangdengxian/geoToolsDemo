package com.geometry.jts.util;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class JTSGeometryUtil {
	private GeometryFactory geometryFactory = new GeometryFactory();
	/**
	 * 创建一个点
	 * @param x
	 * @param y
	 * @return
	 */
	public Point createPoint(double x,double y) {
		Coordinate coord = new Coordinate(x,y);
		Point point = geometryFactory.createPoint(coord);
		return point;
	}
	
	public Point createPointByWKT(String wktPoint) throws ParseException {
		WKTReader wktReader = new WKTReader(geometryFactory);
		Point point = (Point) wktReader.read(wktPoint);
		return point;
	}
	
	public MultiPoint createMultiPoint(Point[] points) {
		MultiPoint multiPoint = geometryFactory.createMultiPoint(points);
		return multiPoint;
	}
	
	public MultiPoint createMultiPoint(Coordinate[] coordinates) {
		MultiPoint multiPoint = geometryFactory.createMultiPoint(coordinates);
		return multiPoint;
	}
	
	public MultiPoint createMultiPoint(CoordinateSequence coordinates) {
		MultiPoint multiPoint = geometryFactory.createMultiPoint(coordinates);
		return multiPoint;
	}

}
