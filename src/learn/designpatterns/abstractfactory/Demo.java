package learn.designpatterns.abstractfactory;

public class Demo {

    public static void main(String[] args) {

        Application app;
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();

        if(osName.equals("mac os x")){
            factory = new MacOsGUIFactory();
        }else{
            factory = new WindowsGUIFactory();
        }

        app = new Application(factory);
        app.paint();
    }
}
