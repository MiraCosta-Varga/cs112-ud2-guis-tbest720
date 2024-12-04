package cs112.ud2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class AddLogoController {
    @FXML
    private TextField logoIDField; //Text field for the logo ID

    @FXML
    private TextField numberOfStopsField; //Text field for the number of color stops

    @FXML
    private ScrollPane stopsScrollPane;

    @FXML
    private VBox stopsVBox;

    private Logo logo; // The Logo object to manage stops

    private ArrayList<MenuButton> menuButtons = new ArrayList<>();
    @FXML


    public void generateStops() {
        System.out.println("Generating stops"); //Show method call in console debug

        try{
            String logoID = logoIDField.getText(); //grab logo id from the logo id text field
            int numberOfStops = Integer.parseInt(numberOfStopsField.getText()); //Grab int from the number of stops text field

            logo = new Logo(logoID,numberOfStops); // create new logo object with the instance variables

            stopsVBox.getChildren().clear(); // clear out the VBox

            //Loop through number of stops. create a new HBox (returned from createStopBox method
            for (int i = 0; i < numberOfStops; i++) {
                HBox stopHBox = createStopBox(i+1);
                stopsVBox.getChildren().add(stopHBox); // add HBox to the VBox
            }
            //Handle all exceptions
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number format for stops."); //Handle unexpected non integer chars
        } catch (InvalidNumberOfStops inos) {
            System.out.println(inos.getMessage()); //throw exception if we have <1 stop or >24 stops
        }

    }

    private HBox createStopBox(int stopIndex) {
       //Create a new HBox and set the spacing and CSS style to match the rest of program
        HBox stopHBox = new HBox();
        stopHBox.setSpacing(10);
        stopHBox.setStyle("-fx-padding: 10; -fx-background-color: #f0f0f0; -fx-border-color: #d3d3d3; -fx-alignment: center;");

        //Create label
        Label stopLabel = new Label("Stop #" + stopIndex + " coordinated color");

        //Create menu and menu options
        MenuButton colorMenu = new MenuButton("Select Color");
        MenuItem productColor = new MenuItem("Product Color");
        MenuItem color1 = new MenuItem("Color 1");
        MenuItem color2 = new MenuItem("Color 2");
        MenuItem color3 = new MenuItem("Color 3");
        MenuItem color4 = new MenuItem("Color 4");
        MenuItem tonalColor = new MenuItem("Tonal Color");

        //Handle event for menu options
        productColor.setOnAction(e -> colorMenu.setText("Product Color"));
        color1.setOnAction(e -> colorMenu.setText("Color 1"));
        color2.setOnAction(e -> colorMenu.setText("Color 2"));
        color3.setOnAction(e -> colorMenu.setText("Color 3"));
        color4.setOnAction(e -> colorMenu.setText("Color 4"));
        tonalColor.setOnAction(e -> colorMenu.setText("Tonal Color"));

        //Add all menu options to the dropdown
        colorMenu.getItems().addAll(productColor, color1, color2, color3, color4, tonalColor);

        //Add the menu button selection to an Array list so we can reference the selection later
        menuButtons.add(colorMenu);


        //Add all elements to the HBox
        stopHBox.getChildren().addAll(stopLabel, colorMenu);

        return stopHBox;

    }
    @FXML
    public void addLogo(ActionEvent event){
        try {
            //If the user hasnt added a logo id and number of stops we give an alert and print to console
            if (logo == null) {
                System.out.println("Please generate stops first.");

                Alert error = new Alert(Alert.AlertType.INFORMATION);
                error.setTitle("Logo Not Added");
                error.setHeaderText("Please generate stops first.");
                error.showAndWait();
                return;
            }


            // Iterate over the MenuButtons and set the corresponding array values
            for (int i = 0; i < menuButtons.size(); i++) {
                MenuButton menuButton = menuButtons.get(i);
                String selectedColor = menuButton.getText();
                int colorCode = mapColorToCode(selectedColor);
                logo.setThreadCode(i, colorCode); // Update the Logo object's array
            }

            LogoManager.addLogo(logo);
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Logo Added");
            success.setHeaderText("Logo Successfully Added");
            success.setContentText("Logo added successfully: " + logo);
            success.showAndWait();

            ArrayList <Logo> temp = LogoManager.getLogos();
            LogoManager.printLogoList(temp);

            for (int i = 0; i<logo.getNumberOfStops(); i++){
                System.out.println("Stop #" + (i+1) + " coordinated color " + logo.getThreadCode(i));
            }
        } catch (Exception e) {
            System.out.println("Error adding logo: " + e.getMessage());
        }

    }

    private int mapColorToCode(String color) {
        return switch (color) {
            case "Product Color" -> 0;
            case "Color 1" -> 1;
            case "Color 2" -> 2;
            case "Color 3" -> 3;
            case "Color 4" -> 4;
            case "Tonal Color" -> 5;
            default -> throw new IllegalArgumentException("Invalid color selection: " + color);
        };
    }
}
