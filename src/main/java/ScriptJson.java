import nodes.JsonEntry;
import nodes.Node_String;
import visual.scripting.GraphWindow;
import visual.scripting.VisualScriptingPlugin;

public class ScriptJson extends VisualScriptingPlugin {
    @Override
    public void init(GraphWindow graphWindow) {
        graphWindow.addNodeToList(JsonEntry.class);
        graphWindow.addNodeToList(Node_String.class);
    }
}
