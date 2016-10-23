package model;

public class VariableObject {
    
    private String variableName;
    private double variableValue;
    
    public VariableObject(Object name, double value){
        variableName = name.toString();
        variableValue = value;
    }

    public String getVariableName () {
        return variableName;
    }

    public double getVariableValue () {
        return variableValue;
    }
    
    public int hashCode(){
        int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + variableName.hashCode();
        hashCode = prime * hashCode + (int) variableValue;
        return hashCode;
    }

    public boolean equals(Object obj){
        if (obj == null | obj.getClass() != getClass()){
            return false;
        }
        VariableObject other = (VariableObject) obj;
        return ((this == obj) |  (other.getVariableName().equals(variableName)));       
    }
    
}
