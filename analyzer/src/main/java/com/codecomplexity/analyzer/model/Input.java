package com.codecomplexity.analyzer.model;

public class Input {

    private String code;

    public Input(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Input setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Input{");
        sb.append("code='").append(code).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
