package br.com.scargames.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Imagens {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("jogo" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}