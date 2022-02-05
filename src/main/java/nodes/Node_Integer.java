package nodes;

import imgui.type.ImInt;
import imgui.type.ImString;
import visual.scripting.Graph;
import visual.scripting.NodeData;
import visual.scripting.Pin;
import visual.scripting.node.Node;

public class Node_Integer extends Node {

    private Pin inPinTag, inPinValue, outPin;

    public Node_Integer(Graph graph) {
        super(graph);
        setLanguages(new String[]{"json"});
        setCategory("json");
        setName("Json Integer");
    }

    @Override
    public void init() {
        inPinTag = addInputPin(Pin.DataType.String, this).setName("Tag");
        inPinValue = addInputPin(Pin.DataType.Int, this).setName("Value");
        outPin = addOutputPin(Pin.DataType.String, this);
    }

    @Override
    public void execute() {
        NodeData<ImString> dataTag = inPinTag.getData();
        NodeData<ImInt> dataValue = inPinValue.getData();
        NodeData<ImString> dataOut = outPin.getData();

        dataOut.getValue().set("\"" + dataTag.getValue().get() + "\""  + ": "  + dataValue.getValue().get());
    }

    @Override
    public String printSource(StringBuilder sb) {
        NodeData<ImString> outData = outPin.getData();
        sb.append(outData.value.get());
        return "";
    }
}
