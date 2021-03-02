package com.example.cargadeimagenes_esmeralda;

public class GetterYSetterHeroe {

    private String textoIMG;
    private String imageurl;

    public GetterYSetterHeroe(String textoIMG, String URLimg) {
        this.textoIMG = textoIMG;
        this.imageurl = URLimg;
    }

    public String getTextoIMG() {
        return textoIMG;
    }

    public void setTextoIMG(String textoIMG) {
        this.textoIMG = textoIMG;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
