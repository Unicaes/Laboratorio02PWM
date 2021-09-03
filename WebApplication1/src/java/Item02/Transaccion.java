/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item02;

/**
 *
 * @author bryan
 */
public class Transaccion {
    public String NumeroCuenta;
    public double SaldoAntiguo;
    public String action;
    public Double monto;
    public Double NuevoSaldo;

    public Transaccion(String NumeroCuenta, double SaldoAntiguo, String action, Double monto, Double NuevoSaldo) {
        this.NumeroCuenta = NumeroCuenta;
        this.SaldoAntiguo = SaldoAntiguo;
        this.action = action;
        this.monto = monto;
        this.NuevoSaldo = NuevoSaldo;
    }
    
    
}
