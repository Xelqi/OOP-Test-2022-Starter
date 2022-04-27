package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	int xindex = 0;
	int ySize = nematodes.size() - 1;

	public void keyPressed() {
		if (keyCode == LEFT) {
			if (xindex == 0) {
				xindex = ySize;
			} else {
				xindex--;
			}
		} else if (keyCode == RIGHT) {
			if (xindex == ySize) {
				xindex = 0;
			} else {
				xindex++;
			}
		}
	}

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();

		loadNematodes();
		printNematodes();

	}

	public void loadNematodes() {
		Table table = loadTable("nematodes.csv", "header");

		for (TableRow r : table.rows()) {
			Nematode n = new Nematode(r);
			nematodes.add(n);
		}
	}

	public void printNematodes() {
		for (Nematode n : nematodes) {
			System.out.println(n);
		}
	}

	public void draw() {
		nematodes.get(xindex).render(this);
	}
}