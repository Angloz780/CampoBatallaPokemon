package com.example.pokemon;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;

public class HelloControllerMochila {

    Pokemon pokemonSeleccionado;
    private HelloController2 HelloController2;

    Pociones poty1 = new Pociones(new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\pocion1.png"), "Esta pocion cura 10 puntos de vida");
    Pociones poty2 = new Pociones(new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\pocion2.png"), "Esta pocion cura 20 puntos de vida");
    Pociones poty3 = new Pociones(new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\pocion3.png"), "Esta pocion cura un 10% puntos de vida");
    Pociones poty4 = new Pociones(new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\pocion4.png"), "Esta pocion cura un 20% puntos de vida");

    @FXML
    ImageView imagenMochila;

    @FXML
    ProgressBar mochilaBarra;

    @FXML
    ImageView pocion1;
    @FXML
    Text info1;

    @FXML
    ImageView pocion2;
    @FXML
    Text info2;

    @FXML
    ImageView pocion3;
    @FXML
    Text info3;

    @FXML
    ImageView pocion4;
    @FXML
    Text info4;

    @FXML
    public void initialize(Pokemon pokemonSeleccionado) {

        this.pokemonSeleccionado = pokemonSeleccionado;

        Image imagenPokemon = new Image(pokemonSeleccionado.imagen.toURI().toString());
        imagenMochila.setImage(imagenPokemon);

        Image foto1 = new Image(poty1.pocion.toURI().toString());
        pocion1.setImage(foto1);
        info1.setText(poty1.info);

        Image foto2 = new Image(poty2.pocion.toURI().toString());
        pocion2.setImage(foto2);
        info2.setText(poty1.info);

        Image foto3 = new Image(poty3.pocion.toURI().toString());
        pocion3.setImage(foto3);
        info3.setText(poty3.info);

        Image foto4 = new Image(poty4.pocion.toURI().toString());
        pocion4.setImage(foto4);
        info4.setText(poty4.info);

        mochilaBarra.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
    }

    @FXML
    private void pulsarPocion1() {
        System.out.println("Has elegido la pocion 1");

        pocion1.setStyle("-fx-opacity:1");
        pocion2.setStyle("-fx-opacity:0.25");
        pocion3.setStyle("-fx-opacity:0.25");
        pocion4.setStyle("-fx-opacity:0.25");

        Integer cont = 0;

        System.out.println( pokemonSeleccionado.vida);

        pokemonSeleccionado.vida += 10;

        System.out.println(cont);
        HelloController2.actualizarInterfaz2();

        mochilaBarra.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
    }

    @FXML
    private void pulsarPocion2() {
        System.out.println("Has elegido la pocion 2");

        pocion1.setStyle("-fx-opacity:0.25");
        pocion2.setStyle("-fx-opacity:1");
        pocion3.setStyle("-fx-opacity:0.25");
        pocion4.setStyle("-fx-opacity:0.25");

        Integer cont = 0;

        System.out.println( pokemonSeleccionado.vida);

        pokemonSeleccionado.vida += 20;

        System.out.println(cont);
        HelloController2.actualizarInterfaz2();

        mochilaBarra.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
    }

    @FXML
    private void pulsarPocion3() {
        System.out.println("Has elegido la pocion 3");

        pocion1.setStyle("-fx-opacity:0.25");
        pocion2.setStyle("-fx-opacity:0.25");
        pocion3.setStyle("-fx-opacity:1");
        pocion4.setStyle("-fx-opacity:0.25");

        System.out.println( pokemonSeleccionado.vida);

        pokemonSeleccionado.vida += (pokemonSeleccionado.vida * 10 / 100);

        HelloController2.actualizarInterfaz2();

        mochilaBarra.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
    }

    @FXML
    private void pulsarPocion4() {
        System.out.println("Has elegido la pocion 4");

        pocion1.setStyle("-fx-opacity:0.25");
        pocion2.setStyle("-fx-opacity:0.25");
        pocion3.setStyle("-fx-opacity:0.25");
        pocion4.setStyle("-fx-opacity:1");

        System.out.println(pokemonSeleccionado.vida);

        pokemonSeleccionado.vida += (pokemonSeleccionado.vida * 20 / 100);

        HelloController2.actualizarInterfaz2();

        mochilaBarra.setProgress(pokemonSeleccionado.vida / pokemonSeleccionado.barra);
    }

    void enviarDatos2(HelloController2 HelloController2){
        this.HelloController2 = HelloController2;
    }

    class Pociones{

        File pocion;
        String info;

        public Pociones(File pocion, String info) {
            this.pocion = pocion;
            this.info = info;
        }
    }
}
