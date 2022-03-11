package com.example.pokemon;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloController {

    Pokemon pokemonSeleccionado;
    int cont = 0;

    Pokemon p1 = new Pokemon("Greninja", 348f, 174f, "LV.65", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\greninja.gif"), new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\greninja2.gif"),"Agua / Siniestro");
    Pokemon p2 = new Pokemon("Oranguru", 348f, 174f, "LV.45", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\oranguru.gif"), new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\oranguru2.gif"),"Normal / Psíquico");
    Pokemon p3 = new Pokemon("Moltres", 348f, 174f, "LV.75", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\moltres.gif"), new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\moltres2.gif"),"Fuego / Volador");
    Pokemon p4 = new Pokemon("Salazzle", 340f, 170f, "LV.65", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\salazzle.gif"), new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\salazzle2.gif"),"Veneno / Fuego");
    Pokemon p5 = new Pokemon("Metagross", 364f, 174f, "LV.65", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\metagross.gif"), new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\metagross2.gif"),"Acero / Psíquico");
    Pokemon p6 = new Pokemon("Urshifu", 384f, 192f, "LV.75", new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\ursifu.gif"), new File("src\\main\\java\\com\\example\\pokemon\\Imagenes\\ursifu2.gif"),"Lucha / Agua");


    //Greninja
    @FXML
    Label pokemon1;
    @FXML
    Label nivel1;
    @FXML
    ProgressBar barra1;
    @FXML
    ImageView imagen1;
    @FXML
    AnchorPane panel1;
    @FXML
    Label tipo1;

    //Oranguru
    @FXML
    Label pokemon2;
    @FXML
    Label nivel2;
    @FXML
    ProgressBar barra2;
    @FXML
    ImageView imagen2;
    @FXML
    AnchorPane panel2;
    @FXML
    Label tipo2;

    //Moltres
    @FXML
    Label pokemon3;
    @FXML
    Label nivel3;
    @FXML
    ProgressBar barra3;
    @FXML
    ImageView imagen3;
    @FXML
    AnchorPane panel3;
    @FXML
    Label tipo3;

    //Salazzle
    @FXML
    Label pokemon4;
    @FXML
    Label nivel4;
    @FXML
    ProgressBar barra4;
    @FXML
    ImageView imagen4;
    @FXML
    AnchorPane panel4;
    @FXML
    Label tipo4;

    //Metagross
    @FXML
    Label pokemon5;
    @FXML
    Label nivel5;
    @FXML
    ProgressBar barra5;
    @FXML
    ImageView imagen5;
    @FXML
    AnchorPane panel5;
    @FXML
    Label tipo5;

    //Urshifu
    @FXML
    Label pokemon6;
    @FXML
    Label nivel6;
    @FXML
    ProgressBar barra6;
    @FXML
    ImageView imagen6;
    @FXML
    AnchorPane panel6;
    @FXML
    Label tipo6;

    //Botones cambiar a siguiente
    @FXML
    Button boton1;
    @FXML
    Button boton2;


    @FXML
    public void initialize() {

        //Greninja
        Image foto1 = new Image(p1.imagen.toURI().toString());
        imagen1.setImage(foto1);
        pokemon1.setText(p1.pokemon);
        nivel1.setText("" + p1.nivel);
        barra1.setProgress(calcularVida(p1));
        tipo1.setText(p1.tipo);

        //Oranguru
        Image foto2 = new Image(p2.imagen.toURI().toString());
        imagen2.setImage(foto2);
        pokemon2.setText(p2.pokemon);
        nivel2.setText("" + p2.nivel);
        barra2.setProgress(calcularVida(p2));
        tipo2.setText(p2.tipo);

        //Moltres
        Image foto3 = new Image(p3.imagen.toURI().toString());
        imagen3.setImage(foto3);
        pokemon3.setText(p3.pokemon);
        nivel3.setText("" + p3.nivel);
        barra3.setProgress(calcularVida(p3));
        tipo3.setText(p3.tipo);

        //Salazzle
        Image foto4 = new Image(p4.imagen.toURI().toString());
        imagen4.setImage(foto4);
        pokemon4.setText(p4.pokemon);
        nivel4.setText("" + p4.nivel);
        barra4.setProgress(calcularVida(p6));
        tipo4.setText(p4.tipo);

        //Metagross
        Image foto5 = new Image(p5.imagen.toURI().toString());
        imagen5.setImage(foto5);
        pokemon5.setText(p5.pokemon);
        nivel5.setText("" + p5.nivel);
        barra5.setProgress(calcularVida(p5));
        tipo5.setText(p5.tipo);

        //Urshifu
        Image foto6 = new Image(p6.imagen.toURI().toString());
        imagen6.setImage(foto6);
        pokemon6.setText(p6.pokemon);
        nivel6.setText("" + p6.nivel);
        barra6.setProgress(calcularVida(p6));
        tipo6.setText(p6.tipo);
    }

    @FXML
    private void pulsar1() {
        System.out.println("Has elegido a Greninja");

        //Greninja
        panel1.setStyle("-fx-background-color:#675073");
        imagen1.setStyle("-fx-opacity:1");

        //Oranguru
        panel2.setStyle("-fx-background-color: #7D6A87;");
        imagen2.setStyle("-fx-opacity:0.5");

        //Moltres
        panel3.setStyle("-fx-background-color: #7D6A87;");
        imagen3.setStyle("-fx-opacity:0.5");

        //Salazzle
        panel4.setStyle("-fx-background-color: #7D6A87;");
        imagen4.setStyle("-fx-opacity:0.5");

        //Metagross
        panel5.setStyle("-fx-background-color: #7D6A87;");
        imagen5.setStyle("-fx-opacity:0.5");

        //Urshifu
        panel6.setStyle("-fx-background-color: #7D6A87;");
        imagen6.setStyle("-fx-opacity:0.5");

        cont = 1;

        pokemonSeleccionado = p1;

        boton1.setText("Siguiente");
    }

    @FXML
    private void pulsar2() {
        System.out.println("Has elegido a Oranguru");

        //Greninja
        panel1.setStyle("-fx-background-color:#7D6A87");
        imagen1.setStyle("-fx-opacity:0.5");

        //Oranguru
        panel2.setStyle("-fx-background-color: #675073;");
        imagen2.setStyle("-fx-opacity:1");

        //Moltres
        panel3.setStyle("-fx-background-color: #7D6A87;");
        imagen3.setStyle("-fx-opacity:0.5");

        //Salazzle
        panel4.setStyle("-fx-background-color: #7D6A87;");
        imagen4.setStyle("-fx-opacity:0.5");

        //Metagross
        panel5.setStyle("-fx-background-color: #7D6A87;");
        imagen5.setStyle("-fx-opacity:0.5");

        //Urshifu
        panel6.setStyle("-fx-background-color: #7D6A87;");
        imagen6.setStyle("-fx-opacity:0.5");

        cont = 1;

        pokemonSeleccionado = p2;

        boton1.setText("Siguiente");
    }

    @FXML
    private void pulsar3() {
        System.out.println("Has elegido a Moltres");

        //Greninja
        panel1.setStyle("-fx-background-color:#7D6A87");
        imagen1.setStyle("-fx-opacity:0.5");

        //Oranguru
        panel2.setStyle("-fx-background-color: #7D6A87;");
        imagen2.setStyle("-fx-opacity:0.5");

        //Moltres
        panel3.setStyle("-fx-background-color: #675073;");
        imagen3.setStyle("-fx-opacity:1");

        //Salazzle
        panel4.setStyle("-fx-background-color: #7D6A87;");
        imagen4.setStyle("-fx-opacity:0.5");

        //Metagross
        panel5.setStyle("-fx-background-color: #7D6A87;");
        imagen5.setStyle("-fx-opacity:0.5");

        //Urshifu
        panel6.setStyle("-fx-background-color: #7D6A87;");
        imagen6.setStyle("-fx-opacity:0.5");

        cont = 1;

        pokemonSeleccionado = p3;

        boton1.setText("Siguiente");
    }

    @FXML
    private void pulsar4() {
        System.out.println("Has elegido a Salazzle");

        //Greninja
        panel1.setStyle("-fx-background-color:#7D6A87");
        imagen1.setStyle("-fx-opacity:0.5");

        //Oranguru
        panel2.setStyle("-fx-background-color: #7D6A87;");
        imagen2.setStyle("-fx-opacity:0.5");

        //Moltres
        panel3.setStyle("-fx-background-color: #7D6A87;");
        imagen3.setStyle("-fx-opacity:0.5");

        //Salazzle
        panel4.setStyle("-fx-background-color: #675073;");
        imagen4.setStyle("-fx-opacity:1");

        //Metagross
        panel5.setStyle("-fx-background-color: #7D6A87;");
        imagen5.setStyle("-fx-opacity:0.5");

        //Urshifu
        panel6.setStyle("-fx-background-color: #7D6A87;");
        imagen6.setStyle("-fx-opacity:0.5");

        cont = 1;

        pokemonSeleccionado = p4;

        boton1.setText("Siguiente");
    }

    @FXML
    private void pulsar5() {
        System.out.println("Has elegido a Metagross");

        //Greninja
        panel1.setStyle("-fx-background-color:#7D6A87");
        imagen1.setStyle("-fx-opacity:0.5");

        //Oranguru
        panel2.setStyle("-fx-background-color: #7D6A87;");
        imagen2.setStyle("-fx-opacity:0.5");

        //Moltres
        panel3.setStyle("-fx-background-color: #7D6A87;");
        imagen3.setStyle("-fx-opacity:0.5");

        //Salazzle
        panel4.setStyle("-fx-background-color: #7D6A87;");
        imagen4.setStyle("-fx-opacity:0.5");

        //Metagross
        panel5.setStyle("-fx-background-color: #675073;");
        imagen5.setStyle("-fx-opacity:1");

        //Urshifu
        panel6.setStyle("-fx-background-color: #7D6A87;");
        imagen6.setStyle("-fx-opacity:0.5");

        cont = 1;

        pokemonSeleccionado = p5;

        boton1.setText("Siguiente");
    }

    @FXML
    private void pulsar6() {
        System.out.println("Has elegido a Urshifu");

        //Greninja
        panel1.setStyle("-fx-background-color:#7D6A87");
        imagen1.setStyle("-fx-opacity:0.5");

        //Oranguru
        panel2.setStyle("-fx-background-color: #7D6A87;");
        imagen2.setStyle("-fx-opacity:0.5");

        //Moltres
        panel3.setStyle("-fx-background-color: #7D6A87;");
        imagen3.setStyle("-fx-opacity:0.5");

        //Salazzle
        panel4.setStyle("-fx-background-color: #7D6A87;");
        imagen4.setStyle("-fx-opacity:0.5");

        //Metagross
        panel5.setStyle("-fx-background-color: #7D6A87;");
        imagen5.setStyle("-fx-opacity:0.5");

        //Urshifu
        panel6.setStyle("-fx-background-color: #675073;");
        imagen6.setStyle("-fx-opacity:1");

        cont = 1;

        pokemonSeleccionado = p6;

        boton1.setText("Siguiente");
    }

    Stage stage2;
    HelloController2 e = null;

    @FXML
    protected void cambiarPantalla() {

        System.out.println("Boton pulsado pasamos al siguiente escenario");

        try {

            if (stage2 == null || !stage2.isShowing()) {

                stage2 = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("campoBatalla.fxml"));

                AnchorPane root = loader.load();
                Scene scene = new Scene(root, 960, 727);

                stage2.setScene(scene);
                stage2.show();
                e = loader.getController();
                e.Pokemones(pokemonSeleccionado);
                e.enviarDatos(this);
            }

            e.Pokemones(pokemonSeleccionado);
            e.enviarDatos(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Float calcularVida(Pokemon pokemon) {
        return Float.parseFloat(String.valueOf(pokemon.vida / pokemon.barra));
    }

    public void actualizarInterfaz(){
        barra1.setProgress(p1.vida / p1.barra);
        barra2.setProgress(p2.vida / p2.barra);
        barra3.setProgress(p3.vida / p3.barra);
        barra4.setProgress(p4.vida / p4.barra);
        barra5.setProgress(p5.vida / p5.barra);
        barra6.setProgress(p6.vida / p6.barra);
    }
}


class Pokemon {

        String pokemon;
        Float barra;
        double vida;
        String nivel;
        File imagen;
        File imagen2;
        String tipo;

        public Pokemon(String pokemon, Float barra, Float vida, String nivel, File imagen,File imagen2, String tipo) {
            this.pokemon = pokemon;
            this.barra = barra;
            this.vida = vida;
            this.nivel = nivel;
            this.imagen = imagen;
            this.imagen2 = imagen2;
            this.tipo = tipo;
        }
    }



