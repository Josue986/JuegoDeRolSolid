/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estrategias;

import interfaces.IEstadoAlterado;
import modelo.Personaje;

public class Congelado implements IEstadoAlterado {
    private int turnosRestantes = 1;

    @Override
    public String getNombre() { return "Congelado ❄️"; }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        if (estaActivo()) {
            System.out.println("   [Estado] " + personaje.getClass().getSimpleName() + " está congelado y perderá su turno.");
            disminuirTurno();
        }
    }

    @Override
    public void disminuirTurno() { turnosRestantes--; }

    @Override
    public boolean estaActivo() { return turnosRestantes > 0; }
}
