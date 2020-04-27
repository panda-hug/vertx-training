package consts;

public enum ServerMessages {
    SERVER_LISTENING ("Server listening on port"),
    SERVER_FAILED ("Server failed");

    private final String message;

    ServerMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
