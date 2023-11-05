package learn.designpatterns.abstractfactory;

public class WindowsGUIFactory implements  GUIFactory{
    @Override
    public Button button() {
        return new WindowsButton();
    }

    @Override
    public CheckBox checkBox() {
        return new WindowsCheckBox();
    }
}
