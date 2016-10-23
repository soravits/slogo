package model;

public class Variable implements VariableInterface {
    
    private String variableName;
    private Object variableValue;
    
    public Variable(Object name, Object value){
        variableName = name.toString();
        variableValue = value;
    }

    @Override
    public String getVariableName () {
        return variableName;
    }

    @Override
    public Object getVariableValue () {
        return variableValue;
    }
    
    @Override
    public int hashCode(){
        int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + variableName.hashCode();
        hashCode = prime * hashCode + variableValue.hashCode();
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null | obj.getClass() != getClass()){
            return false;
        }
        Variable other = (Variable) obj;
        return ((this == obj) |  (other.getVariableName().equals(variableName)));       
    }
    
}
