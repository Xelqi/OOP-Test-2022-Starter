package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	int index = 0;

	public void keyPressed() {
		if (keyCode == LEFT) {
			index -= 1;
			if (index == -1) {
				index = 12;
			}
		}

		if (keyCode == RIGHT) {
			index += 1;
			if (index == 13) {
				index = 0;
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
		print(nematodes);
	}

	public void drawNematode() {
		nematodes.get(index).render(this);
	}
}
