/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicacalificada.pkg02;

/**
 *
 * @author SAUL
 */
public class Carro {
    public enum ModalidadSeguro {
        TODO_RIESGO,
        TERCEROS
    }

    public enum TipoCarro {
        MINI,
        UTILITARIO,
        FAMILIAR,
        DEPORTIVO
    }

    public enum TipoPintura {
        METALIZADA,
        NO_METALIZADA
    }

    private String modelo;
    private String color;
    private String placa;
    private ModalidadSeguro modalidadSeguro;
    private int añoFabricacion;
    private TipoCarro tipoCarro;
    private TipoPintura tipoPintura;

    public Carro(String modelo, String color, String placa, ModalidadSeguro modalidadSeguro, int añoFabricacion,
                 TipoCarro tipoCarro, TipoPintura tipoPintura) {
        this.modelo = modelo;
        this.color = color;
        this.placa = placa;
        this.modalidadSeguro = modalidadSeguro;
        this.añoFabricacion = añoFabricacion;
        this.tipoCarro = tipoCarro;
        this.tipoPintura = tipoPintura;
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE)

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", placa='" + placa + '\'' +
                ", modalidadSeguro=" + modalidadSeguro +
                ", añoFabricacion=" + añoFabricacion +
                ", tipoCarro=" + tipoCarro +
                ", tipoPintura=" + tipoPintura +
            '}';
}
}