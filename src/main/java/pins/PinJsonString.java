package pins;

import imgui.ImDrawList;
import imgui.ImGui;
import imgui.type.ImString;
import visual.scripting.NodeData;
import visual.scripting.pin.Pin;

public class PinJsonString extends Pin {

    public NodeData<ImString> data = new NodeData<>();

    public PinJsonString(){
        setData(data);
        data.setValue(new ImString());
        setColor(1f, 0f, 0f, 1f);
    }

    @Override
    public void loadValue(String value) {
        data.value.set(value);
    }

    @Override
    public void draw(ImDrawList windowDrawList, float posX, float posY, boolean isConnected, boolean pinDragSame) {
        drawDefaultCircle(windowDrawList,posX,posY,isConnected,pinDragSame);
    }

    @Override
    public void UI() {
        if(ImGui.inputText("##" + getID(), data.getValue())){

        }
    }
}
