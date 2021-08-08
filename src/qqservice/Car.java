package qqservice;

public class Car {
    public String name = "宝马";
    public int price;
    private String white;

    public void fu1() {
        System.out.println("--->开车");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getWhite() {
        return white;
    }

    public void setWhite(String white) {
        this.white = white;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", white='").append(white).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
