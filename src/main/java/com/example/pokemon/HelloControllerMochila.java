package com.example.pokemon;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloControllerMochila {

    private HelloController2 HelloController2;
    Pokemon pokemonSeleccionado;

    void enviarDatos2(HelloController2 HelloController2){
        this.HelloController2=HelloController2;
    }

    @FXML
    ImageView imagenMochila;

    public void mochilaPokemon(Pokemon pokemonSeleccionado) {

        this.pokemonSeleccionado = pokemonSeleccionado;

        Image imagen1 = new Image(pokemonSeleccionado.imagen.toURI().toString());
        imagenMochila.setImage(imagen1);
    }
}
