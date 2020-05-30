package utilities;

import javafx.scene.Node;
import javafx.stage.Stage;

public class StageUtils {

    private StageUtils() {
    }

    public static void closeStage(final Node view){
        final Stage stage = (Stage)view.getScene().getWindow();
        stage.close();
    }

}
