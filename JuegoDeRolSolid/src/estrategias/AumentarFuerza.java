/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estrategias;

import interfaces.IEstadoAlterado;
import modelo.Personaje;

public class AumentarFuerza implements IEstadoAlterado {
    private int turnosRestantes = 2;
    private boolean aplicado = false;

    @Override
    public String getNombre() { return "Fuerza Aumentada 💪"; }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        if (estaActivo()) {
            if (!aplicado) {
                personaje.setAtaque(personaje.getAtaque() + 15);
                aplicado = true;
                System.out.println("   [Estado] ¡Ataque de " + personaje.getClass().getSimpleName() + " aumentado en 15!");
            }
            disminuirTurno();
            
            if (!estaActivo()) {
                personaje.setAtaque(personaje.getAtaque() - 15);
                System.out.println("   [Estado] El efecto de Fuerza Aumentada ha expirado.");
            }
        }
    }

    @Override
    public void disminuirTurno() { turnosRestantes--; }

    @Override
    public boolean estaActivo() { return turnosRestantes > 0; }
}