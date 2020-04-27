package consts;

public enum SoldierMessages {

    SOLDIERS_LIST("Soldiers list returned.\n"),
    SOLDIER_NOT_FOUND("Soldier not found.\n"),
    SOLDIER_FOUND("Soldier found.\n"),
    SOLDIER_EXIST("Soldier is already exist.\n"),
    SOLDIER_ADDED("The soldier has been added.\n"),
    SOLDIER_REMOVED("Soldier removed.\n"),
    SOLDIER_UPDATED("Soldier updated.\n");

    private final String message;

    SoldierMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
