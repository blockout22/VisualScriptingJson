package pins;

import imgui.ImDrawList;
import imgui.ImGui;
import imgui.type.ImInt;
import visual.scripting.NodeData;
import visual.scripting.pin.Pin;

public class PinJsonInteger extends Pin {

    NodeData<ImInt> data = new NodeData<>();

    public PinJsonInteger(){
        setData(data);
        data.setValue(new ImInt());
        setColor(1f, 0f, 0f, 1f);
    }

    @Override
    public void loadValue(String value) {
        data.value.set(Integer.valueOf(value));
    }

    @Override
    public void draw(ImDrawList windowDrawList, float posX, float posY, boolean isConnected, boolean pinDragSame) {
        drawDefaultCircle(windowDrawList,posX,posY,isConnected,pinDragSame);
    }

    @Override
    public void UI() {
        if(ImGui.inputInt("##" + getID(), data.getValue())){

        }
    }
}
