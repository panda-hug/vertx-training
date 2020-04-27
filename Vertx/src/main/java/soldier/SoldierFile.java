package soldier;

import com.google.gson.Gson;
import com.google.inject.Inject;
import io.vertx.core.json.JsonObject;
import json.JsonReader;
import json.JsonWriter;

import java.util.Optional;

/**
 * @author Yael Nisanov
 * @since 04/03/2020
 */

public class SoldierFile {

    private JsonWriter writer;

    private JsonReader reader;

    @Inject
    public SoldierFile(JsonWriter writer, JsonReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public Optional<Soldier> getSoldier(String id) {
        return reader.read().getSoldierById(id);
    }

    public SoldiersList getAllSoldiers() {
        return reader.read();
    }

    public boolean addSoldier(JsonObject jsonObject) {
        SoldiersList soldiers = reader.read();
        Soldier soldier = jsonToSoldier(jsonObject);
        boolean isAdded = soldiers.addSoldier(soldier);
        writer.write(soldiers);
        return isAdded;
    }

    public boolean removeSoldier(String id) {
        SoldiersList soldiers = reader.read();
        boolean isRemoved = soldiers.removeSoldierById(id);
        writer.write(soldiers);
        return isRemoved;
    }

    public boolean updateSoldier(JsonObject jsonObject) {
        SoldiersList soldiers = reader.read();
        Soldier soldier = jsonToSoldier(jsonObject);
        boolean isUpdated = soldiers.updateSoldier(soldier);
        writer.write(soldiers);
        return isUpdated;
    }

    public Soldier jsonToSoldier(JsonObject jsonObject) {
        return new Gson().fromJson(jsonObject.toString(), Soldier.class);
    }

}

