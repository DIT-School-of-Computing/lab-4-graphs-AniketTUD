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
			rainfall[i] = floor(random(500));
		}
	}

	float findSum()
	{
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		return tot;
	}

	public void settings()
	{
		size(700, 700);
	}

	public void setup() {
		colorMode(HSB, 360);
		background(0);
		randomize();

		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : months) {
			println(s);
		}
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
		textAlign(CENTER, CENTER);
		

		switch (mode) {
			case 1:
			{
				float shift = 100;
				float graphWidth = width - shift;
				float graphHeight = height - shift;
				float tickLength = 5;
				float tickY;
				float x;
				float textY;
				float w = (graphWidth - shift) / (float)months.length;
				float cgap = 360 / months.length;
				float c;

				fill(360);
				textSize(25 / (shift / 100));
				text("Rainfall Bar Chart", width / 2, height - (graphHeight + shift / 2));
				stroke(360);
				line(shift, graphHeight, shift, height - graphHeight);
				line(shift, graphHeight, graphWidth, graphHeight);

				for(int i = 0 ; i < 11 ; i++)
				{
					tickY = map(i, 0, 10, shift, graphHeight);
					line(shift, tickY, shift - tickLength, tickY);
					textY = map(i, 0, 10, graphHeight, shift);
					textSize(20);
					text(50 * (i), shift / 2, textY);
				}

				for(int i = 0 ; i < months.length ; i++)
				{
					x = map(i, 0, months.length, shift, graphWidth);
					c = cgap * (float) i;
					fill(c, 360, 360);
					rect(x, graphHeight, w, -rainfall[i]);
					fill(360);
					textSize(15);
					text(months[i], x + w / 2, graphHeight + 25);
				}

				break;
			}
			case 2:
			{
				float shift = 100;
				float graphWidth = width - shift;
				float graphHeight = height - shift;
				float tickLength = 5;
				float tickY;
				float x;
				float x2;
				float textY;
				float w = (graphWidth - shift) / (float)months.length;

				fill(360);
				textSize(25 / (shift / 100));
				text("Rainfall Trend Chart", width / 2, height - (graphHeight + shift / 2));
				stroke(360);
				line(shift, graphHeight, shift, height - graphHeight);
				line(shift, graphHeight, graphWidth, graphHeight);

				for(int i = 0 ; i < 11 ; i++)
				{
					tickY = map(i, 0, 10, shift, graphHeight);
					line(shift, tickY, shift - tickLength, tickY);
					textY = map(i, 0, 10, graphHeight, shift);
					textSize(20);
					text(50 * (i), shift / 2, textY);
				}

				for(int i = 1 ; i < months.length ; i++)
				{
					x = map(i - 1, 0, months.length, shift, graphWidth);
					x2 = map(i, 0, months.length, shift, graphWidth);
					line(x + w / 2, graphHeight - rainfall[i - 1], x2 + w / 2, graphHeight - rainfall[i]);
					fill(360);
					textSize(15);
					text(months[i - 1], x + w / 2, graphHeight + 25);
					if(i == 11)
						text(months[i], x2 + w / 2, graphHeight + 25);
				}

				break;
			}
			case 3:
			{
				float shift = 100;
				float graphDiameter = 400;
				float graphRadius = graphDiameter / 2;
				float start = 0;
				float angle;
				float angleShift = 0;
				float sum = findSum();
				float x;
				float y;
				float cgap = 360 / months.length;
				float c;

				fill(360);
				textSize(25 / (shift / 100));
				text("Rainfall Pie Chart", width / 2, shift / 2);
				noStroke();

				for(int i = 0 ; i < months.length ; i++)
				{
					angle = map(rainfall[i], 0, sum, 0, TWO_PI);
					x = cos(start + angle / 2);
					y = sin(start + angle / 2);

					c = cgap * (float) i;
					fill(c, 300, 360);
					arc(width / 2, height / 2, graphDiameter, graphDiameter, start, angleShift + angle, PIE);

					fill(360);
					text(months[i], (width / 2) + ((graphRadius + 40) * x), (height / 2) + ((graphRadius + 40) * y));
					
					angleShift += angle;
					
					start = angleShift;
				}

				break;
			}
			default:
				
				break;
		}
		
	}
}
