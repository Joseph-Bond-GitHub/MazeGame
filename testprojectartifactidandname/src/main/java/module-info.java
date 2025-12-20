module testprojectid {
    requires javafx.controls;
    requires javafx.fxml;

    opens testprojectid to javafx.fxml;
    exports testprojectid;
}
