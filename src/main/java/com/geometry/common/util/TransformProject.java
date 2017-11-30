package com.geometry.common.util;

import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

import com.geometry.jts.util.JTSGeometryUtil;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
/**
 * 地理坐标系转空间坐标系 含UTM转换和高斯克吕格转换
 * @author ydx
 *
 */
public class TransformProject {
	/**
	 * 获取UTM srid
	 * @param lon
	 * @return
	 */
	public int getSRIDUTM(double lon) {
		int zone = (int) ((lon / 6) + 31);
		int srid = Integer.parseInt((("" + 326) + zone));
		return srid;
	}
	/**
	 * 获取高斯克吕格srid
	 * @param lon
	 * @param type 3度分带还是6度分带
	 * @return
	 */
	public int getSRIDGauss(double lon,int type) {
		return 4610;
	}
	/**
     * 投影转换， lon=经度，lat=纬度，ESPG格式（例）：EPSG:4610
     */
    public static Point projectTransform(double lon, double lat,
            String epsgSource, String epsgTarget) throws Exception {
        // 原始坐标点
        // PS:通常逻辑上理解经度应该是横坐标x，纬度是y，可是这里经度要填到y，纬度x，否则会报错
    	JTSGeometryUtil jtsUtil = new JTSGeometryUtil();
        Point sourcePoint = jtsUtil.createPoint(lat, lon);

        // 定义转换前和转换后的投影，可以用ESPG或者wkt
        // "PROJCS[\"Xian_1980_3_Degree_GK_CM_111E\",GEOGCS[\"GCS_Xian_1980\",DATUM[\"D_Xian_1980\",SPHEROID[\"Xian_1980\",6378140.0,298.257]],PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],PROJECTION[\"Gauss_Kruger\"],PARAMETER[\"False_Easting\",500000.0],PARAMETER[\"False_Northing\",0.0],PARAMETER[\"Central_Meridian\",111.0],PARAMETER[\"Scale_Factor\",1.0],PARAMETER[\"Latitude_Of_Origin\",0.0],UNIT[\"Meter\",1.0]]";
        // CoordinateReferenceSystem mercatroCRS = CRS.parseWKT(strWKTMercator);
        CoordinateReferenceSystem crsSource = CRS.decode(epsgSource);
        CoordinateReferenceSystem crsTarget = CRS.decode(epsgTarget);
        // 投影转换
        MathTransform transform = CRS.findMathTransform(crsSource, crsTarget);
        Point pointTarget = (Point) JTS.transform(sourcePoint, transform);
        return pointTarget;
    }
    
}
