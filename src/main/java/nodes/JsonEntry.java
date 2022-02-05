package nodes;

import imgui.type.ImString;
import visual.scripting.Graph;
import visual.scripting.NodeData;
import visual.scripting.Pin;
import visual.scripting.node.NodeEntry;

public class JsonEntry extends NodeEntry {

    private Pin inPin;

    public JsonEntry(Graph graph) {
        super(graph);
        setLanguages(new String[]{"json"});
        setCategory("json");
        setName("JsonEntry");
        setColor(230, 204, 10, 255);
    }

    @Override
    public void init() {
        inPin = addInputPin(Pin.DataType.String, this);
    }

    @Override
    public void execute() {

    }

    @Override
    public String printSource(StringBuilder sb) {
        sb.append("{");

        NodeData<ImString> data = inPin.getData();
        String input = String.valueOf(data.value.get());

        if(inPin.connectedTo != -1){
            Pin pin = getGraph().findPinById(inPin.connectedTo);
            input = pin.getNode().printSource(sb);
        }
        sb.append(input);
        sb.append("}");
        return "";
    }
}
