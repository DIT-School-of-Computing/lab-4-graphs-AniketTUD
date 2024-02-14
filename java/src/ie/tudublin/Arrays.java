package ie.tudublin;

import processing.core.PApplet;



public class Arrays extends PApplet
{
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

	float[] rainfall = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};

	int mode;

	void randomize()
	{
		for (int i = 0; i < rainfall.length; i++) {
			rainfall[i] = random(500);
		}
	}

	public void settings()
	{
		size(700, 700);

		String[] m1 = months;
		
		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : m1) {
			println(s);
		}

		int minIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] > rainfall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");
		
		
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		float avg = tot / (float) rainfall.length;
	}

	public void setup() {
		colorMode(HSB, 360);
		background(0);
		randomize();
	}

	public void keyPressed() {
		if (key >= '0' && key <= '3') {
			mode = key - '0';
		}
		println(mode);
	}
	
	public void draw()
	{	
		background(0);

		switch (mode) {
			case 1:
			{
				float shift = 100;
				float graphWidth = width - shift;
				float graphHeight = height - shift;
				float w = graphWidth / (float)months.length;

				stroke(360);
				line(shift, graphHeight, shift, height - graphHeight);
				line(shift, graphHeight, graphWidth, graphHeight);
				for(int i = 0 ; i < months.length ; i++)
				{
					
				}

				break;
			}
			default:
				//float x = map(i, 0, months.length, 0, width);
				//	rect(x, height, w, -rainfall[i]);
				break;
		}
		
	}
}
