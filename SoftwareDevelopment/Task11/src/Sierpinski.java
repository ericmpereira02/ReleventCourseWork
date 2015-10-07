
public class Sierpinski{
public static void Sierpinski(int n, double x1, double y1, double x2, double y2, double x3, double y3){

   if (n==0) return;
   else{
     n--;

     StdDraw.line(x1, y1, x2, y2);
     StdDraw.line(x2, y2, x3, y3);
     StdDraw.line(x3, y3, x1, y1);

     Sierpinski(n, x1/2, y1/2, x2/2, y2/2, x3/2, y3/2);
     Sierpinski(n, x1/2+one/2, y1/2, x2/2+one/2, y2/2, x3/2+one/2, y3/2);
     Sierpinski(n, x1/2+one/4, y1/2+top/2, x2/2+one/4, y2/2+top/2, x3/2+one/4, y3/2+top/2);
   }
 }

 public static double one, top;

 public static void main(String[] args){
   //int n = Integer.parseInt(args[0]);
   one = 1;
   top = Math.sqrt(3)/2;
   Sierpinski(4,0,0,one,0,.5,top);
 }
}