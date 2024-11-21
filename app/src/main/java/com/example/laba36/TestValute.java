package com.example.laba36;

public class TestValute {
    private String valuteNumCode;
    private String valuteCharCode;
    private String valuteName;
    private float valuteValue;
    public TestValute(String numCode, String charCode, String name, float value){
        valuteNumCode = numCode;
        valuteCharCode = charCode;
        valuteName = name;
        valuteValue = value;

    }

    public String getValuteCharCode() {
        return valuteCharCode;
    }

    public String getValuteName() {
        return valuteName;
    }

    public String getValuteNumCode() {
        return valuteNumCode;
    }

    public Float getValuteValue() {
        return valuteValue;
    }

    public void setValuteCharCode(String valuteCharCode) {
        this.valuteCharCode = valuteCharCode;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }

    public void setValuteNumCode(String valuteNumCode) {
        this.valuteNumCode = valuteNumCode;
    }

    public void setValuteValue(Float valuteValue) {
        this.valuteValue = valuteValue;
    }
}
