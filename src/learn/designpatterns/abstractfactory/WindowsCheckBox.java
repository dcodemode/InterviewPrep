package learn.designpatterns.abstractfactory;

public class WindowsCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Painted Windows checkbox");
    }
}
