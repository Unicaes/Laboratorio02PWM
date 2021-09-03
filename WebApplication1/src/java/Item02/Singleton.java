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
public class Singleton {
    public static clsCuenta oCuenta;
    public static void CrearCuenta(String nombre,String NumeroCuenta,double interes,double saldo){
        oCuenta = new clsCuenta(nombre, NumeroCuenta, saldo, interes);
    }
    public static clsCuenta GetCuenta(){
        return oCuenta;
    }
    public static void ModificarCuenta(clsCuenta cuenta){
        oCuenta=cuenta;
    }
}
