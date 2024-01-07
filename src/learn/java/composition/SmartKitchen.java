package learn.java.composition;

public class SmartKitchen {

    private CofferMaker cofferMaker;
    private DishWasher dishWasher;
    private Refrigerator refrigerator;

    public SmartKitchen(){
        dishWasher = new DishWasher();
        refrigerator = new Refrigerator();
        cofferMaker = new CofferMaker();
    }

    public void setKitchenState(boolean dishWasherFlag, boolean fridgeFlag,
                                boolean coffeeFlag){
        dishWasher.setHasWorkToDo(dishWasherFlag);
        refrigerator.setHasWorkToDo(fridgeFlag);
        cofferMaker.setHasWorkToDo(coffeeFlag);
    }

    public void doKitchenWork(){
        dishWasher.doDishes();
        refrigerator.orderFood();
        cofferMaker.brewCoffer();
    }
}
