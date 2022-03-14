package com.example.pokemon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MostrarCapturados {

    public HelloController helloController;
    public HelloController2 helloController2;

    @FXML
    Label textoCapturas;
    @FXML
    Button btSiguiente;

    @FXML
    public  void initializeCapturas(){
        if(helloController2.oponente.captura){
            textoCapturas.setText(helloController.pokemonSeleccionado.pokemon+ " lucho con " + helloController.helloController2.oponente.pokemon2+ ". Fue necesario lanzar "+ helloController.helloController2.oponente +" pokeballs y le hizo "+ helloController.helloController2.oponente.captura+ " puntos de dalo antes de ser capturado.");
        }
    }

    void enviarDatos6(HelloController helloController){
        this.helloController = helloController;
        helloController.enviarDatos7(this);
    }
}
