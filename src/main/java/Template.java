import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by crystalsphere on 5/22/16.
 */
public class Template {
    private Map<String, String> variables;
    private String templateText;
    public Template(String s) {
        this.variables = new HashMap<String, String>();
        this.templateText = s;
    }

    public void set(String name, String reader) {

        this.variables.put(name, reader);
    }

    public String evaluate() {
        String result = replaceVariables();
        checkForMissingValues(result);
        return result;
    }

    private String replaceVariables(){
        String result = templateText;
        for (Map.Entry<String, String> entry: variables.entrySet()) {
            result = result.replaceAll("\\$\\{"+ entry.getKey()+"\\}",entry.getValue());

        }
        return result;
    }

    private void checkForMissingValues(String result){
        Matcher m = Pattern.compile("\\$\\{.+\\}").matcher(result);
        if (m.find()){
            throw new MissingValueException("No value for " + m.group());
        }
    }
}
