package com.example.pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloController3 {

    private HelloController3 helloController3;

    @FXML
    PieChart danoTotal;
    @FXML
    BarChart graficoSelec;
    @FXML
    Button cancelarStats;

    @FXML
    private void btCancelarStats() {
        System.out.println("Cerrar pestaña");
        HelloController3.stage3.close();
    }


    public void infoPie(int dado, int recibido){
        ObservableList <PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Dado", dado),
                        new PieChart.Data("Recibido", recibido)
                );
        danoTotal.setLabelLineLength(10);
        danoTotal.setData(pieChartData);
    }

    static Stage stage3;


    public void datosBarras(int cont_p1, int cont_p2, int cont_p3, int cont_p4, int cont_p5, int cont_p6){

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Pokemon");
        yAxis.setLabel("Veces");

        graficoSelec.setTitle("Veces Seleccionado");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Greninja");
        series1.getData().add(new XYChart.Data("Greninja",cont_p1));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Oranguru");
        series2.getData().add(new XYChart.Data("Oranguru",cont_p2));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Moltres");
        series3.getData().add(new XYChart.Data("Moltres",cont_p3));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Salazzle");
        series4.getData().add(new XYChart.Data("Salazzle",cont_p4));

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("Metagross");
        series5.getData().add(new XYChart.Data("Metagross",cont_p5));

        XYChart.Series series6 = new XYChart.Series();
        series6.setName("Urshifu");
        series6.getData().add(new XYChart.Data("Urshifu",cont_p6));

        graficoSelec.setAnimated(false);
        graficoSelec.setCategoryGap(50);
        graficoSelec.getData().addAll(series1, series2, series3, series4, series5, series6);
    }
}