import javazoom.jl.player.StdPlayer;
import java.util.*;
public class EchoFilter{
    public static void main(String[] args){
        StdPlayer.open("test2.mp3"); // sample to test
        int count = 0;
        List<Wave> pastWave = new ArrayList<>();
        while(!StdPlayer.isEmpty()){
            double[] left  = StdPlayer.getLeftChannel();
            double[] right = StdPlayer.getRightChannel(); 
            Wave w = new Wave(left, right);
            pastWave.add(w);
            count++;
            Wave n;
            if(count<10){
                n = w;
            }
            else{
                n = w.plus(pastWave.get(count-10));
            }
            n.play();
        }            
        //play the remaining wave in pastWave:
        for(int i = count-9; i < pastWave.size(); i++){
            pastWave.get(i).play();
        }
        StdPlayer.close();
    }
}