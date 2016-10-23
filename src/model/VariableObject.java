package model;

public class VariableObject {
    
    private String variableName;
    private Object variableValue;
    
    public VariableObject(Object name, Object value){
        variableName = name.toString();
        variableValue = value;
    }

    public String getVariableName () {
        return variableName;
    }

    public Object getVariableValue () {
        return variableValue;
    }
    
    public int hashCode(){
        int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + variableName.hashCode();
        hashCode = prime * hashCode + variableValue.hashCode();
        return hashCode;
    }

    public boolean equals(Object obj){
        if (obj == null | obj.getClass() != getClass()){
            return false;
        }
        Variable other = (Variable) obj;
        return ((this == obj) |  (other.getVariableName().equals(variableName)));       
    }
    
}
