package json;

import visual.scripting.Graph;
import visual.scripting.node.NodeEntry;

public class JsonEntry extends NodeEntry {
    public JsonEntry(Graph graph) {
        super(graph);
        setLanguages(new String[]{"json"});
        setCategory("json");
        setName("JsonEntry");
        setColor(230, 204, 10, 255);
    }

    @Override
    public void init() {

    }
}
