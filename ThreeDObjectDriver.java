import java.util.*;
import java.lang.Math;

abstract class ThreeDObject{
    protected double dim1, dim2, dim3;

    abstract double volume();
    abstract double surfaceAr();
}
class Box extends ThreeDObject{
    Box(double dim1, double dim2, double dim3){
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.dim3 = dim3;
    }
    public double volume(){
        return dim1*dim2*dim3;
    }
    public double surfaceAr(){
        return 2*(dim1*dim2 + dim2*dim3 + dim3*dim1);
    }
}
class Cube extends ThreeDObject{
    Cube(double side){
        this.dim1=side;
    }
    public double volume(){
        return dim1*dim1*dim1;
    }
    public double surfaceAr(){
        return 6*dim1*dim1;
    }
}
class Cylinder extends ThreeDObject{
    Cylinder(double r, double h){
        this.dim1=r;
        this.dim2=h;
    }
    public double volume(){
        return Math.PI*dim1*dim1*dim2;
    }
    public double surfaceAr(){
        return 2*Math.PI*dim1*(dim1+dim2);
    }
}
class Cone extends ThreeDObject{
    Cone(double r, double h){
        this.dim1=r;
        this.dim2=h;
    }
    public double volume(){
        return (1.0/3.0)*Math.PI*dim1*dim1*dim2;
    }
    public double surfaceAr(){
        double l=Math.sqrt(dim1*dim1 + dim2*dim2);
        return Math.PI*dim1*(dim1+l);
    }
}

class ThreeDObjectDriver{
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int ch;
        do{
            System.out.println("\n--- MENU ---");
            System.out.println("1. Box");
            System.out.println("2. Cube");
            System.out.println("3. Cylinder");
            System.out.println("4. Cone");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            ch = in.nextInt();
            ThreeDObject obj=null;
            switch(ch){
                case 1:
                    System.out.print("Enter length, breadth, height: ");
                    double l = in.nextDouble();
                    double b = in.nextDouble();
                    double h = in.nextDouble();
                    obj = new Box(l, b, h);
                    break;
                case 2:
                    System.out.print("Enter side: ");
                    double s = in.nextDouble();
                    obj = new Cube(s);
                    break;
                case 3:
                    System.out.print("Enter radius and height: ");
                    double r1 = in.nextDouble();
                    double h1 = in.nextDouble();
                    obj = new Cylinder(r1, h1);
                    break;
                case 4:
                    System.out.print("Enter radius and height: ");
                    double r2 = in.nextDouble();
                    double h2 = in.nextDouble();
                    obj = new Cone(r2, h2);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");

            }
            if(obj!=null){
                System.out.println("Volume = " + obj.volume());
                System.out.println("Surface Area = " + obj.surfaceAr());
            }
        }while(ch!=5);
        in.close();
    }
}