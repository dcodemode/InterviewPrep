package learn.designpatterns.abstractfactory;

public class Application {

    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory){
        button = factory.button();
        checkBox = factory.checkBox();
    }

    public void paint(){
        button.paint();
        checkBox.paint();
    }
}

