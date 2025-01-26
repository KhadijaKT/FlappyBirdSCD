import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener,KeyListener {
    int boardWidth=360;
    int boardHeight=640;

    Image backgroundImage;
    Image birdImage;
    Image topPipeImg;
    Image botPipeImg;

    int birdX=boardWidth/8;
    int birdY=boardWidth/2;
    int birdWidth=34;
    int birdHeight=24;

    class Bird{
        int x=birdX;
        int y=birdY;
        int width=birdWidth;
        int height=birdHeight;
        Image img;

        Bird(Image img){
            this.img=img;
        }
    }

    int pipeX=boardWidth;
    int pipeY=0;
    int pipeWidth=64;
    int pipeHeight=512;

    class Pipe{
        int x=pipeX;
        int y=pipeY;
        int width=pipeWidth;
        int height=pipeHeight;
        Image img;
        boolean passed=false;

        Pipe(Image img){
            this.img=img;
        }
    }

    Bird bird;
    int velocityX=-4;
    int velocityY=0;
    int gravity=1;

    ArrayList<Pipe> pipes;
    Random random= new Random();

    Timer gameloop;
    Timer placePipeTimer;
    boolean gameOver=false;
    double score=0;

    FlappyBird(){
        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);

        backgroundImage=new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImage=new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg=new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        botPipeImg=new ImageIcon(getClass().getResource("bottompipe.png")).getImage();

        bird=new Bird(birdImage);
        pipes=new ArrayList<Pipe>();

        placePipeTimer=new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        placePipeTimer.start();
        gameloop=new Timer(1000/600,this);
        gameloop.start();
    }

    void placePipes(){
        int randomPipeY=(int)(pipeY-pipeHeight/4-Math.random()*(pipeHeight/2));
        int openingSpace=boardHeight/4;

        Pipe topPipe=new Pipe(topPipeImg);
        topPipe.y=randomPipeY;
        pipes.add(topPipe);

        Pipe botPipe=new Pipe(botPipeImg);
        botPipe.y=topPipe.y+pipeHeight+openingSpace;
        pipes.add(botPipe);
    }

    public void paintComponents(Graphics g){
        super.paintComponents(g);
        draw(g);
    }

    public void draw(Graphics g){

    }

    public void move(){

    }

    boolean collision(Bird a, Pipe b){
        return a.x<b.x+b.width&&
                a.x+a.width>b.x&&
                a.y<b.y+b.height&&
                a.y+a.height>b.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
