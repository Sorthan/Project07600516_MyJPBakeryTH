package su.ac.th.projectmyjpbakeryth.BAKERYdb;

public class Bakery {

    public int id;
    public String dessertname;
    public String desserttype;
    public String dessertprice;
    public int imageRes;

    public Bakery(int id, String dessertname, String desserttype, String dessertprice, int img) {
        this.id = id;
        this.dessertname = dessertname;
        this.desserttype = desserttype;
        this.dessertprice = dessertprice;
        this.imageRes = img;
    }
}
