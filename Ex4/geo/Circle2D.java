package Exe.Ex4.geo;

/** 
 * This class represents a 2D circle in the plane. 
 * Please make sure you update it according to the GeoShape interface.
 * Ex4: you should update this class!
 * @author boaz.benmoshe
 *
 */
public class Circle2D implements GeoShapeable{
	//Fields:
	private Point2D _center;
	private double _radius;
	//Constructor:
	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);
		this._radius = rad;
	}
	public Circle2D(Circle2D c1) {
		this._center = new Point2D(c1._center);
		this._radius = c1._radius;
	}
	
	//Methods:
	public double getRadius() {return this._radius;}
	@Override
	public String toString(){
		return "Circle2D,"+_center.toString()+", "+_radius;
	}
	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}
	
	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}
	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}
	@Override
	public void move(Point2D vec) {
		_center.move(vec);
	}
	@Override
	public GeoShapeable copy() {
		return new Circle2D(this);
	}
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}
	@Override
	/**
	 * This method using scale method of the Point2d and resize the radius by the ratio.
	 */
	public void scale(Point2D center, double ratio) {
		this._center.scale(center, ratio);
		this._radius = this._radius * ratio;
	}
	@Override
	/**
	 * This method using rotate method of the Point2d.
	 */
	public void rotate(Point2D center, double angleDegrees) {
		this._center.rotate(center, angleDegrees);
	}

}
