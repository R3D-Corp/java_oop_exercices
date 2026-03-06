package labs.trollshop;

import java.util.Map;

public interface Items {

    public String getName();

    public float getDurability();

    public String getMaterials();

    public int getComponentNumber();
    
    public void update(Material... materials); 
}
