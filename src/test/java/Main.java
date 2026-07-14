
import static util.CaseConverter.*;

import java.util.Arrays;

import model.TeachingAssistant;
import orm.Reflection;
import orm.Table;

public class Main {

    public static void main(String[] args) {

        Reflection.migrateModels();
    }
}
