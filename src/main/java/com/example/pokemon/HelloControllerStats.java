package com.example.pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class HelloControllerStats {

     public HelloController HelloController;

    @FXML
    PieChart statsCuracion;

    @FXML
    public void initializeStats() {

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data(HelloController.ListaPokemon.get(0).pokemon, HelloController.helloControllerMochila.cont1 + HelloController.helloControllerMochila.cont2 +HelloController.helloControllerMochila.cont3 + HelloController.helloControllerMochila.cont4),
                        new PieChart.Data(HelloController.ListaPokemon.get(1).pokemon, HelloController.helloControllerMochila.cont1 + HelloController.helloControllerMochila.cont2 +HelloController.helloControllerMochila.cont3 + HelloController.helloControllerMochila.cont4),
                        new PieChart.Data(HelloController.ListaPokemon.get(2).pokemon, HelloController.helloControllerMochila.cont1 + HelloController.helloControllerMochila.cont2 +HelloController.helloControllerMochila.cont3 + HelloController.helloControllerMochila.cont4),
                        new PieChart.Data(HelloController.ListaPokemon.get(3).pokemon, HelloController.helloControllerMochila.cont1 + HelloController.helloControllerMochila.cont2 +HelloController.helloControllerMochila.cont3 + HelloController.helloControllerMochila.cont4),
                        new PieChart.Data(HelloController.ListaPokemon.get(4).pokemon, HelloController.helloControllerMochila.cont1 + HelloController.helloControllerMochila.cont2 +HelloController.helloControllerMochila.cont3 + HelloController.helloControllerMochila.cont4),
                        new PieChart.Data(HelloController.ListaPokemon.get(5).pokemon, HelloController.helloControllerMochila.cont1 + HelloController.helloControllerMochila.cont2 +HelloController.helloControllerMochila.cont3 + HelloController.helloControllerMochila.cont4));
        statsCuracion.setData(pieChartData);
    }

    void enviarDatos3(HelloController helloController){
        this.HelloController = helloController;
        helloController.enviarDatos5(this);
    }
}
