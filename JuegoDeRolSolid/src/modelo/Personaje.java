/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Sophi González
 */

public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int nivel;
    protected int experiencia;
    protected int energia;

    public Personaje(String nombre, int vida, int ataque, int defensa, int energia) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.energia = energia;
        this.nivel = 1;
        this.experiencia = 0;
    }

    public void recibirDaño(int daño) {
        int real = Math.max(0, daño - defensa);
        vida -= real;

        System.out.println(nombre + " recibe " + real + " de daño. Vida: " + vida);
    }

    public void subirNivel() {
        if (experiencia >= 100) {
            nivel++;
            experiencia = 0;
            vida += 20;
            ataque += 5;
            defensa += 5;

            System.out.println(nombre + " subió a nivel " + nivel);
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void atacar(Personaje enemigo);

    public abstract void usarHabilidadEspecial(Personaje enemigo);

}
