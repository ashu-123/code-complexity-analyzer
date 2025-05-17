package com.codecomplexity.analyzer.model;

public class CodeComplexity {

    private String complexity;

    public CodeComplexity(String complexity) {
        this.complexity = complexity;
    }

    public String getComplexity() {
        return complexity;
    }

    public CodeComplexity setComplexity(String complexity) {
        this.complexity = complexity;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CodeComplexity{");
        sb.append("complexity='").append(complexity).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
