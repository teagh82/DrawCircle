import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class DrawCircle extends JFrame{
	
    
    public DrawCircle(){
        setTitle("���콺 �巡���Ͽ� ���׸���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel panel = new MyPanel();
        panel.setLayout(null);
        
        add(panel);
        setSize(400,400);
        setVisible(true);
    }    
    
    class MyPanel extends JPanel{      
    	Point startP = null;
		Point endP = null;
		
		private Vector<Point> vStart = new Vector<Point>();
		private Vector<Point> vEnd = new Vector<Point>(); 
    	
    	public MyPanel(){
    		MyMouseAdapter m = new MyMouseAdapter();
        	this.addMouseListener(m);
    		this.addMouseMotionListener(m);
		}
    	
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            if(vStart.size() != 0){
				for(int i=0;i<vEnd.size();i++){ //����ũ�⸸ŭ
					Point s = vStart.elementAt(i); // ���Ϳ� ��� �ִ� �������� �˾Ƴ���.
					Point e = vEnd.elementAt(i); 
					g.drawOval((int)s.getX()/2, (int)s.getY()/2, (int)e.getX(), (int)e.getX());//�� ���̴ϱ� �̷���
					//g.drawOval((int)s.getX()/2, (int)s.getY()/2, (int)e.getX(), (int)e.getY());
				}
			}
			if(startP != null)
				g.drawOval(startP.x/2, startP.y/2, endP.x, endP.x);	//�� ���̴ϱ� �̷���
				//g.drawOval(startP.x/2, startP.y/2, endP.x, endP.y);
        }
        
        class MyMouseAdapter extends MouseAdapter {        	  	
        	public void mousePressed(MouseEvent e) {
    			startP = e.getPoint(); // ���콺 �����͸� �˾Ƴ���.
    			vStart.add(startP);
            }
        	
            public void mouseReleased(MouseEvent e) {
    			vEnd.add(e.getPoint());
    			endP = e.getPoint();
                repaint();
            }						
        	
        	public void mouseDragged(MouseEvent e) {
        		endP = e.getPoint(); // ���콺 �����͸� �˾Ƴ���.
        		repaint();
            }   
        }
    }
      
    public static void main(String[] args) {
        new DrawCircle();
    }
}
