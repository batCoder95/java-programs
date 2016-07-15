/**
 * Created by Vatsal Gosaliya on 15-Jul-16.
 *
 * PROBLEM: Given are two rectangles defined over the 2-D cartesian coordinate system.
 *          Each rectangle is expressed using the top-left corner, width and height.
 *          The aim is to detect whether they overlap, and compute the overlapping
 *          area, if they do.
 */

class OverlappingRectangles {
	private double x,y,width,height;

	OverlappingRectangles(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	OverlappingRectangles intersection(OverlappingRectangles rect2) {
        double newX = Math.max(this.x, rect2.x);
        double newY = Math.min(this.y, rect2.y);
        //System.out.println("newX = "+newX);
        //System.out.println("newY = "+newY);

        double newWidth = Math.min(this.x + this.width, rect2.x + rect2.width) - newX;
        double newHeight = newY - Math.max(this.y - this.height, rect2.y - rect2.height);
        //System.out.println("newWidth = "+newWidth);
        //System.out.println("newHeight = "+newHeight);

        if (newWidth <= 0d || newHeight <= 0d){
            System.out.print("No intersection.");
            return null;
        }

        return new OverlappingRectangles(newX, newY, newWidth, newHeight);
    }

	
	public double getArea(){
		return this.width*this.height;
	}
	
	public static void main(String args[]){
		OverlappingRectangles r1 = new OverlappingRectangles(2,8,3,4);
		OverlappingRectangles r2 = new OverlappingRectangles(1,7,6,2);
		OverlappingRectangles r = r1.intersection(r2);
		double areaOfIntersection = r == null ? 0 : r.getArea();
		System.out.print("Area of intersection : "+areaOfIntersection);
	}
}
