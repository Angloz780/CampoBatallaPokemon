package com.example.pokemon;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class HelloControllerMochila {

    private HelloController2 HelloController2;
    Pokemon pokemonSeleccionado;

    void enviarDatos2(HelloController2 HelloController2){
        this.HelloController2=HelloController2;
    }

    Pociones poty1 = new Pociones(new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\pocion1.png"));
    Pociones poty2 = new Pociones(new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\pocion2.png"));
    Pociones poty3 = new Pociones(new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\pocion3.png"));

    @FXML
    ImageView imagenMochila;
    @FXML
    ImageView pocion1;
    @FXML
    ImageView pocion2;
    @FXML
    ImageView pocion3;

    @FXML
    public void initialize() {

        Image foto1 = new Image(poty1.pocion.toURI().toString());
        pocion1.setImage(foto1);

        Image foto2 = new Image(poty2.pocion.toURI().toString());
        pocion2.setImage(foto2);

        Image foto3 = new Image(poty3.pocion.toURI().toString());
        pocion3.setImage(foto3);
    }

    public void mochilaPokemon(Pokemon pokemonSeleccionado) {

        this.pokemonSeleccionado = pokemonSeleccionado;

        Image imagen1 = new Image(pokemonSeleccionado.imagen.toURI().toString());
        imagenMochila.setImage(imagen1);
    }

    class Pociones{

        File pocion;

        public Pociones(File pocion){
            this.pocion = pocion;
        }
    }
}
