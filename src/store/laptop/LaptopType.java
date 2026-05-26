package store.laptop;

import store.ItemType;

public class LaptopType extends ItemType {
    private LaptopBranch laptopBranch;

    public LaptopType(LaptopBranch laptopBranch, String name, String version, Long price) {
        super(name, version, price);
        this.laptopBranch = laptopBranch;
    }

    public LaptopBranch getBranch() {
        return laptopBranch;
    }

    public void setBranch(LaptopBranch phoneBranch) {
        this.laptopBranch = phoneBranch;
    }

    @Override
    public String toString() {
        return "LaptopType{" +
                "branch=" + laptopBranch +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", price=" + price +
                '}';
    }
}
