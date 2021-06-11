import javazoom.jl.player.StdPlayer;
import javax.swing.*;
public class Wave extends JFrame{
    private double[] left;
    private double[] right;
    double pi = Math.PI;
    public Wave(double Hz, double seconds, double amplitude){             
        double size = 44100.0* seconds;
        left = new double[(int)size];
        right = new double[(int)size];
        for(int i = 0; i < size; i++){
            double instantAmplitude = amplitude*Math.sin(2*pi*Hz*i/44100);
            left[i] = instantAmplitude;
            right[i] = instantAmplitude;
        }
    }
    
    public Wave(double[] left, double[] right){
        this.left = left;
        this.right = right;
    }
    
    public Wave plus(Wave other){
        int size = this.left.length;
        double[] newLeft = new double[size];
        double[] newRight = new double[size];
        for(int i = 0; i< size; i++){
            newLeft[i] = this.left[i] + other.left[i];
            newRight[i] = this.right[i] + other.right[i];
        }
        return new Wave(newLeft, newRight);
    }
    
    public void play(){
        StdPlayer.playWave(left, right);
        /* to slow x2, add:
        StdPlayer.playWave(left,right);*/
    }
    
    public void draw(){
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(30,440,"right:");
        for (int i = 0; i < left.length; i++) {
            StdDraw.setPenColor(StdDraw.RED);
            //StdDraw.circle(i, Math.abs(left[i]) , Math.abs(left[i]));
            StdDraw.point(i, right[i]*10+ 400);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(i, left[i]*10+100);
        }
        StdDraw.text(30,140,"left:");        
        StdDraw.show(); //doc: When drawing computer animations, call show() only once per frame, not after drawing each individual object.
    }
    
}