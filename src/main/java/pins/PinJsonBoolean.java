package pins;

import imgui.ImDrawList;
import imgui.ImGui;
import imgui.type.ImBoolean;
import visual.scripting.NodeData;
import visual.scripting.pin.Pin;

public class PinJsonBoolean extends Pin {

    NodeData<ImBoolean> data = new NodeData<>();

    public PinJsonBoolean(){
        setData(data);
        data.setValue(new ImBoolean());
        setColor(1, 0.47f, 0f, 1f);
    }

    @Override
    public void loadValue(String value) {
        data.value.set(Boolean.valueOf(value));
    }

    @Override
    public void draw(ImDrawList windowDrawList, float posX, float posY, boolean isConnected, boolean pinDragSame) {
        drawDefaultCircle(windowDrawList,posX,posY,isConnected,pinDragSame);
    }

    @Override
    public void UI() {
        if(ImGui.checkbox("##" + getID(), data.getValue())){

        }
    }
}
