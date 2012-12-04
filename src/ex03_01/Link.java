package ex03_01;

public class Link {

    public Link(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return name.equals(((Link) o).name);
    }
    
    /**
     * Nazwa elementu.
     */
    private String name;
}
