package com.project.appchinese;

class Line {
    private String theme;
    private String français;
    private String hanzi;
    private String pinyin;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getFrançais() {
        return français;
    }

    public void setFrançais(String français) {
        this.français = français;
    }

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String hanzi) {
        this.hanzi = hanzi;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "Line{" +
                "theme='" + theme + '\'' +
                ", français='" + français + '\'' +
                ", hanzi='" + hanzi + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
