// Ai Quynh Nguyen
// CSE 142
// 10/13/17
// TA:Daniel Sullivan
// Assisgnment #3
//
// This program is using graphics to draw circles and square
// At different size and different circles per subfigure 

import java.awt.*;

public class Circles{
   public static void main (String[]args){
   
      DrawingPanel panel = new DrawingPanel (500, 350);
      panel.setBackground(Color.CYAN);
      Graphics g = panel.getGraphics();
      
      mainCircles(g, 0, 0, 100, 10);
      mainCircles(g, 130, 25, 100, 10);
      mainCircles(g, 260, 0, 60, 6);
      mainCircles(g, 360, 50, 80, 4);
      
      square(g, 10, 170, 48, 4, 3);
      square(g, 180, 200, 24, 2, 5);
      square(g, 330, 170, 72, 9, 2);
   }
   
   // Draw the nested circles at postition x, y
   // At given size and circles per subfigure
   public static void mainCircles(Graphics g, int x   , int y,
                                              int size, int sub){
      g.setColor(Color.YELLOW);
      g.fillOval(x, y, size, size);
      g.setColor(Color.BLACK);
      for (int i = 0; i < sub; i++){
         int offset = size / sub;
         int axis = i * ( offset / 2);
         int length = i * offset;
         
         g.drawOval( x + axis, y + axis, size - length, size - length);
      }
   }
   
   // Draw squares at position x, y with given length.
   // With different subfigure nested circles loop.
   public static void square(Graphics g, int a,   int b,int length,
                                         int sub, int chain){
      int radius = length * chain;
      g.setColor(Color.GREEN);
      g.fillRect(a, b, radius, radius);
      g.setColor(Color.BLACK);
      g.drawRect(a, b, radius, radius);
      
      
      // Draw different subfigure nested circles with different rows and column
      for(int j = 0; j < chain; j++){
         for(int i = 0; i< chain; i++){
            mainCircles(g, a, b, length, sub);
            a = a + length;
         }
         a = a - chain * length;
         b = b + length;
      }
      
      // Draw crossed lines
      g.drawLine(a, b, a + radius, b - radius);
      g.drawLine(a + radius, b, a, b - radius);
        
   }
}