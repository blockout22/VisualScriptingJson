import json.JsonEntry;
import visual.scripting.GraphWindow;
import visual.scripting.VisualScriptingPlugin;

public class ScriptJson extends VisualScriptingPlugin {
    @Override
    public void init(GraphWindow graphWindow) {
        graphWindow.addNodeToList(JsonEntry.class);
    }
}
