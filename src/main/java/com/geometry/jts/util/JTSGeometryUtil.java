package com.geometry.jts.util;

import com.geometry.common.util.CoordinateConversion;
import com.geometry.exceptions.TypeException;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class JTSGeometryUtil {
	private GeometryFactory geometryFactory = new GeometryFactory();
	private final int SRID = 4326;

	/**
	 * 创建一个点
	 * 
	 * @param x 纬度
	 * @param y 经度
	 * @return
	 */
	public Point createPoint(double x, double y) {
		Coordinate coord = new Coordinate(x, y);
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

	public double getPolygonArea(String wktText) throws Exception {
		WKTReader reader = new WKTReader(geometryFactory);
		double area = 0L;
		CoordinateConversion coordConversion = new CoordinateConversion();
		System.out.println(coordConversion.latLon2MGRUTM(32.90486423,117.37725692));
		if (wktText.contains("POLYGON")) {
			if (wktText.contains("MULTIPOLYGON")) {
				MultiPolygon multiPolygon = (MultiPolygon) reader.read(wktText);
				multiPolygon.setSRID(SRID);
				area = multiPolygon.getArea();
			} else {
				Polygon polygon = (Polygon) reader.read(wktText);
				polygon.setSRID(SRID);
				area = polygon.getArea();
			}
			
		} else {
			throw new TypeException("请输入WKT面格式数据");
		}
		
		return area;
	}
}
