package store.phone;

import store.ItemType;

public class PhoneType extends ItemType {
    private PhoneBranch phoneBranch;

    public PhoneType(PhoneBranch phoneBranch, String name, String version, Long price) {
        super(name, version, price);
        this.phoneBranch = phoneBranch;
    }

    public PhoneBranch getBranch() {
        return phoneBranch;
    }

    public void setBranch(PhoneBranch phoneBranch) {
        this.phoneBranch = phoneBranch;
    }

    @Override
    public String toString() {
        return "PhoneType{" +
                "branch=" + phoneBranch +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", price=" + price +
                '}';
    }
}
