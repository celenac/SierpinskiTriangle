import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

float move=94;
public void setup()
{
	size(1000,700);
	stroke(0);
}
public void draw()
{
	background(250);
	sierpinski(250,550,500);
}
public void sierpinski(int x, int y, int len) 
{
	if(len>50) //recursive case
	{
		sierpinski(x,y,len/2);
		sierpinski(x+len/2,y,len/2);
		sierpinski(x+len/4, y-len/2, len/2);
	}
	else 
	{
		//base case
		if(keyPressed==true && keyCode==UP)
		{
			move=move+.05f;
		}
		else if (keyPressed==true && keyCode==DOWN)
		{
			move=move-.05f;
		}
		fill(200,0,0,100);
		triangle(x+move,y,x+move+len,y,x+move+(len/2),y-len);
		fill(200,200,0,100);
		triangle(x-move,y,x-move+len,y,x-move+(len/2),y-len);
		fill(0,200,100);
		triangle(x,y,x+len,y,x+(len/2),y-len);
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
