package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable{
    private WormGame game;
    private int pieceLength;

    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(Piece p : this.game.getWorm().getPieces()){
            g.setColor(Color.BLACK);
            g.fill3DRect(this.pieceLength * p.getX(), this.pieceLength * p.getY(), this.pieceLength, this.pieceLength, true);
        }
        
        g.setColor(Color.RED);
        g.fillOval(this.pieceLength * this.game.getApple().getX(), this.pieceLength * this.game.getApple().getY(), this.pieceLength, this.pieceLength);
               
    }

    @Override
    public void update() {
        super.repaint();
    }
}
