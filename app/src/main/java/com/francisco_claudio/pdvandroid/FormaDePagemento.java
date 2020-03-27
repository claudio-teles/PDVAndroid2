package com.francisco_claudio.pdvandroid;

public class FormaDePagemento {
    private Integer langLogo;
    private String langName;

    public FormaDePagemento(Integer langLogo, String langName) {
        this.langLogo = langLogo;
        this.langName = langName;
    }

    public Integer getLangLogo() {
        return langLogo;
    }

    public void setLangLogo(Integer langLogo) {
        this.langLogo = langLogo;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }
}
