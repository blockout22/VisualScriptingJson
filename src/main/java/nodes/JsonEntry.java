package nodes;

import imgui.type.ImString;
import pins.PinJsonString;
import visual.scripting.Graph;
import visual.scripting.NodeData;
import visual.scripting.node.NodeEntry;
import visual.scripting.pin.Pin;
import visual.scripting.ui.Button;
import visual.scripting.ui.listeners.LeftClickListener;

public class JsonEntry extends NodeEntry {

    private JsonEntry self;

    public JsonEntry(Graph graph) {
        super(graph);
        self = this;
        setLanguages(new String[]{"json"});
        setCategory("json");
        setName("JsonEntry");
        setColor(230, 204, 10, 255);
    }

    @Override
    public void init() {
        Button button = addButton("Add Input");
        button.addLeftClickListener(new LeftClickListener() {
            @Override
            public void onClicked() {
                Pin pin = new PinJsonString();
                pin.setNode(self);
                addCustomInput(pin);
//                addInputPin(Pin.DataType.String, self);
            }
        });
        Pin pin = new PinJsonString();
        pin.setNode(self);
        addCustomInput(pin);
//        addInputPin(Pin.DataType.String, this);
    }

    @Override
    public void execute() {
        for (int i = 0; i < inputPins.size(); i++) {
            Pin pin = inputPins.get(i);
            if(pin.connectedTo != -1){
                Pin con = getGraph().findPinById(pin.connectedTo);

                NodeData<ImString> outValue = pin.getData();
                NodeData<ImString> conValue = con.getData();
                outValue.getValue().set(conValue.value.get());
            }
        }
    }

    @Override
    public String printSource(StringBuilder sb) {
        sb.append("{");

        String toPrint = "";

        for (int i = 0; i < inputPins.size() - 1; i++) {
            Pin inPin = inputPins.get(i);

            NodeData<ImString> data = inPin.getData();
            String input = String.valueOf(data.value.get());

            if (inPin.connectedTo != -1) {
                Pin pin = getGraph().findPinById(inPin.connectedTo);
                input = pin.getNode().printSource(sb);
            }
            sb.append(input);
            sb.append(",");
        }

        if(inputPins.size() > 0){
            Pin inPin = inputPins.get(inputPins.size() - 1);
            NodeData<ImString> data = inPin.getData();
            String input = String.valueOf(data.value.get());

            if (inPin.connectedTo != -1) {
                Pin pin = getGraph().findPinById(inPin.connectedTo);
                input = pin.getNode().printSource(sb);
            }

            sb.append(input);
        }

        sb.append("}");
        return "";
    }
}
