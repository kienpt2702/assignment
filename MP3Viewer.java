import javazoom.jl.player.StdPlayer;
public class MP3Viewer{
        public static void main(String[] args){
        StdDraw.setCanvasSize(500,500);
        StdPlayer.open("test3.mp3");
        StdDraw.setXscale(0,500); // change the default coordinate:
        StdDraw.setYscale(0, 500);//(0,0 at bottom left) and (500,500 at upper right) 
        while(!StdPlayer.isEmpty()){
            double[] l = StdPlayer.getLeftChannel();
            double[] r = StdPlayer.getRightChannel();
            Wave w = new Wave(l,r);
            StdDraw.enableDoubleBuffering(); // to create animation(from documentation)
            w.play();
            w.draw();     
        }
    }
}