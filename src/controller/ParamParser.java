package controller;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Soravit on 10/21/2016.
 */
public class ParamParser {

    public static final String ERROR = "NO MATCH";
    // "types" and the regular expression patterns that recognize those types
    // note, it is a list because order matters (some patterns may be more generic)
    private Map<String, Integer> paramsCounts;
    public ParamParser() {
        paramsCounts = new HashMap<String, Integer>();
    }

    public void addMappings (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            int numParams = Integer.parseInt(resources.getString(key));
            paramsCounts.put(key, numParams);
        }
    }

    public int getNumParams(String key){
        return paramsCounts.get(key);
    }
}
