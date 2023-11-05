package learn.designpatterns.abstractfactory;

public class MacOsCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Painted MacOS checkbox");
    }
}
