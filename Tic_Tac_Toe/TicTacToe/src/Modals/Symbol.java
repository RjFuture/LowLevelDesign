package Modals;

import java.util.Objects;

public class Symbol {
    private String name;
    private String img;

    public Symbol(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this==obj) return true;
        if(obj==null || this.getClass()!=obj.getClass()) return false;
        Symbol other = (Symbol)(obj);
        return (other.getName().equals(name) && other.getImg().equals(img));
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name,img);
    }
}
