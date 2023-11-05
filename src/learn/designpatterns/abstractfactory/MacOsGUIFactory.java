package learn.designpatterns.abstractfactory;

public class MacOsGUIFactory implements GUIFactory{

    @Override
    public Button button() {
        return new MacOsButton();
    }

    @Override
    public CheckBox checkBox() {
        return new MacOsCheckBox();
    }
}
