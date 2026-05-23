public class PhoneType {
    private Branch branch;
    private String name;
    private String version;
    private Long price;

    public PhoneType(Branch branch, String name, String version, Long price) {
        this.branch = branch;
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PhoneType{" +
                "branch=" + branch +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", price=" + price +
                '}';
    }
}
