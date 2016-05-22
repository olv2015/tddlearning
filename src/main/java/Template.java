/**
 * Created by crystalsphere on 5/22/16.
 */
public class Template {
    private String reader;
    private String templateText;
    public Template(String s) {
        this.templateText = s;
    }

    public void set(String name, String reader) {
        this.reader = reader;
    }

    public String evaluate() {

        return templateText.replaceFirst("\\$\\{name\\}",reader);
    }
}
