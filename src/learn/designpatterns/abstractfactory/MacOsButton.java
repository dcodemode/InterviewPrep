package learn.designpatterns.abstractfactory;

public class MacOsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Painted MacOS button");
    }
}
