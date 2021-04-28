package com.zeek.javatest.stringtest;

public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    public void setText(String text) {
        this.text.replace(0, this.text.length(), text);
    }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        text.replace(0, text.length(), "abc");
        System.out.println(text);
    }
}