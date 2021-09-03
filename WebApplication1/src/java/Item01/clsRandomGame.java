/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item01;

/**
 *
 * @author bryan
 */
public class clsRandomGame {
    public static int RandomNumber=-1;
    public static int intentos=1;
    public static int result=-5;
    public static int LastRandomNumber=-1;
    public static boolean Flag=true;
    public int GenerateRandomNumber(){
        if (clsRandomGame.RandomNumber==-1) {
            if (clsRandomGame.Flag) {
                clsRandomGame.RandomNumber = (int)(Math.random()*1000 + 1);
                clsRandomGame.LastRandomNumber = clsRandomGame.RandomNumber;
                clsRandomGame.Flag=false;
            }else{
                clsRandomGame.RandomNumber = (int)(Math.random()*1000 + 1);
            }
            return RandomNumber;    
        }else{
            return clsRandomGame.RandomNumber;
        }
    }
    public int CheckRandomNumber(int UserNumber){
        if (clsRandomGame.intentos>9) {
            clsRandomGame.intentos=1;
            return -2;
        }
        clsRandomGame.intentos=clsRandomGame.intentos+1;
        if (UserNumber==clsRandomGame.RandomNumber) {
//            clsRandomGame.RandomNumber=-1;
            return 1;
        }else if (UserNumber>clsRandomGame.RandomNumber) {
            return 0;
        }else{
            return -1;
        }
    }
    public void ResetRandomNumber(){
        clsRandomGame.LastRandomNumber = clsRandomGame.RandomNumber;
        clsRandomGame.RandomNumber=-1;
    }
}
