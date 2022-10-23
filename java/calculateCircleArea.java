import java.util.Scanner;
import java.lang.Math.*;

abstract class Shape {
    int width;
    abstract void area();
}

class Circle extends Shape{
    public Circle(int width){
        this.width = width;
    }

    public void area(){
        System.out.println((double)Math.PI * this.width * this.width);
    }
}

public class Program {
    public static void main(String[ ] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
      
        Circle a = new Circle(x);
        a.area();
    }
}
