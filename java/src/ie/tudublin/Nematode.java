package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode {
    private String name;
    private int length;
    private boolean limbs;
    private char gender;
    private boolean eyes;

    public Nematode(String name, int length, boolean limbs, char gender, boolean eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public Nematode(TableRow tr) {
        this(
                tr.getString("name"),
                tr.getInt("length"),
                tr.getInt("limbs") == 1,
                tr.getString("gender").charAt(0),
                tr.getInt("eyes") == 1);
    }

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLimbs() {
        return limbs;
    }

    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isEyes() {
        return eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser pa) {
        float segmentSize = 30;

        float border = (pa.height - (length * segmentSize)) / 2;
        float y = pa.height / 2;
        float x = pa.width / 2;

        pa.ellipseMode(PApplet.CENTER);
        pa.noFill();
        pa.stroke(255);

        // eyes
        if (eyes == true) {
            pa.stroke(pa.random(0, 255), 255, 255);
            pa.line(x - 15, y - 15, x - 30, y - 30);
            pa.line(x + 15, y - 15, x + 30, y - 30);
            pa.circle(x - 32, y - 32, 5);
            pa.circle(x + 32, y - 32, 5);
        }
        pa.textSize(16);
        pa.textAlign(PApplet.CENTER);
        pa.text(name, x, y - 200);

        for (int i = 0; i < length; i++) {
            y = PApplet.map(i, 0, length, border, pa.height - border);

            // segment
            pa.stroke(pa.random(0, 255), 255, 255);
            pa.circle(x, y, segmentSize);
            // limbs
            if (limbs == true) {
                pa.line(x - segmentSize / 2, y, x - segmentSize / 2 - 15, y);
                pa.line(x + segmentSize / 2, y, x + segmentSize / 2 + 15, y);
            }
        }

    }
}