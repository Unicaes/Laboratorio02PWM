/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item02;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author bryan
 */
public class clsCuenta {
    private String nombre;
    private String numeroCuenta;
    private double saldo;
    private double interes;
    public double UltimoInteresCalculado=-5;
    public ArrayList<Transaccion> transacciones;

    public clsCuenta(String nombre, String numeroCuenta, double saldo, double interes) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.interes=interes;
        transacciones = new ArrayList<>();
        Transaccion oTransaccion = new Transaccion(numeroCuenta,saldo,"Apertura de cuenta",0.00,saldo);
        this.transacciones.add(oTransaccion);
    }
    public void AsignarNombre(String nombre){
        this.nombre=nombre;
    }
    public String ObtenerNombre(){
        return this.nombre;
    }
    public void AsignarCuenta(String cuenta){
        this.numeroCuenta=cuenta;
    }
    public String ObtenerCuenta(){
        return this.numeroCuenta;
    }
    public double EstadoCuenta(){
        return this.saldo;
    }
    public void Deposito(double monto){
        this.saldo+=monto;
    }
    public int Retiro(double monto){
        if (monto>this.saldo) {
            return 0;
        }
        this.saldo-=monto;
        return 1;
    }
    public void AsignarInteres(double interes){
        this.interes=interes;
    }
    public Double ObtenerInteres(){
        return this.interes;
    }
    public double ObtenerInteresGanado(int tiempo){
        double interesGanado = this.saldo*this.interes*tiempo;
        this.UltimoInteresCalculado = interesGanado;
        return interesGanado;
    }
}
